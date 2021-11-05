package cs5004.animator.model;

import java.awt.Color;

/**
 * This is the oval class which extends the AbstractShape class. This class specifies all the
 * operations that an oval can perform.
 */
public class Oval extends AbstractShape {
  private double xRadius;
  private double yRadius;

  /**
   * This is the constructor for the oval class.
   * @param xRadius the xRadius of the oval
   * @param yRadius the yRadius of the oval
   * @param x the x coordinate of the oval
   * @param y the y coordinate of the oval
   * @param color the color of the oval
   * @param startTick the appear tick for the oval
   * @param endTick the disappear tick for the oval
   */
  public Oval(double xRadius, double yRadius, double x, double y, Color color, int startTick,
              int endTick) {
    super(new Point2D(x,y), color, startTick, endTick, "Oval");
    if (xRadius < 0 || yRadius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative numbers");
    }
    this.xRadius = xRadius;
    this.yRadius = yRadius;
  }

  /**
   * Second constructor for this object.
   * @param name the name of the shape
   * @param type the type of the shape
   */
  public Oval(String name, String type) {
    super(name, type);

  }

  @Override
  public void setAll(double x, double y, int width, int height, int startTick, int endTick,
      Color color) {
    this.yRadius = height;
    this.xRadius = width;
    this.point.setX(x);
    this.point.setY(y);
    this.startTick = startTick;
    this.endTick = endTick;
    this.color = color;
  }

  @Override
  public double getWidth() {
    return this.xRadius;
  }

  @Override
  public double getHeight() {
    return this.yRadius;
  }

  @Override
  public ShapeI copy() {
    return new Oval(this.getHeight(),this.getWidth(),this.point.getX(),this.point.getY(),
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
    return String.format("<ellipse id=" + "\"" + this.getName() + "\"" + " cx="
        + "\"" + this.point.getX() + "\"" + " cy=" + "\"" + this.point.getY() + "\"" + " rx="
        + "\"" + this.getWidth() + "\"" + " ry=" + "\"" + this.getHeight() + "\"" + " fill="
        + "\"" + "rgb" + "(" + color.getRed() + "," + color.getGreen()
        + "," + color.getBlue() + ")" + "\"" + " visibility=" + "\"" + "visible" + "\"" + ">\n");

  }

}