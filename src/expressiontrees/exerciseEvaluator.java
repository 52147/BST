package expressiontrees;

import java.util.Scanner;

/**
 *  = Expression Trees =
 *  
 *  - Figure shows an example of an expression tree, the leaves of which are operands(e.g. constants or variable names) 
 *    and the other contain operators.
 *  - This particular tree happens to be binary because because all the operations are binary.
 *  - Although it is the simplest case, nodes can have more than 2 children,
 *  - A node may have only one child, as is the case with the unary minus operator.
 *  
 *  
 *  Expression  tree for (a+b)x(a-b) :
 *  
 *  x -> + -> a
 *         -> b
 *    -> - -> a
 *         -> b 
 *  
 *  
 * 
 * 
 *
 */

public class exerciseEvaluator {
	
	/**
	 *  Simple main to exercise Evaluator class.
	 * @param args
	 */
	public static void main(String[] args) {
		String str;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter expression, one per line:");
		
		while(in.hasNextLine()) {
			
			str = in.nextLine();
			System.out.println("Read: " + str);
			Evaluator ev  = new Evaluator (str);
			System.out.println(ev.getValue());
			System.out.println("Enter next expression:");
			
		}

	}

}
