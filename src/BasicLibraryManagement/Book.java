package BasicLibraryManagement;

public class Book {
	private int id;
	private String title;
	private String author;
	private boolean isAvailable = true;
	
	//Contructor to intialize a book
	public Book(int id,String title,String author){
		this.id = id;
		this.title = title;
		this.author = author;
		
		
		
	}
	
	//print the book's details.
	public void displayDetails() {
		System.out.println("Book ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Availability: " + (isAvailable ? "Available" : "Borrowed"));
	}
	
	
	// mark the book as borrowed 
	public void borrowBook() {
		if(isAvailable) {
			isAvailable = false;
			System.out.println("The Book has been Borrowed");
		}
		else {
			System.out.println("The Book is available for Borrow");
		}
	}
	
	//mark the book is returned
	public void returnBook() {
		if(!isAvailable){
			isAvailable= true;
			System.out.println("The book was returned");
		}
		else {
			System.out.println("The book was not borrowed");
		}
	}
	
	public boolean isAvailable() { return isAvailable;	}
	
//	Getter method for id
	public int getId() {return id;}
//	Setter method for id
//	public void setId(int id) { this.id = id; }
	
//	Geteer method for title
	public String getTitle() { return title;}
	
//	Setter method for title
//	public void setTitle(String bookTitle) { this.title = bookTitle; }
	
// Getter method for author
	public String getAuthor() { return author; }
	
//	setter method for author
//	public void setAuthor(String bookAuthor) { this.author = bookAuthor; }

}
