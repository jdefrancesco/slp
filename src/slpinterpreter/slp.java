package slpinterpreter;

/* File: slp.java
 * By: Joey DeFrancesco
 * Description: Contains all the element classes needed for the straight line programming language such as
 * 				classes for statements, expressions, etc..
 * 
 */


/* Class: Construct
 * Description: The base abstract class that all other classes for SLP (straight line programming) language belong to.
 *   			Beyond a Construct which encompasses all the elements in a SLP program, there are three other major components,
 *   			namely Expressions, Statements, and StatementLists.
 */
abstract class Construct {
	abstract public void accept(Visitor v);   	  // Visits nodes according to type (Expression, Statement, etc..)
}

/*
 * Three of the main types of constructs in our SLP implementation..
 * (mainly for maxArgs implemented in Interpreter.java)
 */
abstract class Stm extends Construct{ }
abstract class Exp extends Construct { }
abstract class ExpList extends Construct { }

// *** classes for Statements (Stm)
class CompoundStm extends Stm {
	
	private Stm stm1, stm2;

	public CompoundStm(Stm s1, Stm s2) {
		stm1 = s1;
		stm2 = s2;
	}

	@Override
	public void accept(Visitor e) { 
		e.visit(this); 
	}
	
	// Getters/Setters
	public Stm getStmOne() { 
		return stm1; 
	}
	
	public Stm getStmTwo() { 
		return stm2; 
	}
}

class AssignStm extends Stm {
	
	private String id;
	private Exp exp;

	AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Getters/Setters
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
	
	private ExpList exps;

	PrintStm(ExpList e) {
		exps = e;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}

	// Getters/Setters
	public ExpList getExpList() {
		return exps;
	}
}
// *** end of Statement classes


// *** Classes for Expression (Exp)
class IdExp extends Exp {
	
	private String id;

	IdExp(String i) {
		id = i;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Getters/Setters
	public String getId() {
		return id;
	}
}

class NumExp extends Exp {
	
	private int num;

	NumExp(int n) {
		num = n;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Setters/Getters
	public int getNumber() {
		return num;
	}
}

class OpExp extends Exp {
	
	Exp left, right;
	int oper;
	public static final int Plus = 1, Minus = 2, 
			Times = 3, Division = 4;

	OpExp(Exp l, int o, Exp r) {
		left = l;
		oper = o;
		right = r;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Setters/Getters
	public int getOperation() {
		return oper;
	}
	
	// Return identifier on LHS
	public Exp getLeftExp() {
		return left;
	}
	
	// Return expression on RHS
	public Exp getRightExp() {
		return right;
	}
}

class EseqExp extends Exp {
	
	Stm stm;
	Exp exp;

	EseqExp(Stm s, Exp e) {
		stm = s;
		exp = e;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Getters/Setters
	public Stm getStm() {
		return stm;
	}
	
	public Exp getExp() {
		return exp;
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
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Getters/Setters
	public Exp getExp() {
		return head;
	}
	
	public ExpList getExpList() {
		return tail;
	}
}

class LastExpList extends ExpList {

	Exp head;

	public LastExpList(Exp h) {
		head = h;
	}
	
	@Override
	public void accept(Visitor e) { 
		e.visit(this);
	}
	
	// Getters/Setters
	public Exp getExp() {
		return head;
	}
}
// *** end of Expression List classes

// EOF
