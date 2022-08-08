package String;


public class StringBld {

	public static void main(String[] args) {
		
		String x = "Hi ";
		StringBuilder sen = new StringBuilder(x);
		
		sen.append("my friend");
		
		System.out.println(sen);
		
		sen.insert(5, " best");
		
		System.out.println(sen);
		
		sen.replace(6,10,"worst");
		
		System.out.println(sen);
		
		sen.delete(6, 12);
		
		System.out.println(sen);
		
		System.out.println(sen.reverse());
		
		String s = "" + sen;
		
		System.out.println(s);
		
		
	}

}