package slpinterpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpVisitor implements Visitor {
	
	// Our "namespace" for the identifiers. Stores varibles and their vaues
	private Map<String, Integer> env;
	private int data;
	
	
	// Constructor for InterpVisitor -- Called by Interpreter.java interp() method 
	public InterpVisitor(Map<String, Integer> envArg) {
		this.env = envArg;
	}
	
	// Stm visitors
	public void visitCompoundStm(Stm stm) {

	}
	
	public void visitAssignStm(AssignStm stm) {
		stm.getExp().accept(this);
		env.put(stm.getId(), data);
	}
	
	public void visitPrintStm(PrintStm stm) {
		
	}
	
	
	// Exp visitors
	public void visitIdExp(IdExp exp){
		
	}
	
	public void visitNumExp(NumExp exp) {
		
	}
	
	public void visitOpExp(OpExp exp) {
		
	}
	
	public void visitEseqExp(EseqExp exp) {
		
	}
	
	
	// ExpList visitors
	public void visitPairExpList(PairExpList pairExpList) {
		
	}
	
	public void visitLastExpList(LastExpList lastExpList) {
		
	}

}
