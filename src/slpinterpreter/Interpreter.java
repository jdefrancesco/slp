package slpinterpreter;

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	
	public static void interp(Stm s) {
		Map<String, Integer> env = new HashMap<String, Integer>();
		InterpVisitor interpV = new InterpVisitor(env);
		
		// Begin interpreting 
		s.accept(interpV);

		
		/* For DEBUGGING
		 * print out hashmap values...
		 */
		System.out.println("---------------------------------");
		System.out.println("Dumping final environment state after last run...");
		
		// Dumping environment of last run.. (the hashmap)
        for(Map.Entry<String, Integer> entry : env.entrySet()) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        }
	}
	
	static int maxArgs(Stm s) {
		// TODO: Finish thing. 
		return 0;
	}
    
	public static void main(String args[]) throws java.io.IOException {
        
		//System.out.println(maxArgs(Program.prog));
        
		// Program One
		interp(Program.prog);
    
        // Program Two
        //interp(Program.prog1);
        
    }
}
