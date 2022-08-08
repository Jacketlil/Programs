/*
 * Jacky Li
 * 2021/12/14
 * This program generate six random letters which do not contain any
 * vowels. Then, the program will replace 1 - 2 letters to vowels. 
 * There will not be less than 1 or more than 2 vowels generated.
 */
package String;

public class RandomWord {

	public static void main(String[] args) {

		//vowels array variable
		String vowels[] = {"a", "i", "e", "o", "u"};

		//variable
		String word = "";
		int firstVowelLoc, secondVowelLoc; // first and second vowel location/index

		//for-loop to generate 6 random letters except for vowels
		for(int x = 0 ; x < 6 ; x++) {

			//randomChar start at 'a', and 26 letters behind
			char randomChar = (char)(Math.random()*26+(char)('a')); 

			//generate randomChar again if it is a vowel
			while(randomChar == 'a' || randomChar == 'e' || randomChar == 'i' || randomChar == 'o' || randomChar == 'u') {
				randomChar = (char)(Math.random()*26+(char)('a'));
			}
			word += ((char)(randomChar));
			
		}//end of the for-loop
		

//		System.out.println(word); //debug
		
		//declare the first vowel location
		firstVowelLoc = (int)(Math.random()*word.length());

		//the first vowel generate
		word = word.substring(0,firstVowelLoc) + vowels[(int)(Math.random()*vowels.length)] + word.substring(firstVowelLoc+1, word.length());
		
		
		//if random number is bigger than 50, second vowel will show
		if((Math.random()*100>50)) {
			//declare the second vowel location
			secondVowelLoc = (int)(Math.random()*word.length());
			
			//make sure the first and the second vowel will not show in the same location
			while(secondVowelLoc == firstVowelLoc) {
				secondVowelLoc = (int)(Math.random()*word.length());
			}
			//the second vowel generate
			word = word.substring(0,secondVowelLoc) + vowels[(int)(Math.random()*vowels.length)] + word.substring(secondVowelLoc+1, word.length());
		}
		
		
		System.out.println(word);


	}
}
