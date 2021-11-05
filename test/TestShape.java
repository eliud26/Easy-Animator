import static org.junit.Assert.assertEquals;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.ShapeI;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the Junit test class for ShapeI interface.
 */
public class TestShape {
  ShapeI rec;
  ShapeI oval;


  @Before
  public void setUp() {
    rec = new Rectangle(25, 30, 45,30, Color.red, 20,40);
    oval = new Oval(34,32,64,12, Color.black, 15, 35);
  }

  @Test
  public void testConstructor() {
    rec = new Rectangle(25, 30, 45,30, Color.red, 20,40);
    assertEquals(25,rec.getHeight(),0.001);
    assertEquals(30,rec.getWidth(),0.001);
    assertEquals(45,rec.getX(),0.001);
    assertEquals(30,rec.getY(),0.001);
    assertEquals("(255,0,0)",rec.getColor());
    assertEquals(20,rec.getAppear());
    assertEquals(40,rec.getDisappear());
  }

  @Test
  public void testGetHeightReC() {
    assertEquals(25, rec.getHeight(), 0.01);
  }

  @Test
  public void testGetRadiusYOval() {
    assertEquals(32, oval.getHeight(), 0.01);
  }

  @Test
  public void testGetWidthReC() {
    assertEquals(30, rec.getWidth(), 0.01);
  }

  @Test
  public void testGetRadiusXOval() {
    assertEquals(34, oval.getWidth(), 0.01);
  }

  @Test
  public void testCopyRec() {
    assertEquals("(255,0,0)", rec.getColor());
  }

  @Test
  public void testToString() {
    assertEquals("Type: Rectangle\n"
        + "Corner(45.0,30.0), Width:30.0, Height: 25.0, Color: (255,0,0)\n"
        + "Appear at t=20\n"
        + "Disappear at t=40\n"
        + "\n", rec.toString());
  }

  @Test
  public void testPoint2DGetX() {
    Point2D point = new Point2D(2,4);
    assertEquals(2, point.getX(), 0.01);
  }

  @Test
  public void testPoint2DGetY() {
    Point2D point = new Point2D(2,4);
    assertEquals(4, point.getY(), 0.01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorTest() {
    rec = new Rectangle(-25, -30, -45,-30, null, -20,-40);
  }
}
