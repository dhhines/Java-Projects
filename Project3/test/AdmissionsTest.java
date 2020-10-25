import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test Admissions methods
 * @author Suzanne Balik
 * @author 
 */
public class AdmissionsTest extends TestCase {
 
    @Test
    public void testGetEngineeringAdmissionStatus1() {
        
        assertEquals("Admissions.getEngineeringAdmissionStatus(750, 600, 4.0, 0)", "Admit",
                     Admissions.getEngineeringAdmissionStatus(750, 600, 4.0, 0));
        
    }


    // TODO: Add 5 more valid test cases here for the getEngineeringAdmissionStatus method. 
    // Each test should be in its own method

    @Test
    public void testGetJournalismAdmissionStatus1() {
        
        assertEquals("Admissions.getJournalismAdmissionStatus(750, 7, 4.0, 0)", "Admit",
                     Admissions.getJournalismAdmissionStatus(750, 7, 4.0, 0));
        
    }


    // TODO: Add 5 more valid test cases here for the getJournalismAdmissionStatus method.  
    // Each test should be in its own method  

    @Test
    public void testGetFineArtsAdmissionStatus1() {
        
        assertEquals("Admissions.getFineArtsAdmissionStatus('E', 4.0, 0)", "Admit",
                     Admissions.getFineArtsAdmissionStatus('E', 4.0, 0));
        
    }


    // TODO: Add 5 more valid test cases here for the getFineArtsAdmissionStatus method. 
    // Each test should be in its own method    
    
    /**
     * Test the Admissions methods with invalid values
     */ 
    @Test
    public void testInvalidMethods() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            Admissions.getEngineeringAdmissionStatus(100, 600, 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid SAT score", e.getMessage());
        }

        try {
            Admissions.getEngineeringAdmissionStatus(200, 900, 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid SAT score", e.getMessage());
        }

        try {
            Admissions.getEngineeringAdmissionStatus(200, 600, -5, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid GPA", e.getMessage());
        }

        try {
            Admissions.getEngineeringAdmissionStatus(400, 600, 4.0, -5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of alumni", e.getMessage());
        }

        try {
            Admissions.getJournalismAdmissionStatus(0, 2, 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid SAT score", e.getMessage());
        }

        try {
            Admissions.getJournalismAdmissionStatus(900, 4, 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid SAT score", e.getMessage());
        }

        try {
            Admissions.getJournalismAdmissionStatus(700, 1, 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid SAT essay score", e.getMessage());
        }

        try {
            Admissions.getJournalismAdmissionStatus(200, 6, -5, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid GPA", e.getMessage());
        }

        try {
            Admissions.getJournalismAdmissionStatus(400, 5, 3.0, -5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of alumni", e.getMessage());
        }

        try {
            Admissions.getFineArtsAdmissionStatus('x', 4.0, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid portfolio rating", e.getMessage());
        }

        try {
            Admissions.getFineArtsAdmissionStatus('E', -3, 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid GPA", e.getMessage());
        }

        try {
            Admissions.getFineArtsAdmissionStatus('G', 3.0, -2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of alumni", e.getMessage());
        }

    }
}
