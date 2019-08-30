/**
 * Practice02Test
 * Test and autograder for NQueens problem.
 * @author dgbrizan
 *
 */
public class Practice02Test {

	// This helps create and place 
    public boolean createAndPlaceQueens(int size) {
    	NQueens nq = new NQueens(size);
    	try {
    		return nq.placeNQueens(0);
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    
    public void testNQueens () {
    	int grade = 0;
    	NQueens nq;
    	
    	try {
	    	// Can the class be instantiated?
	    	nq = new NQueens(0);
    		grade += 5;
    		System.out.println("[ +5%] NQueens class created successfully");

    		// ... but should throw an error for board sizes smaller than 1
    		try {
    			nq.placeNQueens(0);
    			System.out.println("[    ] NQueens class should check parameters are valid");
    		} catch (Exception e) {
    			grade += 5;
        		System.out.println("[ +5%] NQueens checks board size parameter");
    		}
	    	
	    	// Test good cases: board sizes for which we expect to have a solution
    		int [] goodsizes = {1, 6, 8, 18};

    		for (int size : goodsizes) {
    			if (createAndPlaceQueens(size)) {
    				grade += 15;
        			System.out.println("[+15%] " + size + " Queens likely placed successfully... to be checked by human eyes");
    			}
    		}
    		
    		// Test bad cases, for which there should be no solution
    		int [] badsizes = {2, 3};
    		for (int size : badsizes) {
	    		if (! createAndPlaceQueens(size)) {
					grade += 15;
	    			System.out.println("[+15%] " + size + " Queens correctly detected as unsuccessful");
				}
    		}
    	} catch (Exception e) {
    		System.out.println("[----] Found error during processing. Giving up.");
    	}
    	System.out.println("Grade for this assignment: " + grade + "%");
    }


    
    public static void main(String [] args) {
    	Practice02Test test = new Practice02Test();
    	test.testNQueens();
    }
}
