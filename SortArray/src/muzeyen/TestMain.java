package muzeyen;

import java.util.Arrays;
/**
 * contains the test array (wich you can change to any random values) that will be sorted
 * @author Issa Muzeyen
 *
 */
public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int[] array = {1,3,5,7,9,2,99,44,6,899,6,2268};  //test array
		int start = 0;  //first index of test array
		int end = array.length-1;  //last index of test array

		//outputs the sorted array (should be the same for all since they are using the same test array)
		System.out.println(Arrays.toString(Sort.selectionSort(array)));
		System.out.println(Arrays.toString(Sort.insertionSort(array)));
		System.out.println(Arrays.toString(Sort.bubbleSort(array)));
		System.out.println(Arrays.toString(Sort.quickSort(array,start,end)));
		System.out.println(Arrays.toString(Sort.mergeSort(array)));
	}

}
