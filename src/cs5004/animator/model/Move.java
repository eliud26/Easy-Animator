package cs5004.animator.model;

/**
 * This is the Move class which extends the AbstractAnimation and implements
 * the move animation for a shape.
 */
public class Move extends AbstractAnimation {
  private Point2D start;
  private Point2D end;

  /**
   * This is the constructor to construct a move animation on a shape.
   * @param start the initial (x,y) coordinates of the shape
   * @param end the (x,y) coordinates that the shape has to be moved to
   * @param startTime the start time of the animation
   * @param endTime the end time of the animation
   * @param shape the shape to be moved
   */
  public Move(Point2D start, Point2D end, int startTime, int endTime, ShapeI shape) {
    super(startTime,endTime, shape);
    if (start == null || end == null) {
      throw new IllegalArgumentException("Object coordinates cannot be null");
    }
    this.start = start;
    this.end = end;
  }

  @Override
  public ShapeI implementsAnimation(double time, ShapeI shape) {

    if (time < startTime) {
      return shape;
    }

    else if (time > endTime) {

      return shape;
    }

    else {
      double originalX = this.start.getX();
      double originalY = this.start.getY();
      double changeX = this.end.getX() - originalX;
      double changeY = this.end.getY() - originalY;

      double changeInTime =
              (time - this.getStartTime()) / (double) (this.getEndTime() - this.getStartTime());
      double finalX = originalX + (changeX * changeInTime);
      double finalY = originalY + (changeY * changeInTime);

      if (shape.getShapeType().equals("Rectangle")) {
        return new Rectangle(shape.getHeight(), shape.getWidth(), finalX,
                finalY, shape.getColorColor(), shape.getAppear(), shape.getDisappear());
      }
        return new Oval(shape.getHeight(), shape.getWidth(), finalX,
                finalY, shape.getColorColor(), shape.getAppear(), shape.getDisappear());
      }
    }

  @Override
  public String toString() {
    String result = String.format("moves from " + "(" + this.start.getX() +  "," + this.start.getY()
            + ") " + "to " + "(" + this.end.getX() + "," + this.end.getY() + ") from "
            + "t=" + this.startTime + " to t=" + this.endTime + "\n");
    return result;
  }

  @Override
  public String svgString() {
    int movesInSeconds = this.getStartTime() - this.getEndTime();
    if (shape.getShapeType().equals("rectangle")) {
      return String.format("<animate attributeType=" + "\"" + "xml" + "\"" + " begin=" + "\""
              + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
              + Math.abs(100 * movesInSeconds)
              + "ms" + "\"" + " attributeName=" + "\"" + "x" + "\"" + " from=" + "\""
              + this.start.getX() + "\"" + " to=" + "\"" + this.end.getX() + "\"" + " fill="
              + "\"" + "freeze" + "\"" + " visibility=" + "\"" + "visible" + "\"" + " />\n"
              + "<animate attributeType=" + "\"" + "xml" + "\"" + " begin=" + "\""
              + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
              + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\"" + "y" + "\""
              + " from=" + "\"" + this.start.getY() + "\"" + " to=" + "\"" + this.end.getY() + "\""
              + " fill=" + "\"" + "freeze" + "\"" + " visibility=" + "\"" + "visible" + "\""
              + " />\n");
    }
    else {
      return String.format("<animate attributeType=" + "\"" + "xml" + "\"" + " begin=" + "\""
          + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
          + Math.abs(100 * movesInSeconds)
          + "ms" + "\"" + " attributeName=" + "\"" + "cx" + "\"" + " from=" + "\""
          + this.start.getX() + "\"" + " to=" + "\"" + this.end.getX() + "\"" + " fill="
          + "\"" + "freeze" + "\"" + " visibility=" + "\"" + "visible" + "\"" + " />\n"
          + "<animate attributeType=" + "\"" + "xml" + "\"" + " begin=" + "\""
          + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
          + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\"" + "cy" + "\""
          + " from=" + "\"" + this.start.getY() + "\"" + " to=" + "\"" + this.end.getY() + "\""
          + " fill=" + "\"" + "freeze" + "\"" + " visibility=" + "\"" + "visible" + "\""
          + " />\n");
    }
  }

}
