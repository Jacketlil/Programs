
public class Movie {
		
		//instance variables
		String movie, title; //String genre
		int year; // default value
		int rating;  //0-5
	
	// constructor
	Movie(String t, int year, int rating) {
		title = t;
		this.year = year;
		
		if(rating > 5 || rating < 0) rating = 1;
		this.rating = rating;
	
	}

}
