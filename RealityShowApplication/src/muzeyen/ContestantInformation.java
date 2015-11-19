package muzeyen;
/**
 * This class holds the information of each contestant. It contains fields for 
 * first name, last name, street address (street name and street number), 
 * city, province, postal code, phone number and birth date
 * @author Issa Muzeyen 
 */
@SuppressWarnings("rawtypes")
public class ContestantInformation implements Comparable<ContestantInformation> {

	/**
	 * declares the fields that correspond with the asked information of the contestants 
	 * (first name, last name, address etc...)
	 */
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String phoneNumber;
	private String birthday;

	/**
	 * empty constructor that sets the default result to null
	 */
	public ContestantInformation(){
		firstName = "";
		lastName = "";
		address = "";
		city = "";
		province = "";
		postalCode = "";
		phoneNumber = "";
		birthday = "";
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param phoneNumber
	 * @param birthday
	 * @throws InvalidInputException
	 * takes all the information 
	 */
	public ContestantInformation(String firstName, String lastName, String address, String city, String province, String postalCode, String phoneNumber, String birthday) throws InvalidInputException{

		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setPhoneNumber(phoneNumber);
		setBirthday(birthday);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 * @throws InvalidInputException 
	 */
	public void setFirstName(String firstName) throws InvalidInputException {
		for(int i = 0; i< firstName.length(); i++){
			if (!Character.isLetter(firstName.charAt(i))){
				throw new InvalidInputException("Please enter a valid first name.");
			}
		}
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 * @throws InvalidInputException 
	 */
	public void setLastName(String lastName) throws InvalidInputException {
		String checkLastName = lastName.replace(" ", "");
		if (checkLastName.length() == 0)
		{
			throw new InvalidInputException("Please enter a valid address");
		}
		for(int i = 1; i< lastName.length(); i++){
			if (!Character.isLetter(lastName.charAt(i))){
				throw new InvalidInputException("Please enter a valid last name.");
			}
		}
		this.lastName = lastName;
	}


	/**
	 * @return the streetName
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 * @throws InvalidInputException 
	 */
	public void setAddress(String address) throws InvalidInputException {
		String checkAddress = address.replace(" ", "");
		if (checkAddress.length() == 0)
		{
			throw new InvalidInputException("Please enter a valid address");
		}
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;  
	}

	/**
	 * @param city the city to set
	 * @throws InvalidInputException 
	 */
	public void setCity(String city) throws InvalidInputException {
		String checkCity = city.replace(" ", "");
		if (checkCity.length() == 0)
		{
			throw new InvalidInputException("Please enter a valid address");
		}
		this.city = city;
	}


	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 * @throws InvalidInputException 
	 */
	public void setProvince(String province) throws InvalidInputException {		
		String checkProvince = province.replace(" ", "");
		if (checkProvince.length() == 0)
		{
			throw new InvalidInputException("Please enter a valid province");
		}	
		this.province = province;
	}


	/**
	 * @return the postalCode
	 */
	public String getPostalCode(){
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 * @throws InvalidInputException 
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException {
		if (postalCode.length()!=6){
			throw new InvalidInputException("Postal code must be 6 digits.");
		}
		for(int i = 0; i<6; i+=2){
			if (!Character.isLetter(postalCode.charAt(i))){
				throw new InvalidInputException("Invalid postal code, please follow this format: x#x#x#");
			}
		}
		for(int i = 1; i<6; i+=2){
			if (!Character.isDigit(postalCode.charAt(i))){
				throw new InvalidInputException("Invalid postal code, please follow this format: x#x#x#");
			}
		}
		this.postalCode = postalCode;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 * @throws InvalidInputException 
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidInputException {
		if (phoneNumber.length() !=10){
			throw new InvalidInputException("Phone number must be 10 digits.");
		}
		for(int i = 0; i<10; i++){
			if (!Character.isDigit(phoneNumber.charAt(i))){
				throw new InvalidInputException("Invalid phone number, please only enter digits.");
			}
		}
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the birthday
	 */
	public String getBirthday(){
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 * @throws InvalidInputException
	 */
	public void setBirthday(String birthday) throws InvalidInputException {
		if (birthday.length()!=4){
			throw new InvalidInputException("Birth year must be 4 digits.");
		}
		int year = Integer.parseInt(birthday);
		int age = 2015 - year;
		if (age < 18){
			throw new InvalidInputException("Sorry, you are too young. ");
		}
		for(int i = 0; i<4; i++){
			if (!Character.isDigit(birthday.charAt(i))){
				throw new InvalidInputException("Invalid birth year, please only enter digits.");
			}
		}
		this.birthday = birthday;
	}


	/**
	 * method that converts all fields to strings	
	 */
	public String toString(){ 
		return firstName + " " + lastName + " " + address + " " + city + " " + province + " " + postalCode + " " + phoneNumber + " " ; 
	}

	/**
	 * method that compares last names in order to sort them using the sort method (in the main)
	 */
	public int compareTo(ContestantInformation ci) {
		// TODO Auto-generated method stub
		return this.lastName.compareToIgnoreCase(ci.lastName);
	}










}










