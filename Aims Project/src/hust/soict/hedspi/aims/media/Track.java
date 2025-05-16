package hust.soict.hedspi.aims.media;
public class Track implements Playable 
{
    private final String title;
    private final String artist;
    private final int length;
    public Track(String title, String artist, int length) 
    {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }
    public String getTitle() 
    {
        return title;
    }
    public String getArtist() 
    {
        return artist;
    }
    public int getLength() 
    {
        return length;
    }
    @Override
    public void play() 
    {
        System.out.println("Playing track: " + title + " by " + artist);
    }
}

