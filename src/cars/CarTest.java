package cars;


/*  This class makes the cars (Toyota objects) and keeps track of them. It controls everything (how far each drives, when they refuel etc).

*/
public class CarTest {
	public static void main(String args[]) {
		
		System.out.println("*" + Toyota.company); //static variables. No object needed

		//this won't work, because we've created other constructors and there's no empty constructor		
		//Toyota myCar = new Toyota();

		Toyota car1 = new Toyota("Camry");
		System.out.println(car1.toString());
		
		Toyota car2 = new Toyota("Tundra", 5000L);
		System.out.println(car2.toString());

		//does driving backwards decrease the odometer?
		car2.drive(300000);		
		System.out.println(car2.toString());
		
		car2.drive(30000);
		System.out.println(car2.toString());

		car2.refuel();
		System.out.println(car2.toString());

		Toyota.upgradeTank();
		
		car2.refuel();
		System.out.println(car2.toString());

	}
}