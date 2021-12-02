# Hash / Password Attack

Based on the Hashing Assignment designed by Jim de St. Germain, Univerity of Utah

## Overview - The Problem

You have been hired by a software company to expose their security flaws. You have successfully hacked their hashed passwords from their database. You have also discovered they use the MD5 hashing algorithm. You also noticed that they don't have any requirements on their passwords.

You will show them that the passwords are easy to attack and discover through a simple hash attack.

## Assignment Goals and Key Ideas to be Learned, Reviewed, & Relearned:

1. Use of Hash Functions
2. Understand Hash Table Properties
3. Using the MD5 Algorithm in a Java Program
4. Use of Multi-Threading an Applicaiton
5. More programming Practice

## Partnership

You may work with partners on this assignment. However, you must work with a partner that you have not worked with before, giving you a broader perspective of learning styles, and a chance to learn in multiple ways.

Please refer to the partnering page for details on working with a partner. At the end of the assignment you will need to make sure you complete the partnership evaluation. You are not required to pre-declare your partnership.

## The Applicaiton

This is a simple Java application that will implement the MD5 Hashing Algorithm to find the passwords to their corresponding hashes.

## Project Setup

No other files or packages should be created. This assignment should only require changes to the PasswordAttack.java and PasswordAttackMain.java. 

## Files Descriptions
- PasswordAttack.java
  - This contains all of the code that contains the static methods to carry out the hash attack.
- PasswordAttackMain.java
  - This runs the Password Attack methods and the timing for the different hash attack methods.
- Constants.java
  - This loads the constants from the properties file to be use throughout the application.
- PasswordAttackTest.java
  - Carries test code for the application
- "a_few_hashes", "hashwords_short", "hashwords_long"
  - The files that contains the hashes of client's passwords
- "a_few_words_dictionary", "common_passwords_dictionary"
  - Files that contain a dictionary of words. The "few_words_dictionary" match the original versions in the "a_few_hashes" file. Use the "common_passwords_dictionary" to focus on passwords that people are more likely to use in the real world.
- Properties file
  - Use the properties file to configure different runs you have of the applicaiton.

## Coding the Rest of the Application

### Getting Started

Look at all of the methods in the PasswordAttack.java. Make sure that all of the FIXMEs and TODOs are resolved. Start with writing the `readFileIntoArray` and `readFileIntoHashSet` methods. 

Both the

`bruteForceAttack(Collection<String> hashes, int maxLength)`

and the

`public static ArrayList<String> multiThreadBruteForceAttack(Collection<String> hashes, int maxPermutationLength)` 

methods should be able to use the recursive method: 

`static public void bruteForceAttack(Collection<String> hashes, ArrayList<String> successes, StringBuilder soFar, int maxLength)`

After you have written these methods, you can finish up with the method:

`static public ArrayList<String> dictionaryAttack(Collection<String> dictionary, Collection<String> hashes)`

The goal of all three methods:

`bruteForceAttack`, `multiThreadBruteForceAttack`, and `dictionaryAttack` 

should result in the return of an Array List of Strings that contain the password and it's hash. e.g.
`["cat : d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342"]`

### Multi-Threading

The given code shows you how to run multiple threads on this program. In this case, each thread is given a letter and checks all permutations of strings that start with that letter.

As a rule of thumb, you should use twice as many threads as you have Cores on your CPU. The default in the `assignment.properties` and `assignment-test.properties` file is 4.  So, if your computer has 4 cores, you should change to allow up to 8 threads.

### Permutation Creation

You should create all permutations of the letters 'a'-'z' up to N letters using either recursion (the recommended signature shown above) or with any approach you want (such as treating strings as numbers and adding one each time, (the details of doing this are up to you but your design choices and logic performed should be well documented)).

### The Non CS-Student's Choice
You should now know that a hash table "contains" method executes in O(1) time, vs. O(N) for the "contains" method on an array list.

In your test/analysis code, use the I_STUDIED_ALGORITHMS boolean following code so that you can study the actual affects of "contains" on a hash table versus an array. 

```
Collection<String> hashes;
String file = Constants.HASHWORDS_LONG_FILE;
if (Constants.I_STUDIED_ALGORITHMS) {
	hashes = PasswordAttack.readFileIntoHashSet(file);
} else {
	hashes = PasswordAttack.readFileIntoArray(file);
}
```

### Timing

You will need to write the code in the PasswordAttackMain.java so you can compare the runtime of brute force, multi-threaded brute force, and the dictionary attack. You will also want to do a few runs against the different hash files, as well as with different max password permutation lengths.

Make sure to also test the affects of I_STUDIED_ALGORITHMS, and how much faster using a HashSet is versus an ArrayList.

### MD5 Hashing

The words in the "a_few_hashes", "hashwords_short", and "hashwords_long" files (the encrypted passwords) have been encrypted using the MD5 hash algorithm. To turn your own permutation words or dictionary words in to MD5 hashes, you can use the `md5` method code provided.

### Other Methods

Please note, you can create any helper methods you need as long as you make sure that the method signatures we gave you are properly supported.

### Tests

Tests are not required. However, they are encouraged, as usual. 

## README Info and Code Pledge
In addition to the information provided for the assignment requirements, sometimes when you create your program, you will want to inform the user (in this case the Teacher) something about how to run your program, or what cool features you have added that are not obvious. Please add TO THE END of this README (in the "Any Additional Information" section) any information that should be noted to the teacher.

Please fill out the following:

Your Name: 

Your ID: 

The Date: 

The Class Number: 

The Assignment Number: 

Your partner name (when appropriate): 

I pledge that the work done here was my own and that I have learned how to write this program, such that I could throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand, describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for it's authenticity. (YOUR-NAME)

TODO: Type your name at the end of this pledge to acknowledge it.

### Any Additional Information

