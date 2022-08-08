/*
 * Jacky Li
 * 2021/12/14
 * This program asks user to input a sentence which will later add the numbers in
 * the sentence by one. eg: 123abc  input:234abc
 * When the number equals to 9, the program turns the number into 0
 */
package String;

import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {
		
		Scanner myScan = new Scanner (System.in);
		
		System.out.print("Enter a sentence: ");
		
		String sentence = myScan.nextLine();

		for (int x = 0 ; x < sentence.length(); x++) {
			char c = sentence.charAt(x);
			
			//if the character equals to numbers, add the number by 1
			if (c >= '0' && c <= '9' ) {
				c++;
				
				//if the number exceed character'9', it turns to 0
				if(c == (char)('0' + 10)) {
					c = '0';
				}
				
				sentence = sentence.substring(0,x) + c + sentence.substring(x+1, sentence.length());
			}
		}
		System.out.println(sentence);
	}

}
