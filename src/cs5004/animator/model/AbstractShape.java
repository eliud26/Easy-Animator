package cs5004.animator.model;

import java.awt.Color;

/**
 * This is the AbstractShape class which implements all the operations that a shape must have.
 */
public abstract class AbstractShape implements ShapeI {
  protected Point2D point;
  protected Color color;
  protected int startTick;
  protected int endTick;
  protected String shapeType;
  private boolean isInitialized;
  private String name;

  /**
   * This is the constructor to construct an abstract shape object.
   * @param point the (x,y) coordinates of the shape
   * @param color the color of the shape
   * @param startTick the appear tick of the shape
   * @param endTick the disappear of the tick
   */
  public AbstractShape(Point2D point, Color color, int startTick, int endTick, String shapeType) {
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    if (point == null) {
      throw new IllegalArgumentException("Coordinates cannot be null");
    }
    if (startTick < 0 || endTick < 0) {
      throw new IllegalArgumentException("Tick cannot be less than 0");
    }
    this.point = point;
    this.color = color;
    this.startTick = startTick;
    this.endTick = endTick;
    this.shapeType = shapeType;

    this.isInitialized = true;

  }

  /**
   * Second constructor to constructor shapes with a name and type.
   * @param name
   * @param type
   */
  public AbstractShape(String name, String type) {
    this.point = new Point2D(0,0);
    this.name = name;
    this.shapeType = type;
    this.isInitialized = false;
  }

  @Override
  public String getShapeType() {

    return this.shapeType;
  }

  @Override
  public Color getColorColor() {
    return this.color;
  }

  @Override
  public double getX() {

    return this.point.getX();
  }

  @Override
  public double getY() {

    return this.point.getY();
  }

  @Override
  public int getAppear() {
    return startTick;
  }

  @Override
  public int getDisappear() {
    return endTick;
  }

  @Override
  public boolean getIsInitialized() {
    return this.isInitialized;
  }

  /**
   * Returns the name of the shape.
   * @return the name of the shape
   */
  public String getName() {
    return this.name;
  }

  @Override
  public String getColor() {
    String value = "";
    return value += "(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
  }

}
