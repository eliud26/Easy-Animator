package cs5004.animator.model;

import java.awt.*;

/**
 * This interface supports all the operations for all types of shapes.
 */
public interface ShapeI {

  /**
   * This will get the width of the shape.
   * @return the width
   */
  double getWidth();

  /**
   * This will get the height of the shape.
   * @return the height
   */
  double getHeight();


  /**
   * This will get the color of the shape.
   * @return the color of the shape
   */
  String getColor();

  /**
   * This will get the x coordinate of the shape.
   * @return the x coordinate of the shape
   */
  double getX();

  /**
   * This will get the y coordinate of the shape.
   * @return the y coordinate of the shape
   */
  double getY();

  /**
   * This will create a copy of the shape.
   * @return a new copy of the shape
   */
  ShapeI copy();

  /**
   * This will get the appear tick for a shape.
   * @return the appear tick
   */
  int getAppear();

  /**
   * This will get the disappear tick for a shape.
   * @return the disappear tick
   */
  int getDisappear();

  /**
   * Get the type of shape
   * @return the shape type
   */
  String getShapeType();

  /**
   * Returns a Color object.
   * @return a color object
   */
  Color getColorColor();

  /**
   * Returns a formatted svg string.
   * @return a formatted string
   */
  String svgString();

  /**
   * Returns true if th shape if initialized.
   * @return true or false
   */
  boolean getIsInitialized();

  /**
   * Sets the values for all shapes that has not been initialized.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param width the width of the shape
   * @param height the height of the shape
   * @param startTick the start time of the shape
   * @param endTick the end time od the shape
   * @param color the color of the shape
   */
  void setAll(double x, double y, int width, int height, int startTick, int endTick, Color color);

}
