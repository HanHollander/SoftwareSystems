package ss.week6.dictionaryattack;

import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;
	
	public static final String PATH = "src\\ss\\week6\\dictionaryattack\\";

	public DictionaryAttack() {
		passwordMap = new HashMap<>();
		hashDictionary = new HashMap<>();
	}
	
	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		File file = new File(PATH + filename);
			Scanner scanner = new Scanner(file);
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
			scanner.close();
			System.out.println("file not finded");
		
	}
		

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public String getPasswordHash(String password) {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes("UTF-8"));
			} catch (Exception e) {
				 System.exit(1);
			}
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        String hashPassword = getPasswordHash(password);
        String userHashPassword = null;
        Set<String> keySet = passwordMap.keySet();
        for (String key : keySet) {
        	if (key.equals(user)) {
        		userHashPassword = passwordMap.get(key);
        	}
        }
		return userHashPassword.equals(hashPassword);
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) throws IOException {
    	File file = new File(PATH + filename);
		Scanner scanner;
		
			scanner = new Scanner(file);
			List<String> lines = new ArrayList<>();
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}      
			for (String line : lines) {
				hashDictionary.put(getPasswordHash(line), line);
			}
			System.out.println("Filie not gefind");
		
		
    }
    
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		Set<String> keySetUser = passwordMap.keySet();
		Set<String> keySetDict = hashDictionary.keySet();
		for (String user : keySetUser) {
			for (String hashPass : keySetDict) {
				if (passwordMap.get(user).equals(hashPass)) {
					System.out.println("User = " + user + "; Password = " + hashDictionary.get(hashPass));
				}
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		// da.doDictionaryAttack();
		System.out.println(da.getPasswordHash("password"));
		da.readPasswords("passwords.txt");
		System.out.println(da.passwordMap);
		da.addToHashDictionary("dictionary.txt");
		System.out.println(da.hashDictionary);
		da.doDictionaryAttack();
		System.out.println(da.checkPassword("dumbass", "696969"));
		System.out.println(da.checkPassword("katrine", "spongebob"));
	}

}
