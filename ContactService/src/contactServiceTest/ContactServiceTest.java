package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest extends ContactService {


	@Test
	final void testContactService() {
		ContactService contactService = new ContactService();
		assertTrue(contactService.getID().equals("0000000000"));
	}

	@Test
	final void testAddContact() {
		ContactService contactService = new ContactService();
		String ID = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		Contact contact = contactService.findContact(ID);
		
		assertTrue(contact.getFirstName().equals("Alex"));
		assertTrue(contact.getLastName().equals("Wells"));
		assertTrue(contact.getPhoneNumber().equals("6033217375"));
		assertTrue(contact.getAddress().equals("5 Bowers Landing"));

	}

	@Test
	final void testDeleteContact() {
		ContactService contactService = new ContactService();
		String ID1 = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		contactService.addContact("Sami", "Cummings", "6033217375", "5 Bowers Landing");
		
		assertTrue(contactService.findContact(ID1).getFirstName().equals("Alex"));
		contactService.deleteContact(ID1);
		Assertions.assertThrows(
				RuntimeException.class, 
				() ->contactService.findContact(ID1));
	}

	@Test
	final void testUpdateFirstName() {
		ContactService contactService = new ContactService();
		String ID = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contactService.updateFirstName(ID, "abcdefghijklmnop"));
	}

	@Test
	final void testUpdateLastName() {
		ContactService contactService = new ContactService();
		String ID = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contactService.updateLastName(ID, "abcdefghijklmnop"));
	}

	@Test
	final void testUpdatePhoneNumber() {
		ContactService contactService = new ContactService();
		String ID = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contactService.updatePhoneNumber(ID, "1"));
	}

	@Test
	final void testUpdateAddress() {
		ContactService contactService = new ContactService();
		String ID = contactService.getID();
		contactService.addContact("Alex", "Wells", "6033217375", "5 Bowers Landing");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contactService.updateAddress(ID, new String(new char[31])));
	}

	
}
