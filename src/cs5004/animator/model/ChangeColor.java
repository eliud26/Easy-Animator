package cs5004.animator.model;

import java.awt.Color;

/**
 * This is the ChangeColor class which extends the AbstractAnimation and implements
 * the change color animation for a shape.
 */
public class ChangeColor extends AbstractAnimation {
  private Color initialColor;
  private Color endColor;

  /**
   * THis is the constructor to construct a change color animation on a shape.
   * @param initialColor the initial color of the shape
   * @param endColor the color the shape has to be changed to
   * @param startTime the start time of the animation
   * @param endTime the end time of the animation
   * @param shape the shape to be changed colors on
   */
  public ChangeColor(Color initialColor, Color endColor, int startTime, int endTime, ShapeI shape) {
    super(startTime, endTime, shape);
    this.initialColor = initialColor;
    this.endColor = endColor;
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
      Color originalColor = this.initialColor;
      int changeColorRed = this.endColor.getRed() - originalColor.getRed();
      int changeColorGreen = this.endColor.getGreen() - originalColor.getGreen();
      int changeColorBlue = this.endColor.getBlue() - originalColor.getBlue();

      double changeInTime =
              (time - this.getStartTime()) / (double) (this.getEndTime() - this.getStartTime());
      int finalColorRed = (int) (originalColor.getRed() + (changeColorRed * changeInTime));
      int finalColorGreen = (int) (originalColor.getGreen() + (changeColorGreen * changeInTime));
      int finalColorBlue = (int) (originalColor.getBlue() + (changeColorBlue * changeInTime));

      Color newColor = new Color(finalColorRed, finalColorGreen, finalColorBlue);
      if (shape.getShapeType().equals("Rectangle")) {
        return new Rectangle(shape.getHeight(), shape.getWidth(), shape.getX(), shape.getY(),
                newColor, this.getStartTime(), this.getEndTime());
      }
      return new Oval(shape.getHeight(), shape.getWidth(), shape.getX(), shape.getY(),
              newColor, this.getStartTime(), this.getEndTime());
    }
  }

  @Override
  public String toString() {
    String stringResult = "";
    stringResult += String.format("changes color from "  + "(" + initialColor.getRed() + ","
            + initialColor.getGreen() + "," + initialColor.getBlue() + ") " + " to "
            + "(" + endColor.getRed() + "," + endColor.getGreen() + "," + endColor.getBlue() + ") "
            + "from t=" + startTime + " to t=" + endTime + "\n");
    return stringResult;
  }

  @Override
  public String svgString() {
    int movesInSeconds = this.getStartTime() - this.getEndTime();
    return String.format("<animate attributeType="
            + "\"" + "xml" + "\"" + " begin=" + "\"" + 100 * this.startTime + "ms" + "\"" + " dur="
            + "\"" + Math.abs(100 * movesInSeconds) + "ms" + "\"" + " attributeName=" + "\""
            + "rgb" + "\"" + " from=" + "\"" + "("+ this.initialColor.getRed() + ","
            + this.initialColor.getGreen() + "," + this.initialColor.getBlue() + ")" + "\"" + " to="
            + "\"" + "(" + this.endColor.getRed() + "," + this.endColor.getGreen() + ","
            + this.endColor.getBlue() + ")" + "\"" + " fill=" + "\"" + "freeze" + "\""
            + " visibility=" + "\"" + "visible" + "\"" + " />\n");
  }
}