package cs5004.animator.EasyAnimator;

import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimationTask;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.ViewTextI;
import cs5004.animator.view.ViewVisualI;
import cs5004.animator.view.VisualView;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;

/**
 * This class represents a EasyAnimator class.
 */
public final class EasyAnimator {

  public static void main(String [] args) throws IOException {
    String output = "";
    String input = "";
    String view = "";
    String speed = "";
    int countLines = 0;
    for (String lines : args) {
      if (lines.equals("-out")) {
        output = args[countLines + 1];
      }
      if (lines.equals("-in")) {
        input = args[countLines + 1];
      }
      if (lines.equals("-view")) {
        view = args[countLines +1];
      }
      if (lines.equals("-speed")) {
        speed = args[countLines +1];
      }
      countLines += 1;

    }

    ViewTextI textView = new TextView(new FileWriter(output,true));

    AnimationBuilder builder = new AnimationModelImpl.Builder();
    AnimationModelImpl model = (AnimationModelImpl) AnimationReader.parseFile(new FileReader(input), builder);


    if (view.equals("text")) {

      if (output.equals("")) {
        ViewTextI viewTxt = new TextView(System.out);
      }
      ViewTextI viewTxt = new TextView(new FileWriter(output));
      viewTxt.show(model);
    }

    if (view.equals("visual")) {
      long parsedSpeed = 1000 / Integer.parseInt(speed);
      ViewVisualI currentView = new VisualView(model.getX(), model.getY(), model.getHeight(),
          model.getWidth(), model.getShapesAtTick(0));

      Timer timer = new Timer();
      AnimationTask task = new AnimationTask(0, model, currentView);
      task.run();
      timer.schedule(task, 0, parsedSpeed);
      currentView.makeVisible();
    }

    if (view.equals("svg")) {
      SVGView svg = new SVGView(new FileWriter(output));
      svg.show(model);
    }

  }

}

