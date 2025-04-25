package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
        } else {
            System.out.println("The cart is full. Cannot add more media.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void displayCart() {
        System.out.println("Cart contains:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }
    
    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}