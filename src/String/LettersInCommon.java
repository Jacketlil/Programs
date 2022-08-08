/*
 * Jacky Li
 * 2021/12/11
 * This String Program asks the user to input a 6 letter word which then will compare with a word 
 * list stored in the program. Eventually, the program will print out the largest number of letters
 * that this word has in common with any word in the list.
 */
package String;

import java.util.Scanner;

public class LettersInCommon {

	public static void main(String[] args) {
		
		//two same string array with different purposes
		//string array used to find the common letters
		String[] compareWordList = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
		
		//string array used to print out the exact common word
		String[] printWordList = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the 6 letter word: ");
		String word = scan.nextLine();
		
		//variables
		int commonLetters = 0;
		int temp = 0;
		int wordIndex = 0;


		//each wordList words
		for(int x = 0 ; x < compareWordList.length ; x++) {
			//reset the temp value
			temp = 0;
			
			
			//each inputing word letter
			for(int i = 0; i < word.length(); i++) {

				//each letter of wordList word
				for(int q = 0 ; q < compareWordList[x].length() ; q++){

					//if the letter of the word is equal to the letter of the wordList
					if(word.charAt(i) == compareWordList[x].charAt(q)) {
						temp++;
						
						//remove the common letter in the wordList
						//Purpose: make sure if there is another same word in the input, temp will not count twice
						compareWordList[x] = compareWordList[x].substring(0,q) + compareWordList[x].substring(q+1, compareWordList[x].length());
						
						
						//q reduce by one
						//if one letter is removed, make sure the next word will be checked as well
						q--;
						break;
					}
				}

				//if the temp variable is greater than commonLetters
				//the biggest commonLetters value will be temp
				if(commonLetters < temp) {
					commonLetters = temp;
					wordIndex = x;
				}
			}
		}

		//print out the common word using the print string array
		System.out.println(commonLetters + " " + printWordList[wordIndex]);

	}

}