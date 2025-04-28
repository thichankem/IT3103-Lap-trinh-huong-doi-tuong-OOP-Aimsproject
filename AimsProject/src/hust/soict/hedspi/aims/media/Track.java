package hust.soict.hedspi.aims.media;
public class Track implements Playable
    {
    private String title;
    private int length;
    public Track(String title, int length) 
        {
        this.title = title;
        this.length = length;
    }
    public String getTitle() 
        {
        return title;
    }
    public int getLength() 
        {
        return length;
    }
    @Override
    public void play() 
        {
        System.out.println("Playing Track: " + title);
        System.out.println("Track length: " + length);
    }
    @Override
    public boolean equals(Object obj) 
        {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track track = (Track) obj;
        return title != null && title.equals(track.getTitle());
    }
    @Override
    public int hashCode()
        {
        return title != null ? title.hashCode() : 0;
    }
}
