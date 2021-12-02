package com.learn.attack;

import java.util.ArrayList;
import java.util.Collection;

import com.learn.utils.Constants;

public class PasswordAttackMain {

	public static void main(String[] args) {

		Constants.loadProperties();

		ArrayList<String> successes = new ArrayList<String>();
		System.out.println("*** STARTING PASSWORD ATTACK ***");

		Collection<String> hashes;
		String file = Constants.HASHWORDS_LONG_FILE;
		if (Constants.I_STUDIED_ALGORITHMS) {
			hashes = PasswordAttack.readFileIntoHashSet(file);
		} else {
			hashes = PasswordAttack.readFileIntoArray(file);
		}

		// FIXME: Write the code that can time the different scenarios and methods of
		// the password attack

	}

}
