package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart
{
    public static final int MAX_NUMBERS_ORDERED = 500;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered()
    {
        return FXCollections.observableArrayList(itemsOrdered);
    }

    public void print()
    {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty())
        {
            System.out.println("The cart is empty!");
        }
        else
        {
            float totalCost = 0.0f;
            for (int i = 0; i < itemsOrdered.size(); i++)
            {
                Media media = itemsOrdered.get(i);
                System.out.printf("%d. %s%n", (i + 1), media);
                totalCost += media.getCost();
            }
            System.out.printf("Total cost: %.2f%n", totalCost);
        }
        System.out.println("***************************************************");
    }

    public int addMedia(Media media) throws LimitExceededException
    {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED)
        {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart");
            return 1;
        }
        throw new LimitExceededException("ERROR: The cart is almost full");
    }

    public int removeMedia(Media media)
    {
        if (itemsOrdered.contains(media))
        {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart");
            return 1;
        }
        System.out.println("The media is not in the cart");
        return 0;
    }

    public float totalCost()
    {
        float total = 0.0f;
        for (Media media : itemsOrdered)
        {
            total += media.getCost();
        }
        return total;
    }

    public void searchById(int id)
    {
        for (Media media : itemsOrdered)
        {
            if (media.getId() == id)
            {
                System.out.println("Found item: " + media);
                return;
            }
        }
        System.out.println("No match found for ID: " + id);
    }

    public void searchByTitle(String title)
    {
        boolean found = false;
        for (Media media : itemsOrdered)
        {
            if (media.getTitle().equalsIgnoreCase(title))
            {
                System.out.println("Found item: " + media);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No match found for title: " + title);
        }
    }
}
