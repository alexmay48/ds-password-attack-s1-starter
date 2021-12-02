package com.learn.attack;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.learn.utils.Constants;

public class PasswordAttack {

	// You can use this char array to help build the password permutation.
	static final char[] charArr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * Given a filename, read each token (or word) of the file into an ArrayList.
	 * 
	 * @param fileName - The file to read
	 * @return - ArrayList of every token (or word)
	 */
	static public ArrayList<String> readFileIntoArray(String fileName) {
		// FIXME:
		return null;
	}

	/**
	 * Given a filename, read each token (or word) of the file into a HashSet.
	 * 
	 * @param fileName - The file to read
	 * @return - HashSet of every token (or word)
	 */
	static public HashSet<String> readFileIntoHashSet(String fileName) {
		// FIXME:
		return null;
	}

	/**
	 * 
	 * This method compares (hashes of) all permutations of up to "maxLength"
	 * characters vs the given list of hashes (the password file).
	 * 
	 * @param hashes    - The hashes that you have stolen, and are trying to find
	 *                  matches to.
	 * @param maxLength - How many characters the passwords can be (in length). It
	 *                  is suggested to be 6 or less.
	 * @return - The list of found passwords and their corresponding md5 hashes
	 *         (e.g., "cat :
	 *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
	 */
	static public ArrayList<String> bruteForceAttack(Collection<String> hashes, int maxLength) {
		// FIXME:
		return null;
	}

	/**
	 * This method compares (hashes of) all permutations of up to "maxLength"
	 * characters vs the given list of hashes (the password file).
	 * 
	 * This can be used as a recursive method to build up the password permutation
	 * and check for password matches to add to the successfully cracked passwords.
	 * 
	 * @param hashes    - The hashes that you have stolen, and are trying to find
	 *                  matches to.
	 * @param successes - The list of found passwords and their corresponding md5
	 *                  hashes (e.g., "cat :
	 *                  d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
	 * @param soFar     - The password that has been build "so far" or "up to this
	 *                  point".
	 * @param maxLength - How many characters the passwords can be (in length). It
	 *                  is suggested to be 6 or less.
	 */
	static public void bruteForceAttack(Collection<String> hashes, ArrayList<String> successes, StringBuilder soFar,
			int maxLength) {
		// FIXME:
	}

	/**
	 * Compare all words in the given list (dictionary) to the stolen hashed
	 * password collection we wish to attack.
	 * 
	 * @param dictionary - The list of likely passwords.
	 * @param hashes     - The hashes that you have stolen, and are trying to find
	 *                   matches to.
	 * @return - The list of found passwords and their corresponding md5 hashes
	 *         (e.g., "cat :
	 *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
	 */
	static public ArrayList<String> dictionaryAttack(Collection<String> dictionary, Collection<String> hashes) {
		// FIXME:
		return null;
	}

	/**
	 * Begin a brute force attack on the password hashes found in the hash file.
	 * 
	 * The rule of thumb is that you can use 2 threads for each core in your
	 * computer. However, use only up to 8 threads. (Change this in the
	 * application.properties file).
	 * 
	 * Compute all permutations of strings and compare them to a list of already
	 * hashed passwords to see if there is a match
	 * 
	 * @param hashes               - The hashes that you have stolen, and are trying
	 *                             to find matches to.
	 * @param maxPermutationLength - How many characters the passwords can be (in
	 *                             length). It is suggested to be 6 or less.
	 * @return - The list of found passwords and their corresponding md5 hashes
	 *         (e.g., "cat :
	 *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
	 */
	public static ArrayList<String> multiThreadBruteForceAttack(Collection<String> hashes, int maxPermutationLength) {

		// Set up the thread pool
		ExecutorService threadPool = Executors.newFixedThreadPool(Constants.AVAILABLE_THREADS);

		// Have an array list of array lists so that the threads do not run into issues
		// adding to the same collection.
		ArrayList<ArrayList<String>> successes = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 26; i++) {
			successes.add(new ArrayList<>());
		}

		// Each letter a-z will have their own array list to add successfully cracked
		// passwords. Each array list will have a thread execute the brute force attack.
		for (int i = 0; i < 26; i++) {
			int temp = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					// Start the brute for attack on its own thread and own letter.
					bruteForceAttack(hashes, successes.get(temp), new StringBuilder("" + (char) ('a' + temp)),
							maxPermutationLength);
				}
			});
		}

		// Wait for each thread in the thread pool to finish.
		try {
			threadPool.shutdown();
			threadPool.awaitTermination(1, TimeUnit.DAYS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Combine all of the successfully cracked passwords in the array list of array
		// lists back into one array list.
		ArrayList<String> result = new ArrayList<>();
		for (ArrayList<String> letterList : successes) {
			result.addAll(letterList);
		}

		return result;

	}

	/**
	 * This method returns the string representation in hex of the MD5 hash of the
	 * word given. Use the returned String to compare to the hashes you have stolen.
	 */
	public static String md5(String password) {
		MessageDigest hashGenerator = null;

		try {
			hashGenerator = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// build MD5 hash of a permutation
		hashGenerator.update(password.toString().getBytes());
		byte[] digest = hashGenerator.digest();

		StringBuffer hashwordHexCode = new StringBuffer();
		for (byte b : digest) {
			hashwordHexCode.append(String.format("%02x", b & 0xff));
		}

		String temp = hashwordHexCode.toString();
		return temp;
	}

}
