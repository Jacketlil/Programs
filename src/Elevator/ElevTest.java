/*
 * Jacky Li
 * 2021/11/30
 * This is the elevator class include the main method, this class include a series of steps
 * includes creating two elevators and assign them to move up or down, add or remove people into the 
 * two elevators, turn the power on and off...
 */
package Elevator;

public class ElevTest {

	public static void main(String[] args) {

		Elevator south = new Elevator("South"); //first elevator
		System.out.println(south.toString());

		Elevator east = new Elevator("East", 5); // second elevator
		System.out.println(east.toString());

		south.addPeople(10); //10 people into South elevator
		System.out.println(south.toString());

		south.goToFloor(4); // South go to 4
		
		south.removePeople(3); // 3 people out of South
		System.out.println(south.toString());

		east.goToFloor(5); // East go to 5
		
		east.addPeople(8); // 8 people into East
		System.out.println(east.toString());

		east.goToFloor(8); // East go to floor 8
		
		east.addPeople(30); // 30 people into East
		System.out.println(east.toString());

		east.goToFloor(30); //East go to floor 30
		
		east.goToFloor(-1); // East go to floor -1
		
		south.goToFloor(2); // South go to floor 2

		east.goToFloor(2); // East go to floor 2

		east.openDoors(); // open the door of east elevator

		Elevator.setPowerState(false);// turn off the power for all elevator 

		Elevator.setPowerState(false);// should not display message
		
		//the actions below should not happen due to the power failure
		//they should display an error message
		
		south.openDoors(); 

		south.addPeople(2);
		east.openDoors(); 

		south.up();
		
		south.down();
		
		south.goToFloor(18); 

		east.goToFloor(18);

		Elevator.setPowerState(true); // turn on the power (should display a message)

		Elevator.setPowerState(true); // should not display any message

		Elevator.setPowerState(true);
			
		System.out.println(south.toString());
		
		//move south elevator to the ground floor, remove all people within the elevator
		south.goToFloor(1);
		south.removePeople(7);
		System.out.println(south.toString());
		
		//south move up one floor each time until it reaches floor 10
		//open the door and close the door each time when it moves
		for (int x = 1; x<10 ; x++) {
			south.up();
			south.openDoors();
			System.out.println(south.toString());
			south.closeDoors();
			System.out.println(south.toString());
		}
		
	}
	



}