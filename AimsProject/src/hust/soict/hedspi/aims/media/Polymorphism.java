package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("CD1", "Category1", 10.0f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Science Fiction", 10.0f);
        Book book = new Book("Effective Java", "Programming", 45.99f);

        media.add(cd);
        media.add(dvd);
        media.add(book);

        for (Media m : media) {
            System.out.println(m.toString());
        }

    }
}