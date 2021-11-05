import static org.junit.Assert.assertEquals;
import java.awt.Color;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
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

/**
 * This is the Junit test class for the AnimationModelImpl.
 */
public class TestAnimationModelImpl {
  AnimationModelInterface o1;
  AnimationModelInterface o2;
  AnimationModelInterface o3;

  @Before
  public void setUp() {
    o1 = new AnimationModelImpl();
    o2 = new AnimationModelImpl();
    o3 = new AnimationModelImpl();
  }

  @Test
  public void testAddShapeAndAnimation() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
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
    ShapeI oval = new Oval(3,5,15,20, Color.CYAN, 5, 55);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15,20), new Point2D(67, 150),
            5, 55, oval);
    o1.addAnimation("O", move1);
    assertEquals("Shapes:\n"
        + "Name: R\n"
        + "Type: Rectangle\n"
        + "Corner(67.0,120.0), Width:6.0, Height: 2.0, Color: (0,0,255)\n"
        + "Appear at t=10\n"
        + "Disappear at t=20\n"
        + "\n"
        + "Name: O\n"
        + "Type: Oval\n"
        + "Corner(15.0,20.0), Width:3.0, Height: 5.0, Color: (0,255,255)\n"
        + "Appear at t=5\n"
        + "Disappear at t=55\n"
        + "\n"
        + "Shape: R changes color from (0,0,255)  to (128,128,128) from t=5 to t=25\n"
        + "Shape: R moves from (67.0,120.0) to (300.0,300.0) from t=1 to t=10\n"
        + "Shape: R scales from Width: 120, Height: 67 to Width: 300, Height: 67 from t=1 to t=10\n"
        + "Shape: O moves from (15.0,20.0) to (67.0,150.0) from t=5 to t=55", o1.toString());
  }

  @Test
  public void testAdd() {
    o1 = new AnimationModelImpl();
    ShapeI rect = new Rectangle("R","rectangle");
    o1.addShape("R",rect);
    rect.setAll(67,120,20,30,1, 5, Color.BLACK);
    AnimationInterface move = new Move(new Point2D(67, 120), new Point2D(300, 300),
            1, 10, rect);
    o1.addAnimation("R", move);
    AnimationInterface move1 = new Move(new Point2D(67, 120), new Point2D(300, 300),
            11, 20, rect);
    o1.addAnimation("R", move1);
    assertEquals("Type: rectangle\n"
        + "Corner(67.0,120.0), Width:20.0, Height: 30.0, Color: (0,0,0)\n"
        + "Appear at t=1\n"
        + "Disappear at t=5\n\n",rect.toString());

  }

  @Test
  public void testAddShapes() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10, 20);
    o1.addShape("R", rectangle);
    ShapeI oval = new Oval(3,5,15,20, Color.CYAN, 5, 55);
    o1.addShape("O", oval);
    assertEquals("Shapes:\n"
        + "Name: R\n"
        + "Type: Rectangle\n"
        + "Corner(67.0,120.0), Width:6.0, Height: 2.0, Color: (0,0,255)\n"
        + "Appear at t=10\n"
        + "Disappear at t=20\n"
        + "\n"
        + "Name: O\n"
        + "Type: Oval\n"
        + "Corner(15.0,20.0), Width:3.0, Height: 5.0, Color: (0,255,255)\n"
        + "Appear at t=5\n"
        + "Disappear at t=55\n",o1.toString());

  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeEmptyIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 50,
            100);
    o1.addShape("", rectangle);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeNullIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 50,
            100);
    o1.addShape(null, rectangle);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeNullShape() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 50,
            100);
    o1.addShape("R", null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveShapeNullIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 50,
            100);
    o1.removeShape(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveShapeEmptyIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 50,
            100);
    o1.removeShape("");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddAnimationNullIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(67, 120), new Point2D(300, 300),
            1, 10, rectangle);
    o1.addAnimation(null, move);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddAnimationEmptyIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(67, 120), new Point2D(300, 300),
            1, 10, rectangle);
    o1.addAnimation("", move);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddAnimationNullAnimation() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(67, 120), new Point2D(300, 300),
            1, 10, rectangle);
    o1.addAnimation("R", null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeSameIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    ShapeI oval = new Oval(3,5,15,20, Color.CYAN, 5, 55);
    o1.addShape("R", oval);
  }

  @Test (expected = NoSuchElementException.class)
  public void testRemoveShapeInvalidIdentifier() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    ShapeI oval = new Oval(3,5,15,20, Color.CYAN, 5, 55);
    o1.addShape("O", oval);
    o1.removeShape("S");
  }

  @Test
  public void testRemoveShape() {
    ShapeI rectangle = new Rectangle(2,6,67,120, Color.BLUE, 10,
            20);
    o1.addShape("R", rectangle);
    ShapeI oval = new Oval(3,5,15,20, Color.CYAN, 5, 55);
    o1.addShape("O", oval);
    o1.removeShape("R");
    assertEquals("Shapes:\n" + "Name: O\n" + "Type: Oval\n" + "Corner(15.0,20.0), Width:"
            + "3.0, Height: 5.0, Color: (0,255,255)\n" + "Appear at t=5\n" + "Disappear at "
            + "t=55\n",o1.toString());
  }

  @Test
  public void testEmptyList() {
    assertEquals("Shapes:",o1.toString());
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
        + "Corner(2.888888888888889,7.555555555555555), Width:100.0, Height: 67.0,"
        + " Color: (0,255,255)\n"
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
  public void testSvg() {
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
    assertEquals("<svg width=\"800\" height=\"800\" version=\"1.1\"\n"
        + "xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R\" x=\"2.0\" y=\"6.0\" width=\"120.0\" height=\"67.0\" "
        + "fill=\"rgb(0,255,255)\" visibility=\"visible\">\n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" "
        + "attributeName=\"rgb\" from=\"(0,0,255)\" to=\"(128,128,128)\" "
        + "fill=\"freeze\" visibility=\"visible\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" "
        + "attributeName=\"x\" from=\"2.0\" to=\"10.0\" fill=\"freeze\" visibility=\"visible\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" "
        + "attributeName=\"y\" from=\"6.0\" to=\"20.0\" fill=\"freeze\" visibility=\"visible\" />\n"
        + "<animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" "
        + "attributeName=\"height\" from=\"67\" to=\"67\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"100ms\" dur=\"900ms\" "
        + "attributeName=\"width\" from=\"120\" to=\"300\" fill=\"freeze\"/>\n"
        + "</rect>\n"
        + "<ellipse id=\"O\" cx=\"3.0\" cy=\"5.0\" rx=\"15.0\" ry=\"20.0\" "
        + "fill=\"rgb(0,255,0)\" visibility=\"visible\">\n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"5000ms\" "
        + "attributeName=\"cx\" from=\"15.0\" to=\"67.0\" fill=\"freeze\" "
        + "visibility=\"visible\" />\n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"5000ms\" "
        + "attributeName=\"cy\" from=\"20.0\" to=\"150.0\" fill=\"freeze\" "
        + "visibility=\"visible\" />\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"1800ms\" "
        + "attributeName=\"ry\" from=\"20\" to=\"50\" fill=\"freeze\"/>\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"1800ms\" "
        + "attributeName=\"rx\" from=\"15\" to=\"50\" fill=\"freeze\"/>\n"
        + "</ellipse>\n"
        + "\n"
        + "</svg>", o1.svgString());
  }

  @Test
  public void testGetShape() {
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
    o1.getShape("O");
    assertEquals("Shapes:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Corner(2.0,6.0), Width:120.0, Height: 67.0, Color: (0,255,255)\n"
        + "Appear at t=1\n"
        + "Disappear at t=10\n"
        + "\n"
        + "Name: O\n"
        + "Type: oval\n"
        + "Corner(3.0,5.0), Width:15.0, Height: 20.0, Color: (0,255,0)\n"
        + "Appear at t=2\n"
        + "Disappear at t=15\n"
        + "\n"
        + "Shape: R changes color from (0,0,255)  to (128,128,128) from t=5 to t=25\n"
        + "Shape: R moves from (2.0,6.0) to (10.0,20.0) from t=1 to t=10\n"
        + "Shape: R scales from Width: 120, Height: 67 to Width: 300, Height: 67 from t=1 to t=10\n"
        + "Shape: O moves from (15.0,20.0) to (67.0,150.0) from t=5 to t=55\n"
        + "Shape: O scales from Width: 15, Height: 20 to Width: 50, Height: 50 from t=2 to t=20",
        o1.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testExceptionNull() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2, 6, 120, 67, 1, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(2, 6), new Point2D(10, 20),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1, 10, 67, 120,
        67, 300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3, 5, 15, 20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15, 20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    AnimationInterface scale1 = new Scale(2, 20, 20, 15,
        50, 50, oval);
    o1.addAnimation("O", scale1);
    o1.getShape(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNotIdentifier() {
    ShapeI rectangle = new Rectangle("R", "rectangle");
    rectangle.setAll(2, 6, 120, 67, 1, 10, Color.CYAN);
    o1.addShape("R", rectangle);
    AnimationInterface move = new Move(new Point2D(2, 6), new Point2D(10, 20),
        1, 10, rectangle);
    o1.addAnimation("R", move);
    AnimationInterface scale = new Scale(1, 10, 67, 120,
        67, 300, rectangle);
    o1.addAnimation("R", scale);
    AnimationInterface color = new ChangeColor(Color.BLUE, Color.GRAY, 5,
        25, rectangle);
    o1.addAnimation("R", color);
    ShapeI oval = new Oval("O", "oval");
    oval.setAll(3, 5, 15, 20, 2, 15, Color.green);
    o1.addShape("O", oval);
    AnimationInterface move1 = new Move(new Point2D(15, 20), new Point2D(67, 150),
        5, 55, oval);
    o1.addAnimation("O", move1);
    AnimationInterface scale1 = new Scale(2, 20, 20, 15,
        50, 50, oval);
    o1.addAnimation("O", scale1);
    o1.getShape("");
  }

}
