import java.awt.Color;
import java.awt.Graphics;

/**
 * Tests the drawSquare() and drawCircle() methods
 * @author Suzanne Balik
 */
public class PatternTest {
    /**
     * Draws a small red filled square, a medium blue filled circle, and large green filled square
     * on a diagonal.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400);
        Graphics g = panel.getGraphics();
        Pattern.drawSquare(g, 50, 50, 50, Color.RED); 
        Pattern.drawCircle(g, 100, 100, 100, Color.BLUE);
        Pattern.drawSquare(g, 200, 200, 150, Color.GREEN);       
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");           
    }
}
