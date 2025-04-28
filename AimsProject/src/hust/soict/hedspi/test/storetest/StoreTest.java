package hust.soict.hedspi.aims.storetest;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
public class StoreTest
    {
    public static void main(String[] args)
        {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "George Lucas", 128, 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        System.out.println("=== First display ===");
        store.displayStore();
        System.out.println("\n=== Second display ===");
        store.displayStore();
        System.out.println("\n=== After removing Aladin ===");
        store.removeMedia(dvd3);
        store.displayStore();
    }
}
