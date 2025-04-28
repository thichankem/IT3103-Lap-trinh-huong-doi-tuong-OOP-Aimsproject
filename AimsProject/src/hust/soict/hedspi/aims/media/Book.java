package hust.soict.hedspi.aims.media;
import java.util.*;
public class Book extends Media 
{
    private List<String> authors = new ArrayList<>();
    public Book(String title) 
    {
        super(title);
    }
    public Book(String title, String category, float cost) 
    {
        super(title, category, cost);
    }
    public List<String> getAuthors() 
    {
        return authors;
    }
    public void setAuthors(List<String> authors) 
    {
        this.authors = authors;
    }
    public void addAuthor(String authorName) 
    {
        if (!authors.contains(authorName)) 
        {
            authors.add(authorName);
            System.out.println("Added "+authorName);
        } 
        else 
            System.out.println(authorName+" is already in the store");
    }
    public void removeAuthor(String authorName) 
    {
        if (authors.contains(authorName)) 
        {
            authors.remove(authorName);
            System.out.println("Removed "+authorName);
        } 
        else 
            System.out.println(authorName+" is not in the store");
    }
    @Override
    public String toString()
    {
        return "Book - Title: "+getTitle()+" - Category: "+getCategory()+" - Authors: "+authors;
    }
}
