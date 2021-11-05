package cs5004.animator.model;

/**
 * This class represents an AllAnimations object.
 */
public class AllAnimations extends AbstractAnimation {
  private Move move;
  private ChangeColor color;
  private Scale scale;

  /**
   * This is the constructor to construct an animation object.
   * @param startTime the start time of the animation
   * @param endTime the end time of the animation
   * @param shape the shape to add an animation to
   */
  public AllAnimations(int startTime, int endTime, Move move, Scale scale, ChangeColor color,
                       ShapeI shape) {
    super(startTime, endTime, shape);
    this.move = move;
    this.color = color;
    this.scale = scale;
  }

  @Override
  public ShapeI implementsAnimation(double time, ShapeI shape) {
    shape = this.move.implementsAnimation(time, shape);
    shape = this.scale.implementsAnimation(time, shape);
    shape = this.color.implementsAnimation(time, shape);
    return shape;
  }

  @Override
  public String toString() {
    return String.format(move.toString() + "\n" + scale.toString() + "\n" + color.toString());
  }

  @Override
  public String svgString() {
    return String.format(move.svgString() + scale.svgString() + color.svgString());
  }
}