package contactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private String nextID;
	private List<Contact> contacts;
	
	private void generateNextID() {
		if(nextID == null || nextID == "") {
			nextID = "0000000000";
			return;
		}
		
		int nextIDInt = Integer.parseInt(nextID) + 1;
		int temp = nextIDInt;
		int numDigitsNotZeroInID = 0;
		
		while(temp > 0) {
			temp = temp / 10;
			numDigitsNotZeroInID++;
		}
		
		nextID = new String(new char [10 - numDigitsNotZeroInID]).replace('\0', '0');
		nextID = nextID + nextIDInt;
		
	}
	
	public ContactService() {
		this.generateNextID();
		this.contacts = new ArrayList<>();
	}
	
	public Contact findContact(String contactID) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID() == contactID) {
				return contact;
			}
		}
		throw new RuntimeException();
	}
	
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(nextID);
		int numSuccess = 0;
		try {
			contact.setFirstName(firstName);
			numSuccess++;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid First Name");
		}
		
		try {
			contact.setLastName(lastName);
			numSuccess++;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid Last Name");
		}
		
		try {
			contact.setPhoneNumber(phoneNumber);
			numSuccess++;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid Phone Number");
		}
		
		try {
			contact.setAddress(address);
			numSuccess++;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Invalid address");
		}
		
		if(numSuccess == 4) {
			contacts.add(contact);
			this.generateNextID();
		}
		else {
			System.out.println("Invalid contact information unable to create");
		}
		
	}
	
	public String getID() {
		return this.nextID;
	}
	
	public void deleteContact(String contactID) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID().equals(contactID)) {
				contacts.remove(contact);
				return;
			}
			System.out.println("Contact ID not found");
		}
	}
	
	public void updateFirstName(String contactID, String firstName) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID().equals(contactID)) {
				contact.setFirstName(firstName);
				return;
			}
			System.out.println("Contact ID not found");
		}
	}
	
	public void updateLastName(String contactID, String lastName) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID().equals(contactID)) {
				contact.setLastName(lastName);
				return;
			}
			System.out.println("Contact ID not found");
		}
	}
	
	public void updatePhoneNumber(String contactID, String phoneNumber) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID().equals(contactID)) {
				contact.setPhoneNumber(phoneNumber);
				return;
			}
			System.out.println("Contact ID not found");
		}
	}
	
	public void updateAddress(String contactID, String address) {
		for(Contact contact : contacts) {
			if(contact.getCONTACT_ID().equals(contactID)) {
				contact.setAddress(address);
				return;
			}
			System.out.println("Contact ID not found");
		}
	}
	
	
}
