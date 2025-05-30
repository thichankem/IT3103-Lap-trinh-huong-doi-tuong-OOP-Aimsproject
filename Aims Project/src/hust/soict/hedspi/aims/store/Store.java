package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.List;
public class Store
{
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore()
    {
        return itemsInStore;
    }
    public void setItemsInStore(ArrayList<Media> itemsInStore)
    {
        this.itemsInStore = itemsInStore;
    }
    public List<Media> getArrayListItems()
    {
        return new ArrayList<>(itemsInStore);
    }
    public void addMedia(Media media)
    {
        if (media != null)
        {
            itemsInStore.add(media);
            System.out.println("The media has been added to the store: " + media.getTitle());
        }
        else
        {
            System.out.println("Cannot add a null media to the store.");
        }
    }
    public void removeMedia(Media media)
    {
        if (itemsInStore.contains(media))
        {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store: " + media.getTitle());
        }
        else
        {
            System.out.println("The media is not available in the store.");
        }
    }
    public void displayStore()
    {
        System.out.println("**********************STORE**********************");
        System.out.println("Items currently in the store:");
        if (itemsInStore.isEmpty())
        {
            System.out.println("The store is empty.");
        }
        else
        {
            for (Media media : itemsInStore)
            {
                System.out.println(media.getTitle() + " (" + media.getCategory() + ") - " + media.getCost() + "$");
            }
        }
        System.out.println("**********************STORE**********************");
    }
}