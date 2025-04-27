package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import java.util.Scanner;
public class Aims
{
    public static void main(String[] args)
    {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Adventure", "Christopher Nolan", 169, 21.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 19.9f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 16.3f);
        Book book1 = new Book("Pride and Prejudice", "Romance", 14.99f);
        Book book2 = new Book("Moby Dick", "Adventure", 17.25f);
        Book book3 = new Book("War and Peace", "Historical Fiction", 20.80f);
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "The Beatles", 47, 19.99f, "The Beatles");
        CompactDisc cd2 = new CompactDisc("Hotel California", "Rock", "Eagles", 43, 17.89f, "Eagles");
        CompactDisc cd3 = new CompactDisc("Good Kid, M.A.A.D City", "Hip-Hop", "Kendrick Lamar", 68, 21.75f, "Kendrick Lamar");
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
    int i;
        do 
        {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
            i = scanner.nextInt();
            scanner.nextLine();
            switch (i)
            {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Try agaim");
            }
        } 
        while (i!=0);
        scanner.close();
    }
    public static void viewStore(Store store, Cart cart, Scanner scanner) 
    {
        store.displayStore();
        int i;
        do
        {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
            i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    seeMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Try again");
            }
        } 
        while (i!=0);
    }
    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) 
    {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayDetails();
            int i;
            do {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
                i = scanner.nextInt();
                scanner.nextLine(); 
                switch (i) 
                {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Added");
                        break;
                    case 2:
                        if (media instanceof Playable) 
                            ((Playable) media).play();
                        else 
                            System.out.println("Something wrong, try others");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Try again");
                }
            } while (i != 0);
        }
        else 
            System.out.println("Media not found.");
    }
    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) 
    {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added.");
        } else 
            System.out.println("Media is null");
    }
    public static void playMedia(Store store, Scanner scanner) 
    {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) 
        {
            ((Playable) media).play();
        } 
        else 
            System.out.println("Something wrong, try others");
    }
    public static void updateStore(Store store, Scanner scanner) 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        switch (option) 
        {
            case 1:
                addMediaToStore(store, scanner);
                break;
            case 2:
                removeMediaFromStore(store, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Try again");
        }
    }
    public static void addMediaToStore(Store store, Scanner scanner) 
    {
        System.out.print("Enter the type of media: ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("DVD")) {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            System.out.println("DVD added");
        } 
        else if (type.equalsIgnoreCase("CD")) 
        {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter the artist:");
            String artist = scanner.nextLine();
            CompactDisc cd = new CompactDisc(title, category, director, length,cost, artist);
            store.addMedia(cd);
            System.out.println("CD added");
        }
        else if (type.equalsIgnoreCase("Book")) 
        {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            Book book = new Book(title, category, cost);
            store.addMedia(book);
            System.out.println("Book added");
        } 
        else 
            System.out.println("Try again");
    }
    public static void removeMediaFromStore(Store store, Scanner scanner) 
    {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else 
            System.out.println("Media is null");
    }
    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cart.printCart();
        int i;
        do {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
            i = scanner.nextInt();
            scanner.nextLine(); 
            switch (i) {
                case 1:
                    filterMediasInCart(cart, scanner);
                    break;
                case 2:
                    sortMediasInCart(cart, scanner);
                    break;
                case 3:
                    removeFromCart(cart, scanner);
                    break;
                case 4:
                    playMedia(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Try again");
            }
        } while (i != 0);
    }

    public static void sortMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int i = scanner.nextInt();
        scanner.nextLine(); 
        switch (i) {
            case 1:
                cart.sortByTitleCost();
                break;
            case 2:
                cart.sortByCostTitle();
                break;
            case 0:
                break;
            default:
                System.out.println("Try again");
        }
        cart.printCart();
    }
    public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int i = scanner.nextInt();
        scanner.nextLine(); 
        switch (i) {
            case 1:
                System.out.print("Enter the title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter the ID: ");
                int id = scanner.nextInt();
                cart.searchById(id);
                break;
            case 0:
                break;
            default:
                System.out.println("Try again");
        }
    }
    public static void removeFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed");
        } else
            System.out.println("Media is null");
    }
    public static void playMedia(Cart cart, Scanner scanner) {
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("Try again");
        }
    }
    public static void placeOrder(Cart cart) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        System.out.println("Placing order for " + cart.getItemsOrdered().size());
        for (Media media : cart.getItemsOrdered()) {
            System.out.println("- " + media.getTitle() + " (" + media.getCategory() + ")");
        }
        double total = cart.totalCost();
        System.out.printfln("Total cost: $%.2f%n", total);
        System.out.println("Confirm order? (Y/N)");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            cart.getItemsOrdered().clear();
    }
        System.out.println("Order placed successfully!");
    }
    }
