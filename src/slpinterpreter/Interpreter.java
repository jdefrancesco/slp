package slpinterpreter;

/* File: Interpreter.java
 * By: Joey DeFrancesco
 * Description: main() contained in this file. Launches interpreter as well as calls maxArgs().
 * 				maxArgs and its helper methods are implemented in this file as a static methods.
 */

import java.util.HashMap;
import java.util.Map;

public class Interpreter {
	
	public static void interp(Stm s) {
		
		// We will use a map to store our environment.. Much easier and more efficient..
		Map<String, Integer> env = new HashMap<String, Integer>();
		InterpVisitor interpV = new InterpVisitor(env);
		
		// Begin execution of program!
		s.accept(interpV);

	}
	
	static int maxArgs(Construct s) {
		
		// Math.max returns the greatest integer of the two arguments given..
		// Better than another long ungly if statement followed by more returns!!

		if (s instanceof CompoundStm) {
			
			CompoundStm stm = (CompoundStm) s;
			return Math.max(maxArgs(stm.getStmOne()), 
					maxArgs(stm.getStmTwo()));
		} else if (s instanceof AssignStm) {
			
			AssignStm assignStm = (AssignStm) s;
			return maxArgs(assignStm.getExp());
		} else if (s instanceof PrintStm) {
			
			PrintStm printStm = (PrintStm) s;
			return Math.max(getArgCount(printStm.getExpList()), 
					maxArgs(printStm.getExpList()));
		} else if (s instanceof PairExpList) {
			
			PairExpList pairExpList = (PairExpList) s;
			return Math.max(maxArgs(pairExpList.head),
					maxArgs(pairExpList.tail));
		} else if ((s instanceof IdExp) || (s instanceof NumExp)) {
			
			return 0;
		} else if (s instanceof OpExp) {
			
			OpExp opExp = (OpExp) s;
			return maxArgs(opExp.right);
		} else if (s instanceof EseqExp) {
			
			EseqExp seqExp = (EseqExp) s;
			return Math.max(maxArgs(seqExp.getStm()), 
					maxArgs(seqExp.getExp()));
		} else if (s instanceof PairExpList) {
			
			PairExpList pairList = (PairExpList) s;
			return Math.max(maxArgs(pairList.getExp()), 
					maxArgs(pairList.getExpList()));
		} else if (s instanceof LastExpList) {
			
			LastExpList lastExpList = (LastExpList) s;
			return maxArgs(lastExpList.getExp());
		} else {
			
			System.out.println("Invalid SLP construct...");
			return -1;
		}
		
	}
    
	public static int getArgCount(ExpList expList) {
		
		if (expList instanceof PairExpList) {
			
			PairExpList pairList = (PairExpList) expList;
			return 1 + getArgCount(pairList.getExpList());
		} else if (expList instanceof LastExpList){
			
			return 1;
		} else { // Error.. We don't want to get here..
			
			System.out.println("Bad expression list given... Trying to resume execution..");
		}
		
		return 0;
	}
	
	public static void main(String args[]) throws java.io.IOException {
        
		//System.out.println("Max Args: " + maxArgs(Program.prog));
        
		// Program from book
		interp(Program.prog);
		
		// Program One
		//interp(Program.prog1);
    
        // Program Two
        //interp(Program.prog2);
		
		// Program Three
		//interp(Program.prog3);
		
		// Program Four -- add..
		//interp(Program.prog4);
        
    }
}
