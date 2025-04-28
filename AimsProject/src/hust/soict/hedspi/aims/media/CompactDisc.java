package hust.soict.hedspi.aims.media;
import java.util.*;
public class CompactDisc extends Disc implements Playable 
{
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc(String title)
    {
        super(title);
    }
    public CompactDisc(String title, String category, float cost) 
    {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, String director, float cost) 
    {
        super(title, category, director, cost);
    }
    public CompactDisc(String title, String category, String director, int length, float cost, String artist) 
    {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public String getArtist() 
    {
        return artist;
    }
    public void setArtist(String artist) 
    {
        this.artist = artist;
    }
    public List<Track> getTracks() 
    {
        return tracks;
    }
    public void addTrack(Track track) 
    {
        if (track == null) 
        {
            System.out.println("Track is null");
            return;
        }
        if (!tracks.contains(track)) 
        {
            tracks.add(track);
            System.out.println("Track added");
        } 
        else 
            System.out.println("Track already exists");
    }
    public void removeTrack(Track track) 
{
        if (track == null) 
        {
            System.out.println("Track is null");
            return;
        }
        if (tracks.remove(track))
        {
            System.out.println("Track removed");
        } 
        else 
            System.out.println("Track does not exist");
    }
    @Override
    public int getLength() 
    {
        int totalLength = 0;
        for (Track track : tracks)
            {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public String toString() 
    {
        return "CD - Title: " + getTitle() + 
               " | Category: " + getCategory() + 
               " | Director: " + getDirector() +
               " | Artist: " + artist + 
               " | Total Length: " + getLength() +
               " | Cost: " + getCost();
    }
    @Override
    public void play()
    {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total length: " + getLength());
        for (Track track : tracks)
            {
            track.play();
        }
    }
}
