package muzeyen;
/**
 * 
 * Program that searches for 3 different targets (an int, a double and a string) using
 * two different tactics for each (linear and binary search)
 *@author Issa Muzeyen
 */
public class Search {

	public void Search() {
	}


	/**
	 * Searches for target1 (an int) in arrayInt using the linear search tactic
	 * @param arrayInt
	 * @param target1
	 * @return
	 */
	public static int searchLinearInt(int[] arrayInt, int target1)
	{
		for (int i = 0; i < arrayInt.length; i++)
		{
			if ( arrayInt[i] == target1 ) 
				return i;  
		}
		return -1;
	}

	/**
	 * Searches for target1 (an int) in arrayInt using the binary search tactic
	 * @param arrayInt
	 * @param target1
	 * @return
	 */
	public static int searchBinaryInt(int[]arrayInt, int target1)
	{
		int beg = 0;
		int end = arrayInt.length-1;
		int middle = (beg + end) / 2;
		do{
			if (arrayInt[middle] == target1)
			{
				return middle;
			}
			else if (arrayInt[middle] > target1)
			{
				end = middle - 1;
				middle = (beg + end) /2;
			}
			else 
			{
				beg = middle + 1;
				middle =  (beg + end)/2;
			}

		}while (end>=beg);
		return -1;
	}
	/**
	 * Searches for target2 (a double) in arrayDouble using the linear search tactic
	 * @param arrayDouble
	 * @param target2
	 * @return
	 */
	public static int searchLinearDouble(double[] arrayDouble, double target2)
	{
		for (int i = 0; i < arrayDouble.length; i++)
		{
			if ( arrayDouble[i] == target2 ) 
				return i;  
		}
		return -1;
	}

	/**
	 * Searches for target2 (a double) in arrayDouble using the binary search tactic
	 * @param arrayDouble
	 * @param target2
	 * @return
	 */
	public static int searchBinaryDouble(double[]arrayDouble, double target2)
	{
		int beg = 0;
		int end = arrayDouble.length-1;
		int middle = (beg + end) / 2;
		do{
			if (arrayDouble[middle] == target2)
			{
				return middle;
			}
			else if (arrayDouble[middle] > target2)
			{
				end = middle - 1;
				middle = (beg + end) /2;
			}
			else 
			{
				beg = middle + 1;
				middle =  (beg + end)/2;
			}

		}while (end>=beg);
		return -1;
	}

	/**
	 * Searches for target3 (a string) in arrayString using the linear search tactic
	 * @param arrayString
	 * @param target3
	 * @return
	 */
	public static int searchLinearString(String[] arrayString, String target3)
	{
		for (int i = 0; i < arrayString.length; i++)
		{
			if ( arrayString[i].compareTo(target3)==0 ) 
				return i;  
		}
		return -1;
	}

	/**
	 * Searches for target3 (a string) in arrayString using the binary search tactic
	 * @param arrayString
	 * @param target3
	 * @return
	 */
	public static int searchBinaryString(String[]arrayString, String target3)
	{


		int beg = 0;
		int end = arrayString.length-1;
		while(end>=beg){
			int mid = (beg+end)/2;
			if(arrayString[mid].compareTo(target3) == 0)
				return mid;
			else if(arrayString[mid].compareTo(target3) > 0)
				end = mid - 1;
			else
				beg = mid + 1;
		}return -1;
	}
}

