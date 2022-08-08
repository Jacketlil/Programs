package Modulus;

public class Modulus {

	public static void main(String[] args) {
		for (int i = 0; i < 101 ; i++) {
			System.out.println(i + "\t\t" + i%8);
		}
		
		System.out.println();
		for (int i = 1; i < 201 ; i++) {
			if (i%13 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		for (int i = 1; i < 201 ; i++) {
			if (i%12 != 0) {
				System.out.printf("%4d ", i);
			}
			else {
				System.out.printf("%n%4d ", i);
			}
		}

	}
	


}
