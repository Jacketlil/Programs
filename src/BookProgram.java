/*
 * Jacky Li
 * 2021/09/22
 * Creating a book ArrayList and adding information such as name, year of publication, and price, 
 * and print out the whole array. After deleting the unmatched items, print the whole array out again
 */

import java.util.ArrayList;
public class BookProgram {

	// declare booklist as a global variable
	static ArrayList<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {

		// adding items into the arraylist
		Book b = new Book("The Great Gatsby", 1925, 20.03);
		bookList.add(b);
		b = new Book("Life Of Pi", 2012, 20.79);
		bookList.add(b);
		b = new Book("Great Expectations", 1861, 14.00);
		bookList.add(b);
		b = new Book("1984", 1949, 12.81);
		bookList.add(b);
		b = new Book("Atonement", 2001, 26.02);
		bookList.add(b);
		b = new Book("White Teeth", 2000, 9.55);
		bookList.add(b);

		printList();
		removeList();

		System.out.println();
		System.out.println("After removing the books before 2000:");
		System.out.println();

		printList();

	}

	// method of printing the array
	static void printList() {
		String name = "Name";
		String year = "Year of Publication";
		String price = "Price";
		System.out.printf("|%-25s | %-20s | %-8s|%n", name, year, price);
		for (Book book : bookList) {
			System.out.printf("|%-25s | %-20d | %-8.3f|%n", book.title, book.year, book.price);
		}
	}

	// method of deleting books before 2000
	static void removeList() {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.year < 2000) {
				bookList.remove(i);
				i--;
			}
		}
	}
}

// create a new class - Book
class Book {

	// declare variables
	String title;
	int year;
	double price;

	Book(String title, int year, double price) {
		this.title = title;
		this.year = year;
		this.price = price;
	}
}