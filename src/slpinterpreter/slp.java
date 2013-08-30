package slpinterpreter;

abstract class Stm { 
	
	abstract public String instanceOf();
}

class CompoundStm extends Stm {
	
	Stm stm1, stm2;

	public CompoundStm() { }
	
	public CompoundStm(Stm s1, Stm s2) {
		stm1 = s1;
		stm2 = s2;
	}

	public String instanceOf() {
		return CompoundStm.class.getSimpleName();
	}
}

class AssignStm extends Stm {
	
	String id;
	Exp exp;

	AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}
	
	public String instanceOf() {
		return AssignStm.class.getSimpleName();
	}
}

class PrintStm extends Stm {
	
	ExpList exps;

	PrintStm(ExpList e) {
		exps = e;
	}
	
	public String instanceOf() {
		return PrintStm.class.getSimpleName();
	}
}

abstract class Exp { 
	
	abstract public String instanceOf();
}

class IdExp extends Exp {
	
	String id;

	IdExp(String i) {
		id = i;
	}
	
	public String instanceOf() {
		return IdExp.class.getSimpleName();
	}
}

class NumExp extends Exp {
	
	int num;

	NumExp(int n) {
		num = n;
	}
	
	public String instanceOf() {
		return NumExp.class.getSimpleName();
	}
}

class OpExp extends Exp {
	
	Exp left, right;
	int oper;
	static final int Plus = 1, Minus = 2, Times = 3, Div = 4;

	OpExp(Exp l, int o, Exp r) {
		left = l;
		oper = o;
		right = r;
	}
	
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
	
	public String instanceOf() {
		return EseqExp.class.getSimpleName();
	}
}

abstract class ExpList { 
	
	abstract public String instanceOf();
}

class PairExpList extends ExpList {
	
	Exp head;
	ExpList tail;

	public PairExpList(){}
	public PairExpList(Exp h, ExpList t) {
		head = h;
		tail = t;
	}
	
	public String instanceOf() {
		return PairExpList.class.getSimpleName();
	}
}

class LastExpList extends ExpList {

	Exp head;

	public LastExpList(){}
	public LastExpList(Exp h) {
		head = h;
	}
	
	public String instanceOf() {
		return LastExpList.class.getSimpleName();
	}
}
