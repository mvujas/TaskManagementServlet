package dmi.ris.utility;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptUtil {
	public static String hash(String password) {
		String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		return bcryptHashString;
	}
	public static boolean verifiy(String password, String bcryptHashString) {
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
		return result.verified;
	}

}
