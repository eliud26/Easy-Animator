package cs5004.animator.view;

import cs5004.animator.model.AnimationModelInterface;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * This class represents a SVGView Object.
 */
public class SVGView {
  private Appendable svgResult;

  /**
   * Constructor for a SVGView object.
   * @param svgResult the
   */
  public SVGView(Appendable svgResult) {
    this.svgResult = svgResult;
  }

  /**
   * Displays the svg text view.
   * @param animations the list of shapes and their animations
   * @throws IOException
   */
  public void show(AnimationModelInterface animations) throws IOException {
    if (animations == null) {
      throw new IllegalArgumentException("Object cannot be null");
    }
    BufferedWriter buffer = new BufferedWriter((FileWriter)this.svgResult);
    buffer.write(animations.svgString());
    buffer.close();
  }
}