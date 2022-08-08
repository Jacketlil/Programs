/*
 * Jacky Li
 * 2021/11/30
 * This is the elevator class include all variables and methods
 */
package Elevator;

public class Elevator {

	//variables
	private final static String manufacturer = "Otis";
	private static boolean powerOn = true;
	private final int topFloor = 19;
	private final int maxOccupants = 25;

	private int floor = 1;
	private int people = 0;
	private String name;
	private boolean doorsOpen = false;

	//constructor
	Elevator (String name){
		this.name = name;
	}

	//constructor
	Elevator (String name, int floor){
		this.name = name;
		if (floor < 1 || floor > topFloor) {
			this.floor = 1;
		}	
	}

	//method of setting the status of the power
	public static void setPowerState(boolean power) {

		//check for repetition, if the new setup is the same as the previous
		//do not display any message
		if (powerOn != power) {
		
			powerOn = power;
			if (powerOn) {
				System.out.println("The power is now On");
			}
			else {
				System.out.println("The power is now Off");
			}
		}

	}

	//method for moving up one floor
	void up(){
		
		//if the power if off, return the statement
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		
		//close the door before the elevator starts
		closeDoors();

		//make sure the floor does not go up to the top floor
		if(floor+1 > topFloor) {
			System.out.println("The elevator is reached the highest floor.");
		}
		else {
			floor++;
		}
	}

	//method for moving down one floor
	void down () {

		//if the power if off, return the statement
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		//close the door before the elevator starts
		closeDoors();

		//make sure the floor does not go below the lowest floor
		if(floor-1 < 1) {
			System.out.println("The elevator is at the lowest floor.");
		}
		else {
			floor--;
		}
	}

	//method for directly going to certain floor
	void goToFloor(int n) {
		//if the power if off, return the statement
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		//close the door before it moves
		closeDoors();

		//make sure the floor does not reach unavailable floor
		if(n < 1 || n > topFloor) {
			System.out.println("Unavailable floor");
		}
		else {
			floor = n;
		}
	}

	//method to open the door
	void openDoors() {
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		doorsOpen = true;
	}

	//method to close the door
	void closeDoors() {
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		doorsOpen = false;
	}

	//method to add certain amount of people into the elevator
	void addPeople(int n){
		//if the power if off, return the statement
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		//open the door before people enter the elevator
		openDoors();

		//make sure the number is not negative
		if(n<0) {
			System.out.println("Number of people must bigger than 0");
			return;
		}

		//make sure the number does not reach max occupants
		if (people + n > maxOccupants) {
			System.out.println("Elevator " + name + " reach the max occupants");
		}
		else {
			people += n;
		}
	}

	//method to remove people from the elevator
	void removePeople(int n) {
		//if the power if off, return the statement
		if(!powerOn) {
			System.out.println("The power needs to be turned on in order to work.");
			return;
		}
		//open the door before people enter
		openDoors();

		//make sure the number is not negative
		if(n<0) {
			System.out.println("Number of people must bigger than 0");
			return;
		}

		//make sure the number does not greater than the people already in the elevator
		if (people < n) {
			System.out.println("There are not enough people to be removed from the elevator");
		}
		else {
			people -= n;
		}
	}

	//method to print the information
	@Override
	public String toString() {
		String doorStatus = "Opened";

		if(!doorsOpen) {
			doorStatus = "Closed";
		}

		String s = String.format("Manufacturer: %s  Elevator: %s   Floor: %d   People: %d   Door: %s", manufacturer, name, floor, people, doorStatus);
		return s;
	}

}