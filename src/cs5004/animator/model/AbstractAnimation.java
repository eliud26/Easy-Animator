package cs5004.animator.model;

/**
 * This is the abstract animation which implements all the operation on an animation.
 */
public abstract class AbstractAnimation implements AnimationInterface {
  protected int startTime;
  protected int endTime;
  protected ShapeI shape;

  /**
   * This is the constructor to construct an abstract animation object.
   * @param startTime the start time of the animation
   * @param endTime the end time of the animation
   * @param shape the shape to add an animation to
   */

  public AbstractAnimation(int startTime, int endTime, ShapeI shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Object shape cannot be null");
    }
    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Ticks cannot be negative numbers");
    }
    this.startTime = startTime;
    this.endTime = endTime;
    this.shape = shape;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

}
