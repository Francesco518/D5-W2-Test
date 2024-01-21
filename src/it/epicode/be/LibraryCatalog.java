package it.epicode.be;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog implements Serializable {
    private List<Element> elements;

    public LibraryCatalog() {
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElementByISBN(String isbn) {
        elements.removeIf(element -> element.getIsbn().equals(isbn));
    }

    public Element searchByISBN(String isbn) {
        return elements.stream()
                .filter(element -> element.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Element> searchByYear(int year) {
        return elements.stream()
                .filter(element -> element.getYear() == year)
                .toList();
    }

    public List<Element> searchByAuthor(String author) {
        return elements.stream()
                .filter(element -> element instanceof Book && ((Book) element).getAuthor().equals(author))
                .toList();
    }

    public void saveToDisk(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LibraryCatalog loadFromDisk(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (LibraryCatalog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new LibraryCatalog(); // Return an empty catalog in case of failure
        }
    }

    @Override
    public String toString() {
        return "LibraryCatalog{" +
                "elements=" + elements +
                '}';
    }
}
