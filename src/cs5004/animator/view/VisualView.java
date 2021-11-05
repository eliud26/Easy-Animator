package cs5004.animator.view;

import cs5004.animator.model.ShapeI;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class represents a VisualView object.
 */
public class VisualView extends JFrame implements ViewVisualI {
  private JButton btnReset;
  private JButton btnPause;
  private JButton btnContinue;
  private JLabel result;
  private JTextField one;
  private JTextField two;
  private JTextField three;
  private PanelView panel;

  /**
   * Constructor for this VisualView object.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param canvasHeight the canvas height
   * @param canvasWidth the canvas width
   * @param shapes the list of shapes
   */
  public VisualView(int x, int y, int canvasHeight, int canvasWidth, List<ShapeI> shapes) {
    super("Easy Animator");
    setBounds(x + 250, y + 250, canvasWidth + 250, canvasHeight + 250);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    panel = new PanelView(x, y, canvasHeight, canvasWidth, shapes);
    this.add(panel);
  }

  /**
   * Sets up the action buttons.
   * @param btnResetListener the reset button
   * @param btnPauseListener the pause button
   * @param btnContinueListener the continue button
   */
  public void setActions(ActionListener btnResetListener, ActionListener btnPauseListener,
      ActionListener btnContinueListener) {
    this.btnReset.addActionListener(btnResetListener);
    this.btnPause.addActionListener(btnPauseListener);
    this.btnContinue.addActionListener(btnContinueListener);

  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh(List<ShapeI> model) {
    this.panel.updatePanel(model);
    this.repaint();
  }

}
