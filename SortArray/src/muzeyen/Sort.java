package muzeyen;
/**
 * Program that contains 5 different ways of sorting an unsorted array (selection,insertion,
 * bubble,qucik and merge sorts).
 * @author Issa Muzeyen
 *
 */
public class Sort {

	public Sort() {
	}

	/**
	 * method that sorts an unsorted array using the selection sort method
	 * @param array
	 * @return
	 */
	public static int[] selectionSort(int[] array)
	{
		int second, first, temp;
		for (int i = 0; i < array.length - 1; i++) {
			first = i;
			for (second = i + 1; second <= array.length-1; second++){
				if (array[first] > array[second] )  //checks if the first number is larger than the second
					first = second;  
			}
			temp = array[i];  //store the first location
			array[i] = array[first];  //swap the second value into the first location
			array[first] = temp; //swap the first value into the second location
		}
		return array;
	}




	/**
	 * method that sorts an unsorted array using the insertion sort method
	 * @param array
	 * @return
	 */
	public static int[] insertionSort(int[] array)
	{
		int i, innerCounter, swap, temp;
		for (i = 1; i<=array.length-1;i++)
		{
			swap = array[i];
			innerCounter = i-1;
			while(innerCounter>=0 && swap < array[innerCounter]){
				//swap
				temp = array[innerCounter];
				array[innerCounter] = array[innerCounter+1];
				array[innerCounter+1] = temp;
				innerCounter--;
			}
		}
		return array;
	}




	/**
	 * method that sorts an unsorted array using the bubble sort method
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array)
	{
		int temp = 0;
		for (int i = 0; i<array.length-1; i++){
			for(int innerCounter=0;innerCounter<array.length-1-i;innerCounter++){
				if(array[innerCounter]>array[innerCounter+1]){
					temp = array[innerCounter];
					array[innerCounter] = array[innerCounter+1];
					array[innerCounter+1] = temp;
				}
			}
		}
		return array;
	}




	/**
	 * method used for splitting the given array into two halves in order to be
	 * recursively called by quick sort
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[]array, int start, int end){
		int temp;
		int pivot = array[end];
		int partitionIndex = start;
		for (int i=0;i<end;i++){
			if(array[i] <= pivot){
				//swap so array[i] = array[partitionIndex] and array[partitionIndex] = array[i]
				temp = array[i];
				array[i] = array[partitionIndex];
				array[partitionIndex] = temp;
				partitionIndex++;				
			}
		}
		//swap so array[partitionIndex] = array[end] and array[end] = array[partitionIndex]
		temp = array[partitionIndex];
		array[partitionIndex] = array[end];
		array[end] = array[partitionIndex];	
		return partitionIndex;
	}
	/**
	 * method that sorts an unsorted array using the quick sort method by recursively
	 * calling partition
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] quickSort(int[] array,int start,int end){
		if(start < end){
			int partitionIndex = partition(array,start,end);  //calls partition method
			quickSort(array,start,partitionIndex-1);  //sorts left side of partition
			quickSort(array,partitionIndex+1,end);  //sorts right side of partition
		}
		return array;
	}




	/**
	 * method that breaks down an unsorted array into halves until one each array
	 * contains only 1 element which is then merged together by comparing values so that
	 * the final array will be sorted.
	 * @param left
	 * @param right
	 * @param array
	 * @return
	 */
	public static int[] merge(int[]left, int[]right, int[]array){
		int numLeft = left.length;
		int numRight = right.length;
		int indexLeft= 0;
		int indexRight= 0;
		int indexArray = 0;
		while(numLeft>indexLeft && numRight>indexRight){
			if(left[indexLeft]<=right[indexRight]){
				array[indexArray] = left[indexLeft];
				indexLeft++;
			}
			else{
				array[indexArray] = right[indexRight];
				indexRight++;
			}
			indexArray++;	
		}
		while(indexArray<numLeft)
		{
			array[indexArray++] = left[indexLeft++];
		}
		while(indexArray<numRight)
		{
			array[indexArray++] = right[indexRight++];
		}
		return array;
	}
	/**
	 * method that sorts an unsorted array using the merge sort method by recursively calling
	 * merge in order to obtain the sorted array
	 * @param array
	 * @return
	 */
	public static int[] mergeSort(int[] array){
		int n = array.length;
		if (n<=1){
			return array;
		}
		int mid = n/2;
		int left[] = new int[mid];
		int right[] = new int[n-mid];
		/*the following is a different way of copying an array as opposed to a for loop
			/System.arraycopy(array, 0, left, 0, left.length);
	        /System.arraycopy(array, left.length, right, 0, right.length);		
		 */  
		for (int i=0; i<=mid-1;i++){
			left[i] = array[i];
		}
		for (int i=mid; i<=n-1;i++){
			right[i-mid] = array[i];
		}		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,array);
		return array;
	}













}

















