package slpinterpreter;

/* File: Visitor.java
 * By: Joey DeFrancesco
 * Description: Visitor interface! Classes implementing this interface need these methods.
 * 
 */

public interface Visitor {
	
	// Stm visitors
	void visit(CompoundStm stm );
	void visit(AssignStm stm);
	void visit(PrintStm stm);
	
	// Exp visitors
	void visit(IdExp exp) ;
	void visit(NumExp exp);
	void visit(OpExp exp);
	void visit(EseqExp exp);
	
	// ExpList visitors
	void visit(PairExpList pairExpList);
	void visit(LastExpList lastExpList);
}
