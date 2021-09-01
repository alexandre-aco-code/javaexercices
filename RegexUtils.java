package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	String login;
	String password;

	public boolean ValidateLogin(String login) {
	//Login avec une adresse mail avec point et tiret
	String regex = "[a-z]+\\.?[a-z]+-?[a-z]+@[a-z]+\\.[a-z]{1,3}";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(login);

	return matcher.matches();
	}

	public boolean ValidatePassword(String password) {
	//Mdp avec au moins 8 caractères, 1 Majuscule, 1 Minuscule, 1 chiffre et 1 caractère spécial
//		Au moins une lettre majuscule(?=.*?[A-Z])
//		Au moins une lettre minuscule(?=.*?[a-z])
//		Au moins un chiffre, (?=.*?[0-9])
//		Au moins un caractère spécial, (?=.*?[#?!@$%^&*-])
//		Longueur minimale de huit .{8,}
		
	String regex = "(?=.+[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(password);

	return matcher.matches();
	}
	
	

}
