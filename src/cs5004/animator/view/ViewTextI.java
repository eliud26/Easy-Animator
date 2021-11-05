package cs5004.animator.view;

import cs5004.animator.model.AnimationModelInterface;
import java.io.IOException;

/**
 * This class represents a ViewText interface3.
 */
public interface ViewTextI {

  /**
   * Prints out the text result from the given file.
   * @param listResult the model that holds information
   */
  void show(AnimationModelInterface listResult) throws IOException;


}
