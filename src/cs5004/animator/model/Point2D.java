package cs5004.animator.model;

/**
 * This class represents a 2D point. This point is denoted as (x,y).
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * This is the constructor for constructing a 2D point with the given coordinates.
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * This sets the x coordinate of the Point2D.
   * @param x the x coordinate
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * This sets the y coordinate of the Point2D.
   * @param y the y coordinate
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * This gets the x coordinate of this point.
   * @return x coordinate of the point
   */
  public double getX() {
    return x;
  }

  /**
   * This gets the y coordinate of this point.
   * @return y coordinate of this point
   */
  public double getY() {
    return y;
  }
}
