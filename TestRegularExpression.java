package RegularExpression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRegularExpression {

	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMailSimple() {
		VerifMail Mail=new VerifMail();
		boolean MailValid=Mail.Validate("mehrez@yahoo.fr");
		assertEquals(true, MailValid);
	}
	
	@Test
	void testMailAvecPoint() {
		VerifMail Mail=new VerifMail();
		boolean MailValid=Mail.Validate("mehrez.salhi@yahoo.fr");
		assertEquals(true, MailValid);
	}
	
	//Test Login
	@Test
	void testLogin() {
	RegexUtiles login = new RegexUtiles();
	boolean loginValide = login.ValidateLogin("mehrez.salhi-mm@gmail.com");
	assertEquals(true, loginValide);
	}

	//Test Mdp
	@Test
	void testPassword() {
	RegexUtiles password = new RegexUtiles();
	boolean passwordValide = password.ValidatePassword("Password1!");
	assertEquals(true, passwordValide);
	}

}
