package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Cart 
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemOrdered = new ArrayList<>();
    public void addMedia(Media media)
    {
        if(itemOrdered.size()>=MAX_NUMBERS_ORDERED)
        {
            System.out.println("Cart is full");
        }
        else
        {
            itemOrdered.add(media);
            System.out.println(media.getTitle()+"is added");
        }
    }
    public void removeMedia(Media media)
    {
        if(itemOrdered.contains(media))
        {
            itemOrdered.remove(media);
            System.out.println("Item "+media.getTitle()+" is removed");
        }
        else
        {
            System.out.println("Item not found");
        }
    }
    public float totalCost()
    {
        float total=0;
        for(Media media : itemOrdered)
        {
            total+=media.getCost();
        }
        return total;
    }
    public void printcart()
    {
        System.out.println("Items in cart:");
        for(Media media : itemOrdered)
        {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: "+totalCost());
    }
    public void SearchByTitle(String title)
    {
        for(Media media : itemOrdered)
        {
            if(media.getTitle().equalsIgnoreCase(title))
            {
                System.out.println(media.getTitle()+" is found");
            }
            else
            {
                System.out.println("Item not found");
            }
        }
    }
    public void SearchById(int id)
    {
        for(Media media : itemOrdered)
        {
            if(media.getID()==id)
            {
                System.out.println("item with id "+id+" is found");
            }
            else
            {
                System.out.println("Item not found");
            }
        }
    }
    public Media FindMediaByTitle()
    {
        System.out.println("Enter title to search: ");
        try(Scanner scanner = new Scanner(System.in))
        {
        String title = scanner.nextLine();
        for(Media media : itemOrdered)
        {
            if(media.getTitle().equalsIgnoreCase(title))
            {
                System.out.println(media.toString());
                return media;
            }
            else
            {
                System.out.println("Item not found");
                return null;
            }
        }
    }
        return null;
    }
    public void EmptyCart()
    {
        itemOrdered.clear();
        System.out.println("Cart is empty");
    }
    public List<Media> GetItemsOrdered()
    {
        return itemOrdered;
    }
    public void SortByTitleCost()
    {
        Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void SortByCostTitle()
    {
        Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
