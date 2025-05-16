package hust.soict.hedspi.aims.media;

public class Disc extends Media
{
    private String director;
    private int length;
    public Disc(String title, String category, float cost, String director, int length) 
    {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, float cost, String director, int length) 
    {
        super(title, cost);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String director, int length) 
    {
        super(title);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String category) 
    {
        super(title, category);
    }
    public Disc(String title, String director, String category, float cost) 
    {
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String director, String category, int length) 
    {
        super(title, category);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String director, String category, float cost, int length) 
    {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String director, String category) 
    {
        super(title, category);
        this.director = director;
    }
    public Disc(String title, String director, float cost) 
    {
        super(title, cost);
        this.director = director;
    }
    public String getDirector() 
    {
        return director;
    }
    public void setDirector(String director) 
    {
        this.director = director;
    }
    public int getLength() 
    {
        return length;
    }
    public void setLength(int length) 
    {
        this.length = length;
    }   
}
