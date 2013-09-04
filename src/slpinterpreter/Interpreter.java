package slpinterpreter;

public class Interpreter implements Visitor {
    
	
	public Interpreter(Stm s) {
    	// I write this part
		interp(s);
		
    }
	
	public void interp(Stm s) {
		
	}
	
	
	
	// Start of visitor methods
	
	//... START HERE TOMORROW
	
	// End of visitor methods
    
	static int maxArgs(Stm s) {
		// I write this part...
		return 0;
	}
    
	public static void main(String args[]) throws java.io.IOException {
        System.out.println(maxArgs(Program.prog));
        new Interpreter(Program.prog);
    }
}
