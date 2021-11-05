package cs5004.animator.view;

import cs5004.animator.model.ShapeI;
import java.util.List;

/**
 * This class represents ViewVisual Interface.
 */
public interface ViewVisualI {

  /**
   * Makes the frame visible.
   */
  void makeVisible();

  /**
   * Update the frame to redraw the shape and create animation.
   * @param model the list of shapes
   */
  void refresh(List<ShapeI> model);

}
