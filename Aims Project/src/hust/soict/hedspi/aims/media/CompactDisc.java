package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable 
{
    private final String artist;
    private final List<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, String artist, int length) 
    {
        super(title, category, cost, artist, length);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost) 
    {
        super(title, category, cost);
        this.artist = "";
    }
    public CompactDisc(String title, String category, float cost, String artist) 
    {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public void addTrack(Track track) 
    {
        this.tracks.add(track);
    }
    
    public void removeTrack(Track track) 
    {
        this.tracks.remove(track);
    }
    @Override
    public void play() 
    {
        System.out.println("Playing CD: " + this.getTitle());
        for (Track track : tracks) 
        {
            track.play();
        }
    }
}
