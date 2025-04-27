package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED =20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media) {
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        }else
        {
            itemsOrdered.add(media);
            System.out.println("Added" + media.getTitle() +  "to the cart");
        }
    }
    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed" + media.getTitle() +  "from the cart");
        }else{
            System.out.println("The cart has no" + media.getTitle());
        }
    }
    public void printCart(){
        System.out.println("***********************CART************************");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println((i+1) + ". "  + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost : " + totalCost() + "\n");
        System.out.println("***********************CART***********************");

    }
    public float totalCost(){
         float  total = 0;
        for(Media media : itemsOrdered){
            total+=media.getCost();
        }
        return total;
    }
    public void searchByTitle(String title){
        boolean found = false;
        for(int i =0; i< itemsOrdered.size();i++){
            if (itemsOrdered.get(i).getTitle().equals(title)){
                System.out.println("DVD " + itemsOrdered.get(i).toString() + "founded");
                found = true;
            }
        }
        if(!found){
            System.out.println("The cart has no DVD with title " + title);
        }
    }
    public void searchById(int id){
        boolean found = false;
        for(int i=0; i< itemsOrdered.size() ;i++){
            if(itemsOrdered.get(i).getId() == id){
                System.out.println("We found your DVD :  " + itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("The cart has no DVD with id " + id);
        }
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Cart is empty!");
    }
    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
