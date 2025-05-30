package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.Objects;

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
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track other = (Track) obj;
        return length == other.length && Objects.equals(title, other.title);
    }

    @Override
    public StringBuffer play() throws PlayerException
    {
        if (length > 0)
        {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);

            StringBuffer info = new StringBuffer();
            info.append("Playing track: ").append(title).append('\n')
                .append("Track length: ").append(length);
            return info;
        }
        else
        {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}
