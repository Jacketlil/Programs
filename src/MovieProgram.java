import java.util.ArrayList;
public class MovieProgram {

	static ArrayList<Movie> movieList = new ArrayList<Movie>();
	public static void main(String[] args) {
		
		Movie m = new Movie("The Avengers", 2015, 5);
	//	m.title = "The Avengers";
		m.year = 2000; 
	//	m.rating = 5;
		
		movieList.add (m);
		
		m = new Movie("Jurassic park", 1997, 4);
		
		movieList.add(m);
		movieList.add( new Movie("Gone with the wind", 1973, 3));
		
		printList2();
		System.out.println(movieList.size());
		 
	}
		static void printList() {
			for (int i = 0 ; i < movieList.size() ; i++) {
				Movie movie = movieList.get(i);
				System.out.println(movie.title + "\t" + movie.year + " stars=" + movie.rating);
			}
		}
		
		static void printList2() {
			for (Movie movie : movieList) {
				System.out.println(movie.title + "\t" + movie.year + " stars=" + movie.rating);
			}
		}
}
