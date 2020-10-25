import java.util.*;     //imports the Scanner class
import java.awt.*;      //imports the Graphics class
/**
 * Prompts the user to input a series of values that 
 * determine the number of rows, columns and custom
 * color of the pattern to be drawn.  The DrawingPanel
 * will be sized to fit the pattern specification exactly
 * 
 * @author David Hines
 */
public class Pattern {
    /** Shape size constant as shapes are symetric (i.e. width and height are the same)*/
    public static final int SHAPE_SIZE = 50;
    
    /** Minimum panel value */
    public static final int MIN_PANEL = 1;
    
    /** Maximum panel value */
    public static final int MAX_PANEL = 10;
    
    /** Minimum color value */
    public static final int MIN_COLOR = 0;
    
    /** Maximum color value */
    public static final int MAX_COLOR = 255;
    
    /**
     * Starts the program in main
     *
     * @param args  commandline arguments (not used)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println();
        
        System.out.print("Number of rows (1-10): ");
        int rows = console.nextInt();
        if (rows < MIN_PANEL ) {
            rows = MIN_PANEL;
        }
        if (rows > MAX_PANEL) {
            rows = MAX_PANEL;
        } 
            
        System.out.print("Number of columns (1-10): ");
        int columns = console.nextInt();
        if (columns < MIN_PANEL) {
            columns = MIN_PANEL;
        }
        if (columns > MAX_PANEL) {
            columns = MAX_PANEL;
        }
        
        System.out.print("Red value (0-255): ");
        int red = console.nextInt();
        if (red < MIN_COLOR){
            red = MIN_COLOR;
        }
        if (red > MAX_COLOR) {
            red = MAX_COLOR;
        }    
        
        System.out.print("Green value (0-255): ");
        int green = console.nextInt();
        if (green < MIN_COLOR ){
            green = MIN_COLOR;
        }
        if (green > MAX_COLOR) {
            green = MAX_COLOR;
        }      
        
        System.out.print("Blue value (0-255): ");
        int blue = console.nextInt();
        if (blue < MIN_COLOR ){
            blue = MIN_COLOR;
        }
        if (blue > MAX_COLOR) {
            blue = MAX_COLOR;
        }     
        
        System.out.println();
                
        System.out.print("*CLOSE the Drawing Panel to exit the program*");
        
        //use input to draw the proper panel size and create the custom color
        int panelHeight = rows * SHAPE_SIZE;
        int panelWidth = columns * SHAPE_SIZE;
        DrawingPanel panel = new DrawingPanel(panelWidth, panelHeight);
        Graphics g = panel.getGraphics();
        Color squareColor = new Color(red, green, blue);
        Color circleColor = new Color(MAX_COLOR - red, MAX_COLOR - green, MAX_COLOR - blue);
        
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int x = (i) * SHAPE_SIZE;
                int y = (j) * SHAPE_SIZE;
                drawSquare(g, x, y, SHAPE_SIZE, squareColor);
                drawCircle(g, x, y, SHAPE_SIZE, circleColor);  
            }
        }
    }
    
    /**
     * Draws the square shape of proper color at designated coordinates
     * @param g  the graphics object pen for drawing the shapes
     * @param x  the x axis coordinate for the shape
     * @param y  the y axis coordinate for the shape
     * @param width  the standard width of the shapes to be drawn
     * @param color  the custom color selected by the user
     */
    public static void drawSquare(Graphics g, int x, int y, int width, Color color) {
        g.setColor(color);
        int height = width;
        g.fillRect(x, y, width, height);
        
    }
    
    
    /**
     * Draws the circle shape of proper color at designated coordinates
     * @param g  the graphics object pen for drawing the shapes
     * @param x  the x axis coordinate for the shape
     * @param y  the y axis coordinate for the shape
     * @param width  the standard width of the shapes to be drawn
     * @param color  the custom color selected by the user
     */
    public static void drawCircle(Graphics g, int x, int y, int width, Color color) {
        g.setColor(color);
        int height = width;
        g.fillOval(x, y, width, height);
        
    }    
}    