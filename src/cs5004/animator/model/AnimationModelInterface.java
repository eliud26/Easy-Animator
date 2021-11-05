package cs5004.animator.model;

import java.util.List;

/**
 * This interface has all the operations that the model should implement.
 */
public interface AnimationModelInterface {

  /**
   * This adds a shape to the list of stored shapes.
   * @param identifier the name of the shape in the list
   * @param shape the name of the shape
   */
  void addShape(String identifier, ShapeI shape);

  /**
   * Tis removes the shape from the list of stored shapes.
   * @param identifier the name of the shape in the list
   */
  void removeShape(String identifier);


  /**
   * This adds the animation to the shape and stores it in a list of animation.
   * @param identifier the name of the animation in the list
   * @param animation the type of animation to be used on the shape
   */
  void addAnimation(String identifier, AnimationInterface animation);

  /**
   * Gets a list of shapes at the specified tick.
   * @param tick the time that the shape takes place at
   * @return a list of shapes
   */
  List<ShapeI> getShapesAtTick(int tick);

  /**
   * Gets a shape from the data structure that stores the shapes.
   * @param identifier the key for the shape
   * @return a shape
   */
  ShapeI getShape(String identifier);

  /**
   * Returns true if the shape is initialized, false otherwise.
   * @param name the key for the shape
   * @return true or false
   */
  boolean checkForIsInitialized(String name);

  /**
   * Sets the size of the canvas.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param width the width of the canvas
   * @param height the height of the canvas
   */
  void setCanvasSize(int x, int y, int width, int height);

  /**
   * Returns the x coordinate.
   * @return x coordinate
   */
  int getX();

  /**
   * Returns the y coordinate.
   * @return the y coordinate
   */
  int getY();

  /**
   * Returns the width of the canvas.
   * @return the width of the canvas
   */
  int getWidth();

  /**
   * Returns the height of the canvas.
   * @return the height of the canvas
   */
  int getHeight();

  /**
   * Returns a formatted svg string.
   * @return a formatted string
   */
  String svgString();
}
