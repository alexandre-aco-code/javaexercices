package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifMail {
	
	String mail;

	public boolean Validate(String Mail)
	{
		String REGEX="[a-z]+@[a-z]+\\.[a-z]+";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher=pattern.matcher(Mail);
		return matcher.matches();
		
		
	}
	

//contrainte password : 1 maj, 1 min, 1 chiffre, 1 caraspecial et 8 car min

}
