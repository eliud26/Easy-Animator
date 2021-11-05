package cs5004.animator.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import cs5004.animator.util.AnimationBuilder;

/**
 * This is the AnimationModelImpl which encompasses all the operations that the model should
 * implement. This class is to help with storing the information about the shapes.
 */
public class AnimationModelImpl implements AnimationModelInterface {
  private Map<String,ShapeI> listOfShapes;
  private Map<String, List<AnimationInterface>> listOfAnimations;
  private int[] canvasSize;

  /**
   * This is the constructor to construct the a modelImpl object.
   */
  public AnimationModelImpl() {
    listOfShapes = new LinkedHashMap<String, ShapeI>();
    listOfAnimations = new LinkedHashMap<String, List<AnimationInterface>>();
    this.canvasSize = new int[] {0,0,0,0};
  }

  @Override
  public void setCanvasSize(int x, int y, int width, int height) {
    this.canvasSize = new int[] {x,y, width,height};
  }

  @Override
  public int getX() {
    return this.canvasSize[0];
  }

  @Override
  public int getY() {
    return this.canvasSize[1];
  }

  @Override
  public int getWidth() {
    return this.canvasSize[2];
  }

  @Override
  public int getHeight() {
    return this.canvasSize[3];
  }

  /**
   * This class represents a Builder object.
   */
  public static final class Builder implements AnimationBuilder<AnimationModelInterface> {

    private AnimationModelInterface model = new AnimationModelImpl();


    @Override
    public AnimationModelInterface build() {
      return model;
    }

    @Override
    public AnimationBuilder<AnimationModelInterface> setBounds(int x, int y, int width,
        int height) {
      model.setCanvasSize(x,y,width,height);
      return this;

    }

    @Override
    public AnimationBuilder<AnimationModelInterface> declareShape(String name, String type) {
      if (type.equals("rectangle")) {
        model.addShape(name, new Rectangle(name, type));
      }
      else {
        model.addShape(name, new Oval(name, type));
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModelInterface> addMotion(String name, int t1, int x1, int y1,
        int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int
        g2, int b2) {

      if (!model.checkForIsInitialized(name)) {
        model.getShape(name).setAll(x1, y1, w1, h1, t1, t2, new Color(r1, g1, b1));
      }

      Move move = new Move(new Point2D(x1, y1), new Point2D(x2, y2), t1, t2,
              model.getShape(name));

      Scale scale = new Scale(t1, t2, h1, w1, h2, w2, model.getShape(name));

      ChangeColor color =  new ChangeColor(new Color(r1, g1, b1), new Color(r2, g2, b2), t1,
              t2, model.getShape(name));
      AllAnimations all = new AllAnimations(t1, t2, move, scale, color, model.getShape(name));
      model.addAnimation(name, all);

      return this;
    }
  }

  @Override
  public void addShape(String identifier, ShapeI shape) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Invalid identifier");
    }
    if (shape ==  null) {
      throw new IllegalArgumentException("Shape cannot be null");
    }
    if (listOfShapes.containsKey(identifier)) {
      throw new IllegalArgumentException("A shape with that identifier already exists.");
    }
    listOfShapes.put(identifier,shape);
    listOfAnimations.put(identifier, new ArrayList<>());
  }

  @Override
  public void removeShape(String identifier) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Invalid identifier");
    }
    if (!(listOfShapes.containsKey(identifier))) {
      throw new NoSuchElementException("A shape with that identifier does not exist.");
    }
    listOfShapes.remove(identifier);
    listOfAnimations.remove(identifier);
  }

  @Override
  public void addAnimation(String identifier, AnimationInterface animation) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Invalid identifier");
    }
    if (animation == null) {
      throw new IllegalArgumentException("Invalid identifier");
    }
    Comparator<AnimationInterface> comparator = new Comparator<AnimationInterface>() {
      @Override
      public int compare(AnimationInterface o1, AnimationInterface o2) {
        if (o1.getStartTime() > o2.getStartTime()) {
          return -1;

        } else if (o1.getStartTime() < o2.getStartTime()) {
          return 1;
        }
        return 0;
      }
    };
    listOfAnimations.get(identifier).add(animation);
    Collections.sort(listOfAnimations.get(identifier), comparator);
  }

  @Override
  public List<ShapeI> getShapesAtTick(int tick) {
    if (tick < 0) {
      throw new IllegalArgumentException("Tick cannot be negative");
    }
    List<ShapeI> animationList = new ArrayList<>();
    for (Map.Entry<String, List<AnimationInterface>> pair : listOfAnimations.entrySet()) {
      ShapeI accumulate = listOfShapes.get(pair.getKey()).copy();
      for (AnimationInterface target : pair.getValue()) {
        accumulate = target.implementsAnimation(tick, accumulate);
      }
      if( accumulate.getAppear() <= tick && accumulate.getDisappear() >= tick) {
        animationList.add(accumulate);
      }
    }
    return animationList;
  }

  @Override
  public String toString() {
    String stringResult = "Shapes:\n";
    for (Map.Entry<String, ShapeI> pair : listOfShapes.entrySet()) {
      stringResult += "Name: " + pair.getKey() + "\n" + listOfShapes.get(pair.getKey()).toString();
    }
    for (Map.Entry<String, List<AnimationInterface>> pair : listOfAnimations.entrySet()) {
      for (AnimationInterface target : pair.getValue()) {
        stringResult += "Shape: " + pair.getKey() + " " + target.toString();
      }
    }

    return stringResult.substring(0,stringResult.length() - 1);
  }

  @Override
  public ShapeI getShape(String identifier) {
    if (identifier == null) {
      throw new IllegalArgumentException("Identifier cannot be null");
    }
    if (identifier.equals("")) {
      throw new IllegalArgumentException("Identifier empty string");
    }
    return listOfShapes.get(identifier);
  }

  @Override
  public String svgString() {
    String stringResult = String.format("<svg width=" + "\"" + 800 + "\""
            + " height=" + "\"" + 800 + "\"" + " version=\"1.1\"\n"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n");
    for (Map.Entry<String, ShapeI> pair : listOfShapes.entrySet()) {
      stringResult += listOfShapes.get(pair.getKey()).svgString();
      for (Map.Entry<String, List<AnimationInterface>> pairList : listOfAnimations.entrySet()) {
        for (AnimationInterface target : pairList.getValue()) {
          if (pair.getKey().equals(pairList.getKey())) {
            stringResult += target.svgString();
          }
        }
      }
      if (listOfShapes.get(pair.getKey()).getShapeType().equals("rectangle")) {
        stringResult += "</rect>\n";
      }
      else {
        stringResult += "</ellipse>\n";
      }
    }
    return stringResult + "\n</svg>";
  }

  @Override
  public boolean checkForIsInitialized(String name) {
    return listOfShapes.get(name).getIsInitialized();
  }

}