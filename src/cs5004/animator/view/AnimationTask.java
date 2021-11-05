package cs5004.animator.view;

import cs5004.animator.model.AnimationModelInterface;
import cs5004.animator.model.ShapeI;
import java.util.List;
import java.util.TimerTask;

/**
 * This class represents a AnimationTask object.
 */
public class AnimationTask extends TimerTask {
  private int tick;
  private AnimationModelInterface model;
  private ViewVisualI view;

  /**
   * Constructor for an AnimationTask object.
   * @param tick the time
   * @param model the model
   * @param view the view
   */
  public AnimationTask(int tick, AnimationModelInterface model, ViewVisualI view) {
    this.tick = 0;
    this.model = model;
    this.view = view;
  }

  @Override
  public void run() {
    List<ShapeI> list = model.getShapesAtTick(tick);
    tick++;
    view.refresh(list);
  }
}
