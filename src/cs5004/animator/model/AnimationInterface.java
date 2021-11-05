package cs5004.animator.model;

/**
 * This interface has all the operations that an animation must implement.
 */
public interface AnimationInterface {
  /**
   * Get the start time of the animation.
   * @return the start time of the animation
   */
  int getStartTime();

  /**
   * Get the end time of the animation.
   * @return the end time of the animation
   */
  int getEndTime();

  /**
   * Calculates where the shapes where are going to appear.
   * @param time the time where the shapes are going to appear
   * @param shape the shape for animation
   * @return a shape with its calculated animation
   */
  ShapeI implementsAnimation(double time, ShapeI shape);

  /**
   * Gets a string representation of the shape and animations.
   * @return a formatted string
   */
  String toString();

  /**
   * Gets a string representation of svg for the shape and animations.
   * @return a formatted string
   */
  String svgString();
}
