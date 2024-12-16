package BasicLibraryManagement;

public class main {

	public static void main(String[] args) {
		Library library = new Library();
		boolean exit = false;
		
		while (!exit) {
			System.out.println("\n LIBRARY MANAGEMENT SYSTEM");
			System.out.println("1. Add a book");
			System.out.println("2. Search for a book by ID");
			System.out.println("3. Search for a book by author");
			System.out.println("4. Search for a book by Title");
			System.out.println("5. Borrow a book");
			System.out.println("6. Return a book");
			System.out.println("7. Display all Books");
			System.out.println("8. Exit");
			System.out.println("Choose an Option: ");
			
			try {
				int choice = Integer.parseInt(library.getScanner().nextLine());
				
				switch (choice){
				case 1 -> library.addBook();
				case 2 -> {
					System.out.println("Enter book ID to search: ");
					int id = Integer.parseInt(library.getScanner().nextLine());
					Book found = library.searchBookById(id);
					if(found != null) {
						found.displayDetails();
					}else System.out.println("Book was not Found");
				}
				case 3 -> {
					System.out.println("Enter Author Name to search: ");
					String author = library.getScanner().nextLine();
					Book found = library.searchBookByAuthor(author);
					if(found != null) found.displayDetails();
					else System.out.println("Book was not Found");
				}
				case 4 ->{
					System.out.println("Enter the Book's Title to search");
					String title = library.getScanner().nextLine();
					Book found = library.searchBookByTitle(title);
					if(found != null)found.displayDetails();
					else System.out.println("Book was not Found");
				}
				case 5 ->{
					System.out.println("Enter the book's Id to borrow: ");
					int id = Integer.parseInt(library.getScanner().nextLine());
					library.borrowBook(id);
				}
				case 6 ->{
					System.out.println("Enter Book ID to return: ");
					int id = Integer.parseInt(library.getScanner().nextLine());
					library.returnBook(id);
				}
				case 7 -> library.displayAllBooks();
				case 8 -> {
					exit = true;
					library.closeScanner();
					System.out.println("GoodBye");
				}
				default -> System.out.println("Invalid option. Please choose a number between 1 and 8.");
				}
			}catch(NumberFormatException e ) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
		
//		Adding Book to the Library (Upto 3 books)
//		for(int i = 0; i<3; i++) {
//			library.addBook();
//		}
//		
//		Book foundBook = library.searchBookById(456);
//		if(foundBook != null) {
//			foundBook.displayDetails();
//		}
//		else {
//			System.out.println("Book not Found!!");
//		}
//		
//		Book foundByAuthor = library.searchBookByAuthor("Ken Walibora");
//		if(foundByAuthor != null) {
//			foundByAuthor.displayDetails();
//		}
//		else {
//			System.out.println("Book not Found!!");
//		}
//		
//		System.out.println();
//		library.borrowBook(456);
//		library.returnBook(456);
////		library.borrowBook(456);
//		library.displayAllBooks();
	}

}
