import static org.junit.Assert.assertEquals;
import cs5004.animator.model.AnimationInterface;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Move;
import cs5004.animator.model.Point2D;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

/**
 * This is the Junit test class for the AnimationInterface.
 */
public class TestAnimation {
  AnimationInterface a1;
  AnimationInterface a2;
  AnimationInterface a3;

  @Before
  public void setUp() {
    Rectangle rec = new Rectangle(1,2,3,4, Color.BLACK,6,7);
    a1 = new Move((new Point2D(67, 120)), new Point2D(300, 300),1,
            10, rec);
    a2 = new ChangeColor(Color.BLUE, Color.GRAY, 5, 25, rec);
    a3 = new Scale(1,10,67,120, 67,
            300, rec);
  }

  @Test
  public void testConstructor() {
    assertEquals(1,a1.getStartTime());
    assertEquals(10,a1.getEndTime());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    a1 = new Move((new Point2D(67, 120)), new Point2D(300, 300),-1,
            -10, null);
  }

  @Test
  public void testToString() {
    assertEquals("moves from (67.0,120.0) to (300.0,300.0) "
            + "from t=1 to t=10\n",a1.toString());
    assertEquals("changes color from (0,0,255)  to (128,128,128) from t=5 to t=25"
            + "\n", a2.toString());
    assertEquals("scales from Width: 120, Height: 67 to Width: 300, Height: 67 "
            + "from t=1 to t=10\n",a3.toString());
  }
}
