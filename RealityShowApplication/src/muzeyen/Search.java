package muzeyen;

import java.util.ArrayList;

/**
 *	This class contains a search algorithm used to search for a contestant 
 * @author Issa Muzeyen
 */
public class Search {

	/**
	 * @param contestants
	 * @param target
	 * @return
	 * Linear search algorithm (used over binary in case user doesn't sort) that locates and returns
	 * the index of a specific user's last name (asked for by the user)
	 */
	public static int searchString(ArrayList<ContestantInformation>contestants, String target)
	{
		for (int i = 0; i < contestants.size(); i++)
		{
			if (contestants.get(i).getLastName().equals(target)) 
				return i;  
		}
		return -1;
	}

}


/*
public static int binarySearch (ArrayList<ContestantInformation>contestants, String target){
		return(binarySearch(contestants,target,0,contestants.size()-1));
	}
   private static int binarySearch(ArrayList<ContestantInformation>contestants, String target, int begin, int end){
	   if (begin>end)
		   return -1;
	   int mid = (begin+end)/2;
			   if ((contestants.get(mid).getLastName()).compareTo(target)==0)
				   return mid;
			   else if ((contestants.get(mid).getLastName()).compareTo(target)<0)
				   return binarySearch(contestants,target,mid+1,end);
			   else
				   return binarySearch(contestants,target,begin,mid-1);

   }

 */




	





















