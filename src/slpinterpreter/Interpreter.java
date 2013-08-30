package slpinterpreter;

public class Interpreter {
    
	
	static void Interp(Stm s) {
    	// I write this part
    }
    
	static int maxArgs(Stm s) {
		// I write this part...
		return 0;
	}
    
	public static void main(String args[]) throws java.io.IOException {
        System.out.println(maxArgs(Program.prog));
        Interp(Program.prog);
    }
}
