import java.awt.*;
import java.util.*;

/**
 * Animation program to draw a background and number
 * of figures that emulate motion in the drawing panel
 * Utilizes methods for the various figures which 
 * are called from the main method
 *
 * @author David Hines
 */

public class Animation {
    
    /** width of the drawing panel */
    public static final int WIDTH = 900;
    
    /** height of the drawing panel */
    public static final int HEIGHT = 450;
    
    /** sleep time (ms) between drawing figures */
    public static final int SLEEP_TIME = 80;
    
    /** initial x position of the animated figure */
    public static final int INITIAL_X = 194;
    
    /** initial y position of the animated figure */
    public static final int INITIAL_Y = 430;
    
    /** number of updates to drawing panel for animation */
    public static final int NUMBER_OF_UPDATES = 150;
    
    /** delta in the x position of the figure every update */
    public static final int DX = 5;
    
    /** delta in the y position of the figure every update */
    public static final int DY = 2;
    
    /** delta in the size (both width and/or height) of the figures */
    public static final int DS = 1;
    
    /** delta in the location (x and/or y) of the figures */
    public static final int DL = 2;
      
    /**
     * Starts the animation program 
     * 
     * @param args  command line arguments (not used)
     */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        panel.setBackground(Color.DARK_GRAY);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {            
            drawBackground(g);            
            drawRocket(g, x, y - DY * i, DL * i);
            if (i <= NUMBER_OF_UPDATES / 3) {
                drawSmokeClouds(g, x, y, DS + i, DL + i);
            } else {
                drawSmokeClouds(g, x, y, DS + i / 2, DL + i / 2); 
            }    
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    /**
     * Draws a night sky with moon and stars as well
     * as a platform and some green hills of varrying shades.
     * @param g  Graphics object to draw the background items
     */
    public static void drawBackground(Graphics g) {
        //g.setColor(Color.DARK_GRAY);
        //g.fillRect(0,0,WIDTH,HEIGHT);
        
        Polygon platform = new Polygon();
        Polygon bigHill = new Polygon();
        Polygon medHill = new Polygon();
        Polygon smHill = new Polygon();
        
        //Draw stars in the sky
        g.setColor(Color.WHITE);
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 5; j++) {
                g.drawString("*", i * 45, j * 25);
            }
        }
        
        //Draw moon in gray
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(750, 25, 100, 100);
        
        //draw clouds over Moon
        Color lightClouds = new Color(252, 250, 250, 100);
        g.setColor(lightClouds);
        g.fillOval(735, 42, 85, 5);
        g.fillOval(770, 38, 65, 4);
        g.fillOval(760, 76, 120, 8);
        g.fillOval(720, 84, 140, 7);     
        
        //Draw the rocket platform
        platform.addPoint(70, 430);
        platform.addPoint(55, 450);
        platform.addPoint(278, 450);
        platform.addPoint(263, 430);
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(platform);
                          
        //draw hill side in a new green
        Color hillGreenDark = new Color(28, 155, 79);
        g.setColor(hillGreenDark);
        bigHill.addPoint(506, 450);
        bigHill.addPoint(900, 450);
        bigHill.addPoint(900, 364);
        bigHill.addPoint(820, 310);
        bigHill.addPoint(764, 310);
        g.fillPolygon(bigHill);
        
