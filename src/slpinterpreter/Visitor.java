package slpinterpreter;

public interface Visitor {
	
	// Stm visitors
	void visitCompoundStm(Stm stm);
	void visitAssignStm(AssignStm stm);
	void visitPrintStm(PrintStm stm);
	
	// Exp visitors
	void visitIdExp(IdExp exp);
	void visitNumExp(NumExp exp);
	void visitOpExp(OpExp exp);
	void visitEseqExp(EseqExp exp);
	
	// ExpList visitors
	void visitPairExpList(PairExpList pairExpList);
	void visitLastExpList(LastExpList lastExpList);
}
