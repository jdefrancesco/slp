package slpinterpreter;

/*
 *  Genereal test/scratchpad for all files in the slpinterepreter package
 * 
 */
public class Test {

	public static void main(String[] args){
		
		CompoundStm cs = new CompoundStm();
		System.out.println("class is: " + cs.instanceOf());
		
		PairExpList pl = new PairExpList();
		System.out.println("class is: " + pl.instanceOf());
	}
}
