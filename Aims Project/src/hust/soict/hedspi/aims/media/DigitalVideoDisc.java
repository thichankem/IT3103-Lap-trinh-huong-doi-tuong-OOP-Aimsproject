package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable
{
    public DigitalVideoDisc(String title)
    {
        super(title, "", 0.0f, 0, "");
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost)
    {
        super(title, category, cost, length, director);
    }

    @Override
    public StringBuffer play() throws PlayerException
    {
        if (getLength() > 0)
        {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
            System.out.println("Category: " + getCategory());
            System.out.println("Director: " + getDirector());

            StringBuffer info = new StringBuffer();
            info.append("Playing DVD: ").append(getTitle()).append('\n')
                .append("DVD length: ").append(getLength()).append('\n')
                .append("Category: ").append(getCategory()).append('\n')
                .append("Cost: ").append(getCost());
            return info;
        }
        else
        {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    public boolean isMatch(String title)
    {
        return getTitle().equalsIgnoreCase(title);
    }

    @Override
    public String toString()
    {
        return "DVD: " + getTitle() +
               " - Category: " + getCategory() +
               " - Director: " + getDirector() +
               " - Length: " + getLength() + " mins" +
               " - Cost: " + getCost() + " $";
    }
}
