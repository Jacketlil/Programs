package cars;

/* This is an example of how to create an object. It is used in the CarTest class

*/

public class Toyota {

	/******* static variables  [There is only one copy of these for all cars that are made.] ****/
	final static String company = "RentMe.ca"; 
	static double fuelTank = 40.0; //litres
	
	//static method		[Running this affects all car objects. Static methods cannot access Instance variables.]
	static void upgradeTank() {
		fuelTank = 45.0;
		System.out.println("All fuel tanks upgraded!");
	}
	
	/****** instance variables	[These are the basic properties of each car.]   *******/
			//They are private so that other classes can't just modify them without proper checks.]
 			//They all default to zero unless otherwise specified.
	private double fuel;
	private long odometer; 		//just "long" for the heck of it
	private double fuelEfficiency = 6.2;  //	L per 100km
	final String model;		//this doesn't need to be private if it is final (people can read it, but can't change it)
	
	/********* constructors ******/
	//private Toyota() {}		//another way of preventing an empty constructor from being used.

	Toyota(String model) {
		this.model = model;	//two variables with same name, .: use "this" to access instance method
		fuel = fuelTank;
		odometer = 10L;		
	}
	
	Toyota(String model, long odo) {
		this(model);		//run the other constructor
		odometer = odo;
	}
	
	//instance methods
	void drive(int km) {
		if (fuel <= 0) {
			System.out.print("You can't drive with no fuel!");
			return;
		}

		km = Math.abs(km);	//driving backwards doesn't subtract miles
		odometer += km;
		fuel -= fuelEfficiency * km / 100;		
		if (fuel < 0) fuel = 0;		
	}

	void refuel(){
		fuel = fuelTank;
	}	
	
	//toString() needs to return one line of text describing the state of the object.
	@Override
	public String toString() {
		String s = String.format("Model: %s, odometer=%dkm, fuel left=%.1fL", model,odometer, fuel);
		return s;		
	}
	
}