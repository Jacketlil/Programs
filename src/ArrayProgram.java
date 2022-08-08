
public class ArrayProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //declare variables
		//syso + control space
		System.out.println("Hello World!");
	    int num[] = new int[12];
	    int biggest, smallest, temp;

	    //generate the first random number and set it as the biggest and smallest
	    num[0] = (int)(Math.random()*100 + 1);
	    biggest = num[0];
	    smallest = num[0];

	    for (int x=1 ; x<12 ; x++){
	      num[x] = (int)(Math.random()*100 + 1);
	      temp = num[x];
	      
	      //compare the next number with previously stored biggest number
	      if(num[x] >= biggest){
	        biggest = temp;
	      }

	      //compare the next number with previously stored smallest number
	      else if (num[x] <= smallest){
	        smallest = temp;
	      }
	    }

	    //print out the numbers
	    for (int x=0 ; x<12 ; x++){
	      System.out.println((x+1)+ ". " + num[x]);
	    }
	    
	    //print out the biggest and the smallest
	    System.out.println ("The biggest number is: " + biggest);
	    System.out.println ("The smallest number is: " + smallest);
	  }

}
