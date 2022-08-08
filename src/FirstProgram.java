
public class FirstProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//syso + control space
		System.out.println("Hello World!");
		
		//declare variables
	    int[] array= new int[8];
	    int biggest, smallest, temp;

	    //generate the first random number and set it as the biggest and smallest
	    biggest = 0;
	    smallest = 100;

	    for (int x=0 ; x<array.length ; x++){
	      array[x] = (int)(Math.random()*100 + 1);
	      temp = array[x];
	      
	      //compare the next number with previously stored biggest number
	      if(array[x] >= biggest){
	        biggest = temp;
	      }

	      //compare the next number with previously stored smallest number
	      else if (array[x] <= smallest){
	        smallest = temp;
	      }
	    }

	    //print out the numbers
	    for (int x=0 ; x<array.length ; x++){
	      System.out.println((x+1)+ ". " + array[x]);
	    }
	    
	    //print out the biggest and the smallest
	    System.out.println ("The biggest number is: " + biggest);
	    System.out.println ("The smallest number is: " + smallest);
	  }

}
