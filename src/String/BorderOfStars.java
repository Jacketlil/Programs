/*
 * Jacky Li
 * 2021/12/17
 * This program asks the user to input a sentence which is later being processed by adding 
 * stars surrounding the sentence. The default characters for each line are 20. After 20 
 * characters, this program will automatic start a new line. The program will end if the
 * first 20 characters does not contain any spaces.
 */
package String;

import java.util.Scanner;

public class BorderOfStars {

	final static int BORDER = 20;
	static String sentence;
	static String temp;

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter a sentence:");

		sentence = scan.nextLine();

		//variable
		int characterCounts = 0;


		//if there are more than 20 characters
		//check for the first 20 characters see if there is enough space for setting the border
		if(sentence.length()>BORDER) {
			for(int i = 0 ; i < BORDER ; i++) {
				if(sentence.charAt(i)!=' ') {
					characterCounts++;
				}
			}
		}

		//if there is not any space in the first 20 letters
		//then end the program
		if(characterCounts==BORDER) {
			System.out.println("Unavaiable sentence");
			return;
		}




		//for-loop to check whether each border character is empty space
		for(int i = 2 ; i<sentence.length() ; i++) {
			if(i%BORDER == 0) {
				if(sentence.charAt(i)!=' ') {
					addEmptySpaces(i);
				}

				//if it is empty space, remove the space
				else {
					sentence = sentence.substring(0,i) + sentence.substring(i+1,sentence.length());
				}
			}
		}

		//generate the top border of stars
		for(int i = 0 ; i < BORDER+4 ; i++) {
			System.out.print("*");
		}
		System.out.println();

		//print out t)he sentence by storing each line into a separated temporary variable and print it out
		for(int i = 0 ; i < sentence.length(); i++) {
			if(i%BORDER == 0) {

				//if the next line is in the middle of or at the start of the sentence 
				if(i+BORDER < sentence.length()) {
					temp = sentence.substring(i, i+BORDER);

					//print out starts before and at the end of the line
					System.out.println("* " + temp + " *");
				}

				//if the next line is the last line
				if(i+BORDER > sentence.length()) {
					temp = sentence.substring(i,sentence.length());

					//for loop to add spaces until it reaches the border
					for(int x = temp.length() ; x<BORDER ; x++) {
						temp += " ";
					}

					//print out starts before and at the end of the line
					System.out.println("* " + temp + " *");

				}
			}
		}

		//generate the bottom border of stars
		for(int i = 0 ; i < BORDER+4 ; i++) {
			System.out.print("*");
		}

	}

	//method to add spaces
	static void addEmptySpaces(int i) {
		int indexOfSpace = i;

		//while-loop to find the closest space before the word originally located at the border
		while(sentence.charAt(indexOfSpace)!=' ') {
			indexOfSpace--;
		}

		//for-loop adding space until the spaces reach the border 
		for(int x = indexOfSpace ; x < (i-1) ; x++) {
			sentence = sentence.substring(0, x) + " " + sentence.substring(x, sentence.length());
		}
	}



}
