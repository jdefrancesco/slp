package slpinterpreter;

/* File: InterpVisitor.java
 * By: Joey DeFrancesco
 * Description: Contains visitor methods that perform operations for each statement.
 * 				Methods are all mutual recursive called by corresponding classes in slp.java.
 * 				NOTE: Double dispatch is used to determine which visit() method to call.
 * 
 */

import java.util.Map;

public class InterpVisitor implements Visitor {
	
	// Our "namespace" for the identifiers. Stores varibles and their vaues
	private Map<String, Integer> env;
	private int value;
	
	// Constructor for InterpVisitor -- Called by Interpreter.java interp() method 
	public InterpVisitor(Map<String, Integer> envArg) {
		this.env = envArg;
	}
	
	// Stm visitors
	public void visit(CompoundStm stm) {
		stm.getStmOne().accept(this);
		stm.getStmTwo().accept(this);
	}
	
	public void visit(AssignStm stm) {
		stm.getExp().accept(this);
		// Insert identifier into our environment.. (map) note value is global
		env.put(stm.getId(), value);
	}
	
	public void visit(PrintStm stm) {
		stm.getExpList().accept(this);
	}
	
	
	// Exp visitors
	public void visit(IdExp exp) {
		Integer retValue = env.get(exp.getId());
		
		if (retValue == null) {
			// Crash!
			System.out.println("Fatal Error - Terminating!");
		}
		
		this.value = retValue.intValue();
	}
	
	public void visit(NumExp exp) {
		value = exp.getNumber();
	}
	
	public void visit(OpExp exp) {
		int temp;
		
		// Switch statement handles the operation to perform 
		switch(exp.getOperation()) {
		
		case OpExp.Plus: 
			exp.getLeftExp().accept(this);
			temp = value;
			exp.getRightExp().accept(this);
			value += temp;
			return;
			
		case OpExp.Minus:
			exp.getLeftExp().accept(this);
			temp = value;
			exp.getRightExp().accept(this);
			value = temp - value;
			return;
			
		case OpExp.Times:
			exp.getLeftExp().accept(this);
			temp = value;
			exp.getRightExp().accept(this);
			value *= temp;
			return;
		
		case OpExp.Division:
			exp.getLeftExp().accept(this);
			temp = value;
			exp.getRightExp().accept(this);
			value /= temp;
			return;
			
		}
	}
	
	public void visit(EseqExp exp) {
		exp.getStm().accept(this);
		exp.getExp().accept(this);
	}
	
	// ExpList visitors
	
	// This will actually output our results when time comes
	public void visit(PairExpList pairExpList) {
		pairExpList.getExp().accept(this);
		System.out.println(value);
		pairExpList.getExpList().accept(this);
	}
		
	public void visit(LastExpList lastExpList) {
		lastExpList.getExp().accept(this);
		System.out.println(value);
	}

}
