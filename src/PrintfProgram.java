/*
 * Jacky Li
 * 2021/10/03
 * This program is to print out 1/7 with 5 decimal places using printf 
 * and print out different variables using printf
 */
public class PrintfProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Bessy";
		String colour = "brown";
		int weight = 1200;
		double num = (100000/7) / 100000.0;
		
		
		System.out.printf("%.5f %n", num);
		System.out.printf("The cow's name is %s, she is %s and weighs %dkg%n", name, colour, weight);
		
		int xx = 332;
		System.out.println("| 12345678 |");
		System.out.println("| ======== |");
		System.out.printf("| %8d |%n", xx);
		System.out.printf("| %08d |%n", xx);
		System.out.printf("| %+8d |%n", xx);
		System.out.printf("| %-8d |%n", xx);
		System.out.printf("| %8.1f |%n", (double)xx);
		
	}

}
