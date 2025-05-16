package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media 
{
    private String title;
    private String category;
    private int ID;
    private float cost;
    private static int nbMedia = 200000001;
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new ComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new ComparatorByTitleCost();
    public Media(String title, String category, float cost) 
    {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.ID = nbMedia++;
    }
    public Media(String title, float cost) 
    {
        this.title = title;
        this.cost = cost;
        this.ID = nbMedia++;
    }
    public Media(String title) 
    {
        this.title = title;
        this.ID = nbMedia++;
    }
    public Media(String title, String category) 
    {
        this.title = title;
        this.category = category;
        this.ID = nbMedia++;
    }
    public String getTitle() 
    {
        return title;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }
    public String getCategory() 
    {
        return category;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }
    public int getID() 
    {
        return ID;
    }
    public void setID(int ID) 
    {
        this.ID = ID;
    }
    public float getCost()
    {
        return cost;
    }
    public void setCost(float cost)
    {
        this.cost= cost;
    }
    public void displayDetails() 
    {
        System.out.println("----------------MEDIA's DETAILs----------------");
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: " + cost);
        System.out.println("---------------END-----------------");
    }
}
