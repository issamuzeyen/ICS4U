package muzeyen;

/**
 * Program that tests 3 types of searching algorithms (int, double and string) 2 different ways
 * (linear and binary search)
 * @author Issa Muzeyen
 *
 */
public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/**
		 *Creates a simple array of integers, sets a target and outputs where the target is locatedf (-1 if not located)
		 */
		int[] arrayInt = {1,2,3,4,5,6,7,8,9,10};
		int target1 = 3;
		System.out.println(Search.searchLinearInt(arrayInt, target1));
		System.out.println(Search.searchBinaryInt(arrayInt, target1));
		
		/**
		 *Creates a simple array of doubles, sets a target and outputs where the target is locatedf (-1 if not located)
		 */
		double[] arrayDouble = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0};
		double target2 = 3.0;
		System.out.println(Search.searchLinearDouble(arrayDouble, target2));
		System.out.println(Search.searchBinaryDouble(arrayDouble, target2));
		
		/**
		 *Creates a simple array of integers, sets a target and outputs where the target is locatedf (-1 if not located)
		 */
		String[] arrayString = {"alligator","bee","cat","dog","elephant","frog","gorilla","horse", "iguana"};
		String target3 = "cat";
		System.out.println(Search.searchLinearString(arrayString, target3));
		System.out.println(Search.searchBinaryString(arrayString, target3));
	
	}

}
