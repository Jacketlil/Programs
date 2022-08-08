package String;
import java.util.Iterator;

public class StringPractice {

	public static void main(String[] args) {
		String s = "    What is your name, Alan?     ";		
		s = s.trim() + "?";		
		System.out.println(s);
		
		//grab a letter
		char c = s.charAt(3);
		if (c == 't') System.out.println("yes!");
		
		//split up into words (an array)
		String words[] = s.split(" "); //split on spaces
		System.out.println(words[2] + words[2].length());
		
		//Make the first 'Y' uppercase
		String s2 = s.replaceFirst("y","Y"); // .replace() does all		
		System.out.println(s2);
		
		//Replace second 'a' with 'X' 
		//find position or location (pos or loc) of what you're looking for
		int pos = s.indexOf('a');  //first 'a'
		System.out.println(pos);  //first 'a' is at position 2 "What ..."
		pos = s.indexOf('a', pos+1);  //second 'a'
		System.out.println(pos);  // is at position 14
		
		s2 = s.substring(0,pos) + 'X' + s.substring(pos+1, s.length());
		System.out.println(s2);
		
		//try it again but use a char array
		boolean foundFirst = false;
		char[] letters = s.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == 'a') {
				if (!foundFirst) {
					foundFirst = true;
					continue;
				}
				letters[i] = 'X';
				break;
			}
		}
		System.out.println(letters);
		
		//Use integers to print out alphabet
		
		for (int i=0; i<26; i++) {
			char cc = (char)('a' + i); // 65 = 'A'  97 = 'a'
			System.out.print(cc);
		}
	}

}