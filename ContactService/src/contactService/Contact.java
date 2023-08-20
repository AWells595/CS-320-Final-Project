package contactService;

public class Contact {
	private final String CONTACT_ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String ID) {
		this.CONTACT_ID = ID;
	}
	
	public Contact(String ID, String firstName, String lastName, String phoneNumber, String address) {
		this.CONTACT_ID = ID;
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public final String getCONTACT_ID() {
		return this.CONTACT_ID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setFirstName(String firstName) {
		if(firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setLastName(String lastName) {
		if(lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber != null && phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setAddress(String address) {
		if(address != null && address.length() <= 30) {
			this.address = address;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
