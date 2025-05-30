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

    public Book() {}

    public List<String> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<String> authors)
    {
        if (authors != null)
        {
            this.authors.clear();
            for (String a : authors)
            {
                addAuthor(a);
            }
        }
    }

    public void addAuthor(String authorName)
    {
        if (authorName != null && !authorName.isEmpty() && !authors.contains(authorName))
        {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName)
    {
        authors.remove(authorName);
    }

    @Override
    public String toString()
    {
        return "Book{" +
               "title='" + getTitle() + '\'' +
               ", category='" + getCategory() + '\'' +
               ", cost=" + getCost() +
               ", authors=" + authors +
               '}';
    }
}
