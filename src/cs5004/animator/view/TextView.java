package cs5004.animator.view;

import cs5004.animator.model.AnimationModelInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents a TextView object.
 */
public class TextView implements ViewTextI {
  Appendable out;
  AnimationModelInterface listResult;
  String stringView;

  /**
   * Constructor for the TextView object.
   * @param output where the output would be written to
   */
    public TextView(Appendable output) {

      out = output;
    }

    @Override
    public void show(AnimationModelInterface listResult) throws IOException {
      if (listResult == null) {
        throw new IllegalArgumentException("Object cannot be null");
      }
      BufferedWriter buffer = new BufferedWriter((FileWriter) this.out);
      buffer.write(listResult.toString());
      buffer.close();
    }

}
