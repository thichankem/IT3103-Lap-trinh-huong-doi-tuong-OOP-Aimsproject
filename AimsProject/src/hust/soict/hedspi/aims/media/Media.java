package hust.soict.hedspi.aims.media;
import java.util.*;
public abstract class Media 
{
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int aMedia = 0;
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public Media(String title)
    {
        this.id = ++aaMedia;
        this.title = title;
    }
    public Media(String title, String category, float cost) 
    {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public int getId() 
    {
        return id;
    }
    public String getTitle() 
    {
        return title;
    }
    public float getCost() 
    {
        return cost;
    }
    public String getCategory()
    {
        return category;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setCost(float cost)
    {
        this.cost = cost;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }
    @Override
    public boolean equals(Object obj) 
    {
        Media media = (Media) obj;
        try
            {
            String title = media.getTitle();
            return this.title.equals(title);
        } 
        catch (NullPointerException e) 
            {
            return false;
        }
    }
    public void displayDetails() 
    {
        System.out.println("----------------MEDIA's DETAILs----------------");
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: " + cost);
    }
    @Override
    public String toString() {
        return "Media [id=" + '\'' + id + '\'' + ", title=" + '\'' + title  + '\''+ ", category=" + category+ ", cost=" + cost + "]";
    }
}
