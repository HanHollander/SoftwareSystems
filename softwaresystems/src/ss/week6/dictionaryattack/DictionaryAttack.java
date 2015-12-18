package ss.week6.dictionaryattack;

import java.util.*;
import java.io.*;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) {
		Scanner scanner = new Scanner(filename);
		List<String> lines = new ArrayList<>();
		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		for (String line : lines) {
			String[] words = line.split(": ");
			String username = words[0];
			String password = words[1];
			passwordMap.put(username, password);
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
    		// To implement
    		return null;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        // To implement
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {
        // To implement        
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
