package String;

import java.util.Scanner;


public class Triplets {

	public static void main(String[] args) {

		 String sentense = "asasdfasdf ssssss dddddddd";
		 
		 System.out.println(sentense);
		 
		 String words[] = sentense.split(" ");
		
		for(int x = 0; x < words.length ; x++) {
			for(int k = 1 ; k < words[x].length() ; k++) {
				int p = words[x].charAt(k);
				if(p == words[x].charAt(k-1) && words[x].charAt(k+1) == words[x].charAt(k) && k+1 < words[x].length()) {
					System.out.println(words[x]);
					break;
				}
			}
		}

	}

}
