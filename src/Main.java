//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import it.epicode.be.Book;
import it.epicode.be.Element;
import it.epicode.be.LibraryCatalog;
import it.epicode.be.Magazine;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        // Add elements
        Book book1 = new Book("ISBN1", "Harry Potter and the Philosopher's Stone", 1997, 223, "J.K. Rowling", "Fantasy");
        Book book2 = new Book("ISBN2", "The Lord of the Rings: The Fellowship of the Ring", 1954, 609, "J.R.R. Tolkien", "Fantasy");
        Magazine magazine1 = new Magazine("ISBN3", "National Geographic Magazine", 1888, 30, Magazine.Periodicity.MONTHLY);

        libraryCatalog.addElement(book1);
        libraryCatalog.addElement(book2);
        libraryCatalog.addElement(magazine1);

        // Display catalog
        System.out.println("Library Catalog:");
        System.out.println(libraryCatalog);

        // Search by ISBN
        System.out.println("\nSearch by ISBN:");
        Element foundElement = libraryCatalog.searchByISBN("ISBN1");
        System.out.println(foundElement);

        // Search by year
        System.out.println("\nSearch by Year:");
        List<Element> elementsByYear = libraryCatalog.searchByYear(1888);
        elementsByYear.forEach(System.out::println);

        // Search by author
        System.out.println("\nSearch by Author:");
        List<Element> elementsByAuthor = libraryCatalog.searchByAuthor("J.R.R. Tolkien");
        elementsByAuthor.forEach(System.out::println);

        // Remove element
        System.out.println("\nRemove Element:");
        libraryCatalog.removeElementByISBN("ISBN3");
        System.out.println("Library Catalog after removal:");
        System.out.println(libraryCatalog);

        // Save and load catalog
        libraryCatalog.saveToDisk("libraryCatalog.it");
        LibraryCatalog loadedCatalog = LibraryCatalog.loadFromDisk("libraryCatalog.it");
        System.out.println("\nLoaded Catalog from Disk:");
        System.out.println(loadedCatalog);
    }
}

