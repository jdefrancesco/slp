package slpinterpreter;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	
	public static void interp(Stm s) {
		Map<String, Integer> env = new HashMap<String, Integer>();
		InterpVisitor interpV = new InterpVisitor(env);
		
		// Begin crawling..
		s.accept(interpV);
	}
	
	static int maxArgs(Stm s) {
		// I write this part...
		return 0;
	}
    
	public static void main(String args[]) throws java.io.IOException {
        System.out.println(maxArgs(Program.prog));
        interp(Program.prog);
        System.out.println("Finished run 1\nStarting run two...");
        interp(Program.prog1);
        
        
        
    }
}
