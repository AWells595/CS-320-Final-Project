package contactServiceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	final void testSetFirstName() {
		Contact contact = new Contact("0000000000");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contact.setFirstName("abcdefghijklmnop"));
		
	}

	@Test
	final void testSetLastName() {
		Contact contact = new Contact("0000000000");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contact.setLastName("abcdefghijklmnop"));
	}

	@Test
	final void testSetPhoneNumber() {
		Contact contact = new Contact("0000000000");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contact.setPhoneNumber("603321737"));
	}

	@Test
	final void testSetAddress() {
		Contact contact = new Contact("0000000000");
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() ->contact.setAddress(null));
	}

}
