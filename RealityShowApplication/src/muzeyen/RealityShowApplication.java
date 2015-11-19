/**
 * 
 */
package muzeyen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Program that allows the user to input information, display the information, search for a 
 * specific piece of information, delete a specific information, delete all of the information,
 * save the information, load the information, sort the information and sort the information
 * @author Issa Muzeyen 
 */
public class RealityShowApplication  {
	static Scanner scan = new Scanner (System.in);
	/**
	 * @param args - argument
	 * @throws IOException - input/output exception
	 * @throws InvalidInputException -input was invalid
	 * calls menu method
	 */
	public static void main(String[] args) throws IOException, InvalidInputException {
			ArrayList <ContestantInformation> contestants = new ArrayList<ContestantInformation>();
			Menu(contestants);
	}
      
	/**
	 * @param contestants
	 * @throws IOException
	 * @throws InvalidInputException
	 * displays the options that the user can choose and calls the corresponding method
	 * based on what the user chose
	 */
	public static void Menu (ArrayList<ContestantInformation>contestants) throws IOException, InvalidInputException{
		System.out.println("Choose an option. ");
		System.out.println("1. Add new contestant. ");
		System.out.println("2. Print label. ");
		System.out.println("3. Search. ");
		System.out.println("4. Delete one. ");
		System.out.println("5. Delete all. ");
		System.out.println("6. Save. ");
		System.out.println("7. Load. ");
		System.out.println("8. Sort by last name. ");
		System.out.println("9. Exit. ");
		String choice = scan.nextLine();
		
		if (choice.equals("1"))
		{
			addContestant(contestants);
			Menu(contestants);
		}
		if (choice.equals("2"))
		{
			printLabel(contestants);
			Menu(contestants);
		}
		if (choice.equals("3"))
		{
			searchContestants(contestants);
			Menu(contestants);
		}
		if (choice.equals("4")) 
		{
			deleteContestant(contestants);
			Menu(contestants);
		}
		if (choice.equals("5"))
		{
			contestants.removeAll(contestants);
			Menu(contestants);
		}
		if (choice.equals("6"))
		{
			save(contestants);
			Menu(contestants);
			
		}
		if (choice.equals("7"))
		{
			load(contestants);
			Menu(contestants);
			
		}
		if (choice.equals("8"))
		{
			Collections.sort(contestants);
			Menu(contestants);
		}
		if (choice.equals("9"))
		{
			System.exit(0);
		}
	}
	
