package cs5004.animator.model;

import java.awt.Color;

/**
 * This is the rectangle class which extends the AbstractShape class. This class specifies all the
 * operations that a rectangle can perform.
 */
public class Rectangle extends AbstractShape {
  private double height;
  private double width;

  /**
   * This is the constructor for the rectangle class.
   * @param height the height of the rectangle
   * @param width the width of the rectangle
   * @param x the x coordinate of the rectangle
   * @param y the y coordinate of the rectangle
   * @param color the color of the rectangle
   * @param startTick the appear tick for the rectangle
   * @param endTick the disappear tick for the rectangle
   */
  public Rectangle(double height, double width, double x, double y, Color color,
                   int startTick, int endTick) {
    super(new Point2D(x,y), color, startTick, endTick, "Rectangle");
    this.height = height;
    this.width = width;
  }

  /**
   * Second constructor for this object.
   * @param name the name of the shape
   * @param type the type of the shape
   */
  public Rectangle(String name, String type) {
    super(name, type);
  }

  @Override
  public void setAll(double x, double y, int width, int height, int startTick, int endTick,
      Color color) {
    this.height = height;
    this.width = width;
    this.point.setX(x);
    this.point.setY(y);
    this.startTick = startTick;
    this.endTick = endTick;
    this.color = color;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public double getWidth() {
    return this.width;
  }


  public ShapeI copy() {
    return new Rectangle(this.getHeight() , this.getWidth(),this.point.getX(),this.point.getY(),
            this.color, this.startTick, this.endTick);
  }

  @Override
  public String toString() {
    return String.format("Type: " + this.getShapeType()
            + "\n" + "Corner" + "(" + this.point.getX() + "," + this.point.getY() + ")" + ", Width:"
            + this.getWidth() + ", Height: " + this.getHeight() + ", Color: "
            + this.getColor() + "\n" + "Appear at t=" + this.getAppear() + "\n" + "Disappear at t="
            + this.getDisappear() + "\n\n");
  }

  @Override
  public String svgString() {
    return String.format("<rect id=" + "\"" + this.getName() + "\"" + " x="
        + "\"" + this.point.getX() + "\"" + " y=" + "\"" + this.point.getY() + "\"" + " width="
        + "\"" + this.getWidth() + "\"" + " height=" + "\"" + this.getHeight() + "\"" + " fill="
        + "\"" + "rgb" + this.getColor() + "\"" + " visibility=" + "\"" + "visible" + "\"" + ">\n");

  }
}

