package cs5004.animator.view;

import cs5004.animator.model.ShapeI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class represents a PanelView object.
 */
public class PanelView extends JPanel {
  private List<ShapeI> listShape;

  /**
   * Constructor for a PanelView object.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param panelHeight the panel height
   * @param panelWidth the panel width
   * @param model the model that contains information
   */
  public PanelView(int x, int y, int panelHeight, int panelWidth, List<ShapeI> model) {
    super(true);
    this.setLocation(x, y);
    this.setSize(panelWidth, panelHeight);
    this.listShape = model;
  }

  /**
   * Update the panel.
   * @param model the model that contains information
   */
  public void updatePanel(List<ShapeI> model) {
    this.listShape = model;

  }

 @Override
  public void paintComponent(Graphics g) {

   super.paintComponent(g);

   Graphics2D graphics = (Graphics2D) g;

   for (ShapeI target : listShape) {
     if (target.getShapeType().equals("Rectangle")) {
       graphics.setColor(target.getColorColor());
       graphics.drawRect((int) target.getX(), (int) target.getY(), (int) target.getWidth(),
           (int) target.getHeight());
       graphics.fillRect((int) target.getX(), (int) target.getY(), (int) target.getWidth(),
           (int) target.getHeight());
     }
     else if (target.getShapeType().equals("Oval")) {
       graphics.setColor(target.getColorColor());
       graphics.drawOval((int) target.getX(), (int) target.getY(), (int) target.getHeight(),
           (int) target.getWidth());
       graphics.fillOval((int) target.getX(), (int) target.getY(), (int) target.getHeight(),
           (int) target.getWidth());
     }
   }
 }
}