	/**
	 * @param contestants
	 * adds a new contestant to the arraylist
	 */
	public static void addContestant (ArrayList<ContestantInformation>contestants){

		boolean flag = false; 
		ContestantInformation contestant1 = new ContestantInformation(); 

		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your first name"); //asks user for first name
				String fname = scan.nextLine(); //collect users input
				contestant1.setFirstName(fname); //sets contestant first name to their input
			} 
			catch (InvalidInputException firstName)
			{
				System.out.println(firstName.getMessage()); //prints out the exception from the InvalidInputException class
				flag = true; //loops program enter user enters something valid
			}			
		}
		while (flag);

		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your last name");
				String lname = scan.nextLine();
				contestant1.setLastName(lname);
			} 
			catch (InvalidInputException lastName)
			{
				System.out.println(lastName.getMessage());
				flag = true;
			}			
		}
		while (flag);


		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your address");
				String add = scan.nextLine();
				contestant1.setAddress(add);
			} 
			catch (InvalidInputException address)
			{
				System.out.println(address.getMessage());
				flag = true;
			}			
		} while (flag);



		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your city");
				String city = scan.nextLine();
				contestant1.setCity(city);
			} 
			catch (InvalidInputException city)
			{
				System.out.println(city.getMessage());
				flag = true;
			}			
		} while (flag);



		System.out.println("Please enter your province/territory (please use the full name)");
		String provinceCheck = scan.nextLine();
		String checkProvince = provinceCheck.replace(" ", "");

		try{	
			//checks if users input is one of the provinces/territories
			if(checkProvince.equalsIgnoreCase("alberta"))
			{
				provinceCheck = "AB";
				contestant1.setProvince(provinceCheck); //sets contestant1 province to users input
			}
			else if(checkProvince.equalsIgnoreCase("britishcolumbia"))
			{
				provinceCheck = "BC";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("manitoba"))
			{
				provinceCheck = "MB";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("newbrunswick"))
			{
				provinceCheck = "NB";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("newfoundlandandlabrador"))
			{
				provinceCheck = "NL";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("novascotia"))
			{
				provinceCheck = "NS";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("ontario"))
			{	
				provinceCheck = "ON";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("princeedwardisland"))
			{	
				provinceCheck = "AB";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("quebec"))
			{
				provinceCheck = "PE";
				contestant1.setProvince(provinceCheck);
			}
			else if(checkProvince.equalsIgnoreCase("saskatchewan"))
			{	
				provinceCheck = "SK";
				contestant1.setProvince(provinceCheck);
			}
		}
		catch (InvalidInputException province)
		{
			System.out.println(province.getMessage()); //outputs error message
			flag = true; //loops program until input is valid
		}


		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your postal code");
				String pcode = scan.nextLine();
				contestant1.setPostalCode(pcode);
			} 
			catch (InvalidInputException postalCode)
			{
				System.out.println(postalCode.getMessage());
				flag = true;
			}			
		}
		while (flag);


		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your phone number");
				String pnumber = scan.nextLine();
				pnumber = pnumber.replace(" ", "");
				contestant1.setPhoneNumber(pnumber);
			} 
			catch (InvalidInputException phoneNumber)
			{
				System.out.println(phoneNumber.getMessage());
				flag = true;
			}

		}
		while (flag);


		do
		{
			flag = false;
			try
			{
				System.out.println("Please enter your birth year");
				String byear = scan.nextLine();
				contestant1.setBirthday(byear);
			} 
			catch (InvalidInputException birthday)
			{
				System.out.println(birthday.getMessage());
				flag = true;
			}

		}
		while (flag);	

		
		do
		{
			
			flag = false;
			
			System.out.println("What is 2 more than 9 divided by 3?");
			int response = Integer.parseInt(scan.nextLine());
			if (response != 5)
			{
				System.out.println("try again!");
				flag = true;
			}

			else
				flag = false;
			
		}
		while (flag);	
		
		
		contestants.add(contestant1);

		
	}

	/**
	 * @param contestants
	 * calls the print label method that outputs the users information in a formatted style
	 */
	public static void printLabel (ArrayList<ContestantInformation>contestants)
	{
		for(int i = 0; i<contestants.size();i++)
		{
			Label label = new Label (contestants.get(i));
			System.out.println(label.toString());
		}
	}

	/**
	 * @param contestants
	 * asks the user for the last name of the person they are searching and outputs the
	 * index of where the user is found
	 */
	public static void searchContestants(ArrayList<ContestantInformation>contestants)
	{	 
		System.out.println("Enter the last name of the person you are looking for.");
		String target = scan.nextLine();
		int value= Search.searchString(contestants, target);

		if (value == -1)
			System.out.print ("the contestant that you were looking for was not found. ");
		else 
			System.out.println("the contesant you were looking for was found at index " + value);
	}

	/**
	 * @param contestants
	 * asks the user for the last name of the person they are trying to delete and deletes
	 * the user at the index that the search method returns
	 */
	public static void deleteContestant(ArrayList<ContestantInformation>contestants)
	{
		System.out.println("Enter the last name of the person you are looking for.");
		String target = scan.nextLine();
		int value= Search.searchString(contestants, target);

		if (value == -1)
			System.out.print ("the contestant that you were looking for was not found. ");
		else {
			contestants.remove(value);
			System.out.print("the contestant has been removed. ");
		}
	}

	/**
	 * @param contestants
	 * saves the users information into a notepad called "information"
	 */
	public static void save (ArrayList<ContestantInformation>contestants) 
	{
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("information.txt");
			PrintStream fps = new PrintStream(fileOutputStream);
			fps.println(contestants.size());
			for(int i = 0; i<contestants.size();i++)
			{

				fps.println(contestants.get(i).getFirstName());
				fps.println(contestants.get(i).getLastName());
				fps.println(contestants.get(i).getAddress());
				fps.println(contestants.get(i).getCity());
				fps.println(contestants.get(i).getProvince());
				fps.println(contestants.get(i).getPostalCode());
				fps.println(contestants.get(i).getPhoneNumber());
				fps.println(contestants.get(i).getBirthday());
			}

			try {
				fileOutputStream.close();
			} catch (IOException e) {
				System.out.println("File was unable to close.");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File was unable to be saved.");
		}


	}

	/**
	 * @param contestants
	 * loads the users information from there last save
	 */
	public static void load(ArrayList<ContestantInformation>contestants)
	{
		BufferedReader fbr;
		try{
			fbr = new BufferedReader(new FileReader("information.txt"));
			contestants.removeAll(contestants);
			int m = Integer.parseInt(fbr.readLine());
			for (int i = 0; i < m; i++) 
			{
				String firstName = fbr.readLine();
				String lastName = fbr.readLine();
				String address = fbr.readLine();
				String city = fbr.readLine();
				String province = fbr.readLine();
				String postalCode = fbr.readLine();
				String phoneNumber = fbr.readLine();
				String birthday = fbr.readLine();


				try {
					contestants.add(new ContestantInformation(firstName, lastName, address, city, province, postalCode, phoneNumber, birthday));
				} catch (InvalidInputException e) {
					System.out.println("The input was invalid");
				}
			}
		} catch (IOException e) {
			System.out.println("File was not found");
		}


	}

}



	
	
	
	
	