        //draw hill side in a new green
        Color hillGreedMed = new Color(18,178,82);
        g.setColor(hillGreedMed);
        medHill.addPoint(725, 450);
        medHill.addPoint(600, 355);
        medHill.addPoint(550, 355);
        medHill.addPoint(370, 450);        
        g.fillPolygon(medHill);
                              
    }
    
    
    /**
     * Draws a Rocket figure that starts on the platform
     * at bottom of the drawing panel.
     * @param g  Graphics object to drawn the figure shapes
     * @param x  the initial x coordinate and center reference of figure
     * @param y  the initial y coordinate and baseline reference of figure
     * @param dl  location adjustment for some figures and components
     * 
     */
    public static void drawRocket(Graphics g, int x, int y, int dl) {
                
        Polygon grayCover = new Polygon();
        Polygon noseCone = new Polygon();
        Polygon finLeft = new Polygon();
        Polygon finRight = new Polygon();
        Polygon thrustBig = new Polygon();
        Polygon thrustMed = new Polygon();
        Polygon thrustSm = new Polygon();
                
        //Draw gray polygon to cover artifacts
        grayCover.addPoint(x - 38, (y + 1) - (dl * 2));
        grayCover.addPoint(x, (y + 10) - (dl / 2)); //extends every draw
        grayCover.addPoint(x + 38, (y + 1) - (dl * 2));
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(grayCover);
        
               
        //Draw Rocket Body
        g.setColor(Color.WHITE);
        g.fillRect(x - 14, (y - 130) - (dl * 2), 28, 125);
        g.setColor(Color.BLACK);
        g.drawRect(x - 14, (y - 130) - (dl * 2), 28, 125);
                
        //Draw nose cone polygon
        noseCone.addPoint(x, (y - 175) - (dl * 2));
        noseCone.addPoint(x - 14, (y - 130) - (dl * 2));
        noseCone.addPoint(x + 14, (y - 130) - (dl * 2));
        g.setColor(Color.WHITE);
        g.fillPolygon(noseCone);        
        g.setColor(Color.BLACK);
        g.drawPolygon(noseCone);
                
        //Draw left fin of rocket
        finLeft.addPoint(x - 14, (y - 50) - (dl * 2));
        finLeft.addPoint(x - 14, y - (dl * 2));
        finLeft.addPoint(x - 30, y - (dl * 2));        
        g.setColor(Color.WHITE);
        g.fillPolygon(finLeft);
        g.setColor(Color.BLACK);
        g.drawPolygon(finLeft);
        
        //Draw right fin of rocket
        finRight.addPoint(x + 14, (y - 50) - (dl * 2));
        finRight.addPoint(x + 14, y - (dl * 2));
        finRight.addPoint(x + 30, y - (dl * 2));
        g.setColor(Color.WHITE);
        g.fillPolygon(finRight);
        g.setColor(Color.BLACK);
        g.drawPolygon(finRight);
                
        //Draw big thrust polygon
        thrustBig.addPoint(x - 10, (y - 5) - (dl * 2));
        thrustBig.addPoint(x - 14, (y + 1) - (dl * 2));
        thrustBig.addPoint(x, (y + 5) - dl); //extends every draw
        thrustBig.addPoint(x + 14, (y + 1) - (dl * 2));
        thrustBig.addPoint(x + 10, (y - 5) - (dl * 2));
        g.setColor(Color.RED);
        g.fillPolygon(thrustBig);
                
        //Draw medium thrust polygon
        thrustMed.addPoint(x - 6, (y - 5) - (dl * 2));
        thrustMed.addPoint(x - 10, (y + 1) - (dl * 2));
        thrustMed.addPoint(x, (y + 4) - dl); //extends every draw
        thrustMed.addPoint(x + 10, (y + 1) - (dl * 2));
        thrustMed.addPoint(x + 6, (y - 5) - (dl * 2));
        g.setColor(Color.ORANGE);
        g.fillPolygon(thrustMed);
                
        //Draw small thrust polygon
        thrustSm.addPoint(x - 2, (y - 5) - (dl * 2));
        thrustSm.addPoint(x - 6, (y + 1) - (dl * 2));
        thrustSm.addPoint(x, (y + 3) - dl); //extends every draw
        thrustSm.addPoint(x + 6, (y + 1) - (dl * 2));
        thrustSm.addPoint(x + 2, (y - 5) - (dl * 2));
        g.setColor(Color.YELLOW);
        g.fillPolygon(thrustSm);
        
    }
        
    /**
     * Draws a series of ovals of varrying white and grey
     * at the rocket platform location to emulate smoke clouds
     * @param g  Graphics object for drawing the figure elements
     * @param x  the initial x coordinate and center reference of figure
     * @param y  the initial y coordinate and baseline reference of figure
     * @param dl  location adjustment for some figures
     * @param ds  size increment for all figures
     */
    public static void drawSmokeClouds(Graphics g, int x, int y, int dl, int ds) {
        
        Color smokeCloud1 = new Color(175, 190, 210, 150);
        Color smokeCloud2 = new Color(220, 224, 227, 100);
        Color smokeCloud3 = new Color(227, 227, 227, 100);
        
        g.setColor(smokeCloud1);
        g.fillOval((x - 60) - dl / 2, (y - 10) - dl, 25 + ds, 10 + ds);
        g.fillOval((x - 44) - dl / 2, (y - 15) - dl, 15 + ds, 10 + ds);
        g.fillOval((x - 30) + dl / 2, (y - 10) - dl, 25 + ds, 15 + ds);        
        g.fillOval((x - 20) + dl / 2, (y - 15) - dl, 15 + ds, 10 + ds);
        
        g.setColor(smokeCloud2);
        g.fillOval((x - 64) - dl / 2, (y - 20) - dl, 20 + ds, 15 + ds);
        g.fillOval((x - 54) - dl / 2, (y - 20) - dl, 20 + ds, 15 + ds);
        g.fillOval((x - 39) + dl / 2, (y - 15) - dl, 12 + ds, 10 + ds);
        g.fillOval((x - 14) + dl / 2, (y - 15) - dl, 12 + ds, 10 + ds);
        
        g.setColor(smokeCloud3);
        g.fillOval((x - 70) - dl / 2, (y - 10) - dl, 18 + ds, 16 + ds);
        g.fillOval((x - 44) - dl / 2, (y - 5) - dl, 18 + ds, 15 + ds);
        g.fillOval((x - 34) + dl / 2, (y - 25) - dl, 20 + ds, 15 + ds);        
        g.fillOval((x - 10) + dl / 2, (y - 5) - dl, 20 + ds, 15 + ds);
        
    }    
}
