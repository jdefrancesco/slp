package slpinterpreter;

/* Class: Construct
 * Description: The base abstract class that all other classes for SLP (straight line programming) language belong to
 *   			Beyond a Construct which encompasses all the elements in a SLP program there are three other major components,
 *   			namely Expressions,Statements, and StatementLists.
 */
abstract class Construct {
	
	abstract public String instanceOf();  // Return simple basename of the class
	abstract public void accept(Visitor v);   	  // Visits nodes according to type (Expression, Statement, etc..)
}

/*
 * Three of the main types of constructs in our SLP implementation
 */
abstract class Stm extends Construct{ }
abstract class Exp extends Construct { }
abstract class ExpList extends Construct { }

// *** classes for Statements (Stm)

class CompoundStm extends Stm {
	
	Stm stm1, stm2;


	public CompoundStm(Stm s1, Stm s2) {
		stm1 = s1;
		stm2 = s2;
	}

	@Override
	public void accept(Visitor e) { 
		e.visitCompoundStm(this); 
	}
	
	// Return class name that object is instance of
	@Override
	public String instanceOf() {
		return CompoundStm.class.getSimpleName();
	}
	
	// Getters/Setters
	public Stm getStmOne() { return stm1; }
	public Stm getStmTwo() { return stm2; }
	
	
}

class AssignStm extends Stm {
	
	String id;
	Exp exp;

	AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visitAssignStm(this);
	}
	
	@Override
	public String instanceOf() {
		return AssignStm.class.getSimpleName();
	}
	
	// Setters/Getters
	
	// Return identifier on LHS
	public String getId() {
		return this.id;
	}
	
	// Return expression on RHS
	public Exp getExp() {
		return this.exp;
	}
}

class PrintStm extends Stm {
	
	ExpList exps;

	PrintStm(ExpList e) {
		exps = e;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visitPrintStm(this);
	}
	
	@Override
	public String instanceOf() {
		return PrintStm.class.getSimpleName();
	}
}

// *** end of Statement classes



// *** Classes for Expression (Exp)
class IdExp extends Exp {
	
	String id;

	IdExp(String i) {
		id = i;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visitIdExp(this);
	}
	
	@Override
	public String instanceOf() {
		return IdExp.class.getSimpleName();
	}
}

class NumExp extends Exp {
	
	int num;

	NumExp(int n) {
		num = n;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visitNumExp(this);
	}
	
	@Override
	public String instanceOf() {
		return NumExp.class.getSimpleName();
	}
}

class OpExp extends Exp {
	
	Exp left, right;
	int oper;
	public static final int Plus = 1, Minus = 2, Times = 3, Division = 4;

	OpExp(Exp l, int o, Exp r) {
		left = l;
		oper = o;
		right = r;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visitOpExp(this);
	}
	
	@Override
	public String instanceOf() {
		return OpExp.class.getSimpleName();
	}
}

class EseqExp extends Exp {
	
	Stm stm;
	Exp exp;

	EseqExp(Stm s, Exp e) {
		stm = s;
		exp = e;
	}
	
	public void accept(Visitor e) { 
		e.visitEseqExp(this);
	}
	
	public String instanceOf() {
		return EseqExp.class.getSimpleName();
	}
}

// *** end of Expression classes


// *** Classes for Expression Lists (ExpList)
class PairExpList extends ExpList {
	
	Exp head;
	ExpList tail;

	
	public PairExpList(Exp h, ExpList t) {
		head = h;
		tail = t;
	}
	
	public void accept(Visitor e) { 
		
	}
	
	public String instanceOf() {
		return PairExpList.class.getSimpleName();
	}
}

class LastExpList extends ExpList {

	Exp head;


	public LastExpList(Exp h) {
		head = h;
	}
	
	public void accept(Visitor e) { 
		
	}
	
	public String instanceOf() {
		return LastExpList.class.getSimpleName();
	}
}

// *** end of Expression List classes



// EOF
