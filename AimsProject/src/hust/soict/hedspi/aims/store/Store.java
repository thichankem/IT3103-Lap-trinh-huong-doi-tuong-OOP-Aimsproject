package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.*;
public class Store 
{
   private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media)
   {
        if (!itemsInStore.contains(media))
        {
            itemsInStore.add(media);
            System.out.println("Added " + media);
        }
    }
    public void removeMedia(Media media) 
   {
        if (itemsInStore.remove(media)) 
        {
            System.out.println("The dvd with title " + media.getTitle() + " has been removed");
        } 
        else 
            System.out.println("Can not found the dvd with title " + media.getTitle());
    }
  public void displayStore()
   {
        System.out.println("**********************CART***********************\n");
        if (itemsInStore.isEmpty()) 
        {
            System.out.println("There are no dvds in the store");
        }
        else
            for(int i=0; i<itemsInStore.size(); i++){
                int j=i+1;
                System.out.println(j + ". " + itemsInStore.get(i).toString());
        }
  }
    public List<Media> getItemsInStore() 
   {
        return itemsInStore;
    }
    public void setItemsInStore(List<Media> itemsInStore)
   {
        this.itemsInStore = (ArrayList<Media>) itemsInStore;
    }
    public Media findMediaByTitle(String title)
   {
        for (Media media : itemsInStore)
           {
            if (media.getTitle().equalsIgnoreCase(title))
            {
                return media;
            }
        }
        return null;
    }
}
