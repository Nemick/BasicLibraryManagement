package BasicLibraryManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Library{
	
	private ArrayList<Book>books;
	private Scanner scanner;
	
	public Library () {
		books = new ArrayList<Book>();
		scanner = new Scanner(System.in);
	}
	
	public void addBook() {
		int bookId = 0;
		
		while(true) {
			try {
				System.out.println("Enter the book's id (MUST BE A NUMBER)");
				bookId = Integer.parseInt(scanner.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("INVALID INPUT!! Please Enter a numeric Id.");
			}
			
		}
		
		System.out.println("Enter the book's title");
		String bookTitle = scanner.nextLine();
		
		System.out.println("Enter the book's author");
		String bookAuthor = scanner.nextLine();
		
		
//		Create and add books
		Book book = new Book(bookId, bookTitle, bookAuthor);
		books.add(book);
		System.out.println("Book added to the Library");
	}
	
//  Close the scanner
	public void closeScanner() {
		scanner.close();
	}
	
//	to search and display books matching id
	
	public Book searchBookById(int id) {
		for(Book book : books) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
//	to search and display books matching the title.
	public Book searchBookByTitle(String title) {
		for (Book book : books) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}
	
//	to search and diplay books by matching author
	public Book searchBookByAuthor(String author) {
		for(Book book : books) {
			if(book.getAuthor().equalsIgnoreCase(author)) {
				return book;
			}
		}
		return null;
	}
//	to print details of all books in the library.
	public void displayAllBooks() {
		if(books.isEmpty()) {
			System.out.println("No Books Available in the Library");
		}
		else {
			for(Book book : books) {
				book.displayDetails();
			}
		}
	}
	
	
//	to allow borrowing a book by its ID.
	public void borrowBook(int id) {
		Book book = searchBookById(id);
		if(book != null) {
			if(book.isAvailable()) {
				book.borrowBook();
			}else {
				System.out.println("The Book is already borrowed");
			}
			
		}
		else {
			System.out.println("Book not Found!!");
		}
		
	}
	
	
//	
	public void returnBook(int id) {
		Book book = searchBookById(id);
		if(book != null) {
			if(!book.isAvailable()) {
				book.returnBook();
			}else {
				System.out.println("The book was not borrowed");
			}
		}else {
		System.out.println("Book not Found!!");
		}
	}
	
	public Scanner getScanner() { return scanner;}
}
