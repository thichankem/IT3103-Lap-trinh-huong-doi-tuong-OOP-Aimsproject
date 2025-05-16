package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media
{
    private List<String> authors = new ArrayList<>();
    public Book(String title, String category, float cost)
    {
        super(title, category, cost);
    }
    public Book(String title, float cost)
    {
        super(title, cost);
    }
    public Book(String title)
    {
        super(title);
    }
    public Book(String title, String category)
    {
        super(title, category);
    }
    public void addAuthor(String authorName)
    {
        authors.add(authorName);
    }
    public void removeAuthor(String authorName)
    {
        authors.remove(authorName);
    }
    public List<String> getAuthors()
    {
        return authors;
    }
    public void setAuthors(List<String> authors)
    {
        this.authors = authors;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Book: ").append(getTitle()).append("\n");
        sb.append("Category: ").append(getCategory()).append("\n");
        sb.append("Cost: ").append(getCost()).append("\n");
        sb.append("Authors: ");
        for (String author : authors)
        {
            sb.append(author).append(", ");
        }
        if (!authors.isEmpty())
        {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
