package Object_lesson;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car ("Jaguar"); //illegal

		Car car2 = new Car ("Toyota", 5000);
		
		//car2.make = "Porshe";
		//fix using final

		System.out.println(car1.toString());
		System.out.println(car2.toString());
//		System.out.println(car1.make);
//		System.out.println(car2.odometer);
		
		car1.drive(-200);
		System.out.println(car1.toString());
		//car1.odometer = 1; // wont work because private
		
		int x = car1.getOdometer();
		System.out.println(x);
	}

}
