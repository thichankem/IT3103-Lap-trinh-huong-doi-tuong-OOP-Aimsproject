package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        Media dvd = new DigitalVideoDisc("The Matrix", "Science Fiction", "Wachowski", 136, 19.99f);
        Media cd = new CompactDisc("Hybrid Theory", "Rock", "Warner Bros", "Linkin Park", 0, 15.99f);
        Media book = new Book("Clean Code", "Programming", 35.50f);

        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}