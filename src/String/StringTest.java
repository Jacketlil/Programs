package String;

public class StringTest {

	public static void main(String[] args) {
		String sth = "01234567";
		
		sth = sth.substring(0,2) + sth.substring(3,7);
		
		System.out.println(sth);

	}

}
