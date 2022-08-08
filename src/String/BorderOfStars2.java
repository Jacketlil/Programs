package String;

import java.util.Scanner;

public class BorderOfStars2 {

	final static int BORDER = 20;
	static String sentence;

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter a sentence:");

		sentence = scan.nextLine();

		String words[] = sentence.split(" ");

		int wordsCount = 0; //count the length of the sentence
		
		for(int i = 0; i < sentence.length() + 2; i ++) {
			wordsCount = 0;
			for(int x = 0 ; x < words.length ; x++) {
				wordsCount += words[x].length() + 1;
				if(i < wordsCount) {
					break;
				}
				else if(i%BORDER == 0){
					
					System.out.println();
					break;
				}
				else if (i == wordsCount){
					System.out.print(words[x] + " ");
					break;
				}
			}
		}
		
		//The unusually warm weather makes me think of summer. It is hard to stay focused on mundane work.
	}

}
