package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added to the list");
        } else {
            System.out.println("Track already exists");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed from the list");
        } else {
            System.out.println("Track does not exist");
        }
    }
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public String toString() {
        return "CD - " + getTitle()
             + " - " + getCategory()
             + " - " + getDirector()
             + " - " + getLength()
             + " - " + getCost()
             + " - " + artist;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD artist: " + artist);
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}
