package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authors + " : " + getCost() + "$";
    }
}