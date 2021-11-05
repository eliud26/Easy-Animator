import static org.junit.Assert.assertEquals;

import cs5004.animator.model.AnimationInterface;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationModelInterface;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Move;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;
import cs5004.animator.model.ShapeI;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents a JUnit test for VisualView.
 */
public class TestVisualView {

  AnimationModelInterface o1;

  @Before
  public void setUp(){
    o1 = new AnimationModelImpl();
  }

  @Test
  public void testGetShapesAtTick() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2,6,120,67, 1, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(2, 6), new Point2D(10, 20),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1,10,67,120,
        67,300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3,5,15,20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15,20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    AnimationInterface scale1 = new Scale(2,20,20,15,
        50,50, oval);
    o1.addAnimation("O", scale1);
    assertEquals("[Type: Rectangle\n"
        + "Corner(2.888888888888889,7.555555555555555), Width:100.0, Height: 67.0, "
        + "Color: (0,255,255)\n"
        + "Appear at t=1\n"
        + "Disappear at t=10\n"
        + "\n"
        + ", Type: Oval\n"
        + "Corner(3.0,5.0), Width:15.0, Height: 20.0, Color: (0,255,0)\n"
        + "Appear at t=2\n"
        + "Disappear at t=20\n"
        + "\n"
        + "]", o1.getShapesAtTick(2).toString());
  }

  @Test
  public void testGetShapesAtTickAnimationsDone() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2,6,120,67, 1, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(2, 6), new Point2D(10, 20),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1,10,67,120,
        67,300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3,5,15,20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15,20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    AnimationInterface scale1 = new Scale(2,20,20,15,
        50,50, oval);
    o1.addAnimation("O", scale1);
    assertEquals("[]", o1.getShapesAtTick(60).toString());
  }

  @Test
  public void testGetShapesAtTickEmpty() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2,6,67,120, 2, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(67, 120), new Point2D(300, 300),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1,10,67,120,
        67,300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3,5,15,20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15,20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    assertEquals("[]", o1.getShapesAtTick(0).toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeTick() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2,6,120,67, 1, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(2, 6), new Point2D(10, 20),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1,10,67,120,
        67,300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3,5,15,20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15,20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    AnimationInterface scale1 = new Scale(2,20,20,15,
        50,50, oval);
    o1.addAnimation("O", scale1);
    o1.getShapesAtTick(-1);
  }
}
