package cs5004.animator.model;

/**
 * This is the Scale class which extends the AbstractAnimation and implements
 * the scaling animation for a shape.
 */
public class Scale extends AbstractAnimation {
  private int initialHeight;
  private int initialWidth;
  private int finalHeight;
  private int finalWidth;

  /**
   * This is the constructor to construct a scaling animation on a shape.
   * @param startTime the start time of the scale animation
   * @param endTime the end time of the scale animation
   * @param initialHeight the height before scaling is executed
   * @param initialWidth the width before scaling is executed
   * @param finalHeight the height after scaling is executed
   * @param finalWidth the width after scaling is executed
   * @param shape the shape to be scaled on
   */
  public Scale(int startTime, int endTime, int initialHeight, int initialWidth, int finalHeight,
               int finalWidth, ShapeI shape) {
    super(startTime, endTime, shape);
    this.initialHeight = initialHeight;
    this.initialWidth = initialWidth;
    this.finalHeight = finalHeight;
    this.finalWidth = finalWidth;
  }

  @Override
  public ShapeI implementsAnimation(double time, ShapeI shape) {
    if (time < startTime) {

      return shape;

    } else if (time > endTime) {

      return shape;
    }
    else {
      double originalHeight = this.initialHeight;
      double changeHeight = this.initialHeight - finalHeight;
      double originalWidth = this.initialWidth;
      double changeWidth = this.initialWidth - finalWidth;

      double changeInTime =
              (time - this.getStartTime()) / (double) (this.getEndTime() - this.getStartTime());
      double endingHeight = originalHeight + (changeHeight * changeInTime);
      double endingWidth = originalWidth + (changeWidth * changeInTime);

      if (shape.getShapeType().equals("Rectangle")) {
        return new Rectangle(endingHeight, endingWidth,
                shape.getX(), shape.getY(), shape.getColorColor(), getStartTime(), getEndTime());
      }
      return new Oval(endingWidth, endingHeight,
                shape.getX(), shape.getY(), shape.getColorColor(), getStartTime(), getEndTime());
    }
  }

  @Override
  public String toString() {
    String result = String.format("scales from Width: " + this.initialWidth + ", Height: "
            + this.initialHeight + " to Width: " + this.finalWidth + ", Height: "
            + this.finalHeight + " from t=" + this.startTime + " to t=" + this.endTime + "\n");
    return result;
  }

  @Override
  public String svgString() {
    int movesInSeconds = this.getEndTime() - this.getStartTime();
    if (shape.getShapeType().equals("rectangle")) {
      return String.format("<animate attributeType=" + "\"" + "xml" + "\"" + " begin="
              + "\"" + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
              + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\""
              + "height" + "\"" + " from=" + "\"" + this.initialHeight + "\"" + " to=" + "\""
              + this.finalHeight + "\"" + " fill=" + "\"" + "freeze" + "\"" + "/>\n"
              + "<animate attributeType=" + "\"" + "xml" + "\"" + " begin="
              + "\"" + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
              + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\""
              + "width" + "\"" + " from=" + "\"" + this.initialWidth + "\"" + " to=" + "\""
              + this.finalWidth + "\"" + " fill=" + "\"" + "freeze" + "\"" + "/>\n");
    }
    return String.format("<animate attributeType=" + "\"" + "xml" + "\"" + " begin="
            + "\"" + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
            + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\""
            + "ry" + "\"" + " from=" + "\"" + this.initialHeight + "\"" + " to=" + "\""
            + this.finalHeight + "\"" + " fill=" + "\"" + "freeze" + "\"" + "/>\n"
            + "<animate attributeType=" + "\"" + "xml" + "\"" + " begin="
            + "\"" + 100 * this.getStartTime() + "ms" + "\"" + " dur=" + "\""
            + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\""
            + "rx" + "\"" + " from=" + "\"" + this.initialWidth + "\"" + " to=" + "\""
            + this.finalWidth + "\"" + " fill=" + "\"" + "freeze" + "\"" + "/>\n");
  }

}
