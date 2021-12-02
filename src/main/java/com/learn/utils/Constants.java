package com.learn.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.learn.attack.PasswordAttackMain;

public class Constants {

	public static Properties prop;

	public static boolean I_STUDIED_ALGORITHMS;

	public static int MAX_PERMUTATION_LENGTH;
	public static int AVAILABLE_THREADS;

	public static String A_FEW_HASHES_FILE;
	public static String HASHWORDS_SHORT_FILE;
	public static String HASHWORDS_LONG_FILE;

	public static String A_FEW_WORDS_FILE;
	public static String COMMON_PASSWORDS_FILE;

	public static ArrayList<String> HASH_FILES;

	/**
	 * This will load the properties from the application.properties file into the
	 * the constants.
	 */
	public static void loadProperties() {
		loadProperties("/application.properties");
	}

	/**
	 * This allows you to specify the properties file to load into as a resource.
	 * Useful for loading in the test properties file for tests.
	 * 
	 * @param propertiesFile
	 */
	public static void loadProperties(String propertiesFile) {

		HASH_FILES = new ArrayList<String>();

		prop = new Properties();
		try {
			prop.load(PasswordAttackMain.class.getResourceAsStream(propertiesFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		I_STUDIED_ALGORITHMS = Boolean.parseBoolean(prop.getProperty("I_STUDIED_ALGORITHMS"));

		MAX_PERMUTATION_LENGTH = Integer.parseInt(prop.getProperty("MAX_PERMUTATION_LENGTH"));
		AVAILABLE_THREADS = Integer.parseInt(prop.getProperty("AVAILABLE_THREADS"));

		A_FEW_HASHES_FILE = prop.getProperty("A_FEW_HASHES_FILE");
		HASHWORDS_SHORT_FILE = prop.getProperty("HASHWORDS_SHORT_FILE");
		HASHWORDS_LONG_FILE = prop.getProperty("HASHWORDS_LONG_FILE");

		A_FEW_WORDS_FILE = prop.getProperty("A_FEW_WORDS_FILE");
		COMMON_PASSWORDS_FILE = prop.getProperty("COMMON_PASSWORDS_FILE");

		HASH_FILES.add(A_FEW_HASHES_FILE);
		HASH_FILES.add(HASHWORDS_SHORT_FILE);
		HASH_FILES.add(HASHWORDS_LONG_FILE);

	}

}
