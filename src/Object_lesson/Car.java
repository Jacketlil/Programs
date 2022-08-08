package Object_lesson;

public class Car {

	final String make; //final = once set it cannot be changed
	private int odometer = 12; //

	//constructors
	Car (String make){
		this.make = make;
	}
	
	Car (String make, int odo){
		this.make = make;
		odometer = odo;
	}
	//prevent anyone from accessing this
	private Car(){
		make = "unknown";
	}

	void drive(int distance) {
		this.odometer += Math.abs(distance);
	}
	int getOdometer () {return odometer; }
	void setOdometer(int n) {
		//check for master password
		//then reset 
	}
	@Override
	public String toString() {
		String s = "Make =" + make + "\tOdometer=" + odometer;
		return s;
	}
}
