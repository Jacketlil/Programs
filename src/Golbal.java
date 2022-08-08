
public class Golbal {
	//here x is global: any method in this class can access it
	static int x = 5;
	
	public static void main(String[] args) {
		//x is LOCAL to this method
		int x = -4;
		
		int y = -3;
		
		System.out.println(Math.random()*100-50);
	
	}
	
	static void printme(int animal, int z) {
		System.out.println("***"+ animal +"***");
	}

}