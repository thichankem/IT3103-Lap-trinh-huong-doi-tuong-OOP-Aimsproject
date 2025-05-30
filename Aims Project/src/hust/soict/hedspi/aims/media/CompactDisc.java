package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable
{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, String director, int length, String artist, float cost)
    {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist()
    {
        return artist;
    }

    public void addTrack(Track track)
    {
        if (tracks.contains(track))
        {
            System.out.println("Track already exists in the list.");
        }
        else
        {
            tracks.add(track);
            System.out.println("Track added successfully.");
        }
    }

    public void removeTrack(Track track)
    {
        if (tracks.contains(track))
        {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        }
        else
        {
            System.out.println("Track does not exist in the list.");
        }
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
    public StringBuffer play() throws PlayerException
    {
        if (getLength() > 0)
        {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("CD length: " + getLength());

            StringBuffer info = new StringBuffer();
            info.append("Playing CD: ").append(getTitle()).append("\n")
                .append("CD length: ").append(getLength()).append("\n");

            for (Track t : tracks)
            {
                info.append(t.play()).append("\n");
            }
            return info;
        }
        else
        {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString()
    {
        return "CD: " + getTitle() +
               " - Category: " + getCategory() +
               " - Artist: " + artist +
               " - Cost: " + getCost() + " $";
    }
}
