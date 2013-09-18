package slpinterpreter;

/* File: Program.java
 * By: Joey DeFrancesco
 * Description: TODO
 * 
 */

public class Program {

	// Program from appel book
	static Stm prog = new CompoundStm(new AssignStm("a", new OpExp(
			new NumExp(5), OpExp.Plus, new NumExp(3))), 
			new CompoundStm(new AssignStm("b", new EseqExp(new PrintStm(new PairExpList(
					new IdExp("a"), new LastExpList(new OpExp(new IdExp("a"),
							OpExp.Minus, new NumExp(1))))), new OpExp(
					new NumExp(10), OpExp.Times, new IdExp("a")))),
			new PrintStm(new LastExpList(new IdExp("b")))));
	
	
	
	// Program One
	static Stm prog1 = new AssignStm("a", new NumExp(10));	
	
	// Program Two
	static Stm prog2 = new PrintStm(new LastExpList(new NumExp(5)));
	
	// Program Three
	static Stm prog3 = new CompoundStm(new AssignStm("a", new OpExp(new NumExp(5), OpExp.Plus, new NumExp(3))), new PrintStm(new LastExpList(new IdExp("a"))));

}