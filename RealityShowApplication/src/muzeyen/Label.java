/**
 * 
 */
package muzeyen;

/**
 * class that formats user information and returns the formatted the result in order for a 
 * "cleaner" look to the label (when outputted)
 * @author Issa Muzeyen
 */
public class Label {

	
	private String display;
	private ContestantInformation ci1;
	
	
	/**
	 * creats the objects wich inherit the methods that formats the contestants information
	 */
	public Label(ContestantInformation ci) {
	this.ci1 = ci;
	formatName();
	formatAddress();
	formatNumber();

	}
	/**
	 * @return
	 * formats a users first and last name and returns the formatted result 
	 */
	public String formatName(){
		String name = ci1.getLastName() + ", " + ci1.getFirstName() + "\n";
		return name;
		
	}
	
	/**
	 * @return
	 * formats the contestants address, city and province and returns the formatted result
	 */
	public String formatAddress(){
		String address = ci1.getAddress() + "\n" + ci1.getCity() + ", " + ci1.getProvince() + "\n" + ci1.getPostalCode() + "\n";
		return address;
	}
	
	/**
	 * 
	 * @return
	 * formats the contestants phone number and returns the formatted result
	 */
	public String formatNumber(){
		String number = ci1.getPhoneNumber();
		return number;
	
	
	}
	
	/**
	 * combines all the formatted results into one output and returns it
	 */
	public String toString(){
		display = formatName() + formatAddress() + formatNumber()+ "\n";
		return display;
	}
	
}
