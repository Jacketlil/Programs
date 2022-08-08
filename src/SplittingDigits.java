
public class SplittingDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	 int n = (int)(Math.random()*90 + 10);
		 int n1, n2;
		 
		 n2 = n%10;
		 n1 = (n-b)/10;
		 System.out.println(n);
		 System.out.println(a);
		 System.out.println(b);
		 */
		 
	/*	 int n = (int)(Math.random()*90 + 10);
		 int n1, n2;
		 
		 n1 = n/10;
		 n2 = n - 10*a;
		 
		 System.out.println(n);
		 System.out.println(a);
		 System.out.println(b);
		 */
		
		int n = (int)(Math.random()*90 + 10);
		char n1, n2;
		String num = String.valueOf(n);
		n1 = num.charAt(0);
		n2 = num.charAt(1);
		
		System.out.println(n);
		System.out.println(n1);
		System.out.println(n2);
	}

}
