/**
 * Class to draw a human figure using
 * ASCII characters and multiple methods.
 * This human character is the unique 
 * creation of the author
 *
 * @author David Hines
 */
public class HumanArt {
    
    /**
     *Draws the Human Art ASCII design using
     *multiple methods
     *@param args command lines arguments (not used)
     */
    public static void main(String[] args) {
        drawHead();
        drawTorso();
        drawLegs();
        
    }
    
    /**
     *Draws the head of the Human Art using
     *multiple method calls
     */
    public static void drawHead() {
        drawHat();
        drawFace();
        
    }

    /**
     *Draws the hat of the head component and
     *allows for easy change to hat design
     */
    public static void drawHat() {
        System.out.println("          ___");
        System.out.println("       __||_||__");
    
    }
    
    /**
     *Draws the face of the head component and
     *enables change to just the face design
     */
    public static void drawFace() {
        System.out.println("         *****");
        System.out.println("        * - - *");
        System.out.println("       @*  \"  *@");
        System.out.println("        *  O  *");
        System.out.println("         *****");
    
    }
    
    /**
     *Draws the torso component of the Human Art
     *including the arms and hands
     */
    public static void drawTorso() {
        System.out.println("          | |");
        System.out.println("      /---------\\");
        System.out.println("     // ||||||| \\\\");
        System.out.println("    //  |     |  \\\\");
        System.out.println("   ||   |     |   ||");
        System.out.println("   oo   |     |   oo");
        System.out.println("  000o  #######  o000");
        System.out.println("  000   /     \\   000");
    
    }
    
    /**
     *Draws the legs of the Human Art using
     *including the feet
     */
    public static void drawLegs() {
        System.out.println("       |   _   |");
        System.out.println("       |  / \\  |");
        System.out.println("       |  | |  |");
        System.out.println("       |  | |  |");
        System.out.println("       |  | |  |");
        System.out.println("    {#####/ \\#####}");
    
    }
}    