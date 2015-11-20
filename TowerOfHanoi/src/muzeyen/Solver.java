/**
 * 
 */
package muzeyen;

import java.util.Scanner;

/**Program that asks the user for the number of discs they would like to solve the Tower
 * of Hanoi with and outputs the moves they need to make to solve it in the least amount of
 * steps.
 * @author Issa Muzeyen
 *
 */
public class Solver {

	/**
	 * Main method that asks the user for the number of discs and passes it (along with
	 * the peg labels A, B and C to the solve method.
	 * For the purposes of this assignment, the user input should be 3, but, for recreational
	 * use, the input can be whatever you want (not negative).
	 */
	public static void main(String[] args) {
		/* the following commented code is used if you wanted the program to solve for any
		number of discs, but for the purposes of this assignment, the number of discs must 
		remain 3.
		*/
		//System.out.print("Please enter the number of disc(s). ");
		//Scanner scanner = new Scanner(System.in);
		//int discs = scanner.nextInt();
		int discs = 3;
		solve(discs, "A", "B", "C");
	}

	/**
	 * Method that takes the number of discs (3) and solves the Tower of Hanoi puzzle by changing
	 * the positions of beg, aux and end.
	 * @param n
	 * @param beg
	 * @param aux
	 * @param end
	 */
	public static void solve(int n, String beg, String aux, String end) {
		if (n == 1) {
			System.out.println(beg + " -> " + end);
		} 
		else {
			solve(n - 1, beg, end, aux);
			System.out.println(beg + " -> " + end);
			solve(n - 1, aux, beg, end);
		}
	}




}
