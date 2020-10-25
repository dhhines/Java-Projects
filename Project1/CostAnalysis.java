/**
 * Class to compare the costs of the
 * different light bulb types taking into
 * account the cost of the bulb and the energy
 * to generate similar lumens over time.  Data
 * will be presented in a table format
 *
 * @author David Hines
 */
public class CostAnalysis {
    
    /** cost per KWHour in cents */
    public static final double CENTS_PER_KWH = 10.99;
    
    /** watts to power incandescent bulb to 1100 lumens */
    public static final int INCANDESCENT_WATTS = 75;
    
    /** cost of incandescent bulb */
    public static final double INCANDESCENT_COST = 1.05;
    
    /** watts to power CFL bulb to 1100 lumens */
    public static final int CFL_WATTS = 21;
    
    /** cost of CFL bulb */
    public static final double CFL_COST = 2.10;
    
    /** watts to power LED bulb to 1100 lumens */
    public static final int LED_WATTS = 11;
    
    /** cost of LED bulb */
    public static final double LED_COST = 3.85;
    
    /** minimum number of hours to display in table */
    public static final int MINIMUM_HOURS = 0;
    
    /** maximum number of hours to display in table */
    public static final int MAXIMUM_HOURS = 1200;
    
    /** standard hour increment for display in table */
    public static final int HOUR_INCREMENT = 50;
    
    /** cents per dollar for converting costs to dollars */
    public static final int CENTS_PER_DOLLAR = 100;
    
    /** watts per kilowatt-hour for calculating watts */
    public static final int WATTS_PER_KW = 1000;
    
        
    /**
     *Displays a table comparing the costs of
     *each light bulb type over time
     *@param args command lines arguments (not used)
     */
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("      Energy and Total Cost Comparison (in dollars)");
        System.out.println();
        System.out.println("         Incandescent          CFL               LED");
        System.out.println("Hours   Energy   Total    Energy   Total    Energy   Total");
        System.out.println("-----   ------   -----    ------   -----    ------   -----");
        
        for (int i = 0; i <= MAXIMUM_HOURS / HOUR_INCREMENT; i++) {
            
            int currentHours = HOUR_INCREMENT * i;         
            double centsPerWatt = CENTS_PER_KWH / WATTS_PER_KW;            
            double currentIncanCost = calculateEnergyCost(INCANDESCENT_WATTS, 
                                                            currentHours, 
                                                            CENTS_PER_KWH);
                                                            
            double currentCflCost = calculateEnergyCost(CFL_WATTS, currentHours, 
                                                            CENTS_PER_KWH);
                                                            
            double currentLedCost = calculateEnergyCost(LED_WATTS, currentHours, 
                                                            CENTS_PER_KWH);
            
            System.out.printf("%4d", (currentHours));            
             
            System.out.printf("%9.2f", currentIncanCost); //Incan bulb energy cost by hour
            System.out.printf("%9.2f", (currentIncanCost + INCANDESCENT_COST)); //Incan bulb total
            
            System.out.printf("%9.2f", currentCflCost);    //CFL bulb energy cost by hour 
            System.out.printf("%9.2f", (currentCflCost + CFL_COST));  //CFL bulb total
            
            System.out.printf("%9.2f", currentLedCost);    //LED bulb energy cost by hour 
            System.out.printf("%9.2f\n", (currentLedCost + LED_COST));  //LED bulb total
        }
    }
    
    /**
     *calculates the energy cost <i>in dollars</i>
     *@param watts number of watts
     *@param hours number of hours
     *@param centsPerKWH cost of energy in cents per kilowatt-hours
     *@return energy cost in dollars
     */
    public static double calculateEnergyCost(int watts, int hours, double centsPerKWH) {
        
        double energyCost = ((watts * hours * centsPerKWH) / WATTS_PER_KW) / CENTS_PER_DOLLAR;
        
        return energyCost;
    }
    
}    