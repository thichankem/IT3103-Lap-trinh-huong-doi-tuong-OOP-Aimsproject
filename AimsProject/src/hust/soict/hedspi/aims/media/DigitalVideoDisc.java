package hust.soict.hedspi.aims.media;
import java.util.*;
public class DigitalVideoDisc extends Disc implements Playable 
{
    private static int nbDigitalVideoDiscs = 0;
    public static int getNbDigitalVideoDiscs() 
    {
        return nbDigitalVideoDiscs;
    }
    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) 
    {
        if (nbDigitalVideoDiscs>=0) 
        {
            DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
        } 
        else 
            System.out.println("Try again (>=0)");
    }
    public DigitalVideoDisc(String title) 
    {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) 
    {
        super(title, category, director, length, cost);
    }
    public DigitalVideoDisc(String category, String title, float cost) 
    {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) 
    {
        super(title, category, cost);
        setDirector(director);
    }
    @Override
    public String toString() 
    {
        return String.format("DVD - Title: %s | Category: %s | Director: %s | Length: %d | Price: %.2f ",getTitle(), getCategory(), getDirector(), getLength(), getCost());
    }
    @Override
    public void play() 
    {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
