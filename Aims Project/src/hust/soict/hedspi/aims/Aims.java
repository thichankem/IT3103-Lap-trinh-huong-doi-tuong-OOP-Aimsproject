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
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 120);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 16);
        Book book1 = new Book("Pride and Prejudice", "Romance", 14.99f);
        Book book2 = new Book("Moby Dick", "Adventure", 17.25f);
        Book book3 = new Book("War and Peace", "Historical Fiction", 20.80f);
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", 19.99f, "The Beatles", 27);
        CompactDisc cd2 = new CompactDisc("Hotel California", "Rock", 17.89f, "Eagles", 25);
        CompactDisc cd3 = new CompactDisc("Good Kid, M.A.A.D City", "Hip-Hop", 21.75f, "Kendrick Lamar", 17);
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
            showMenu();
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
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid! Please choose a number: 0-1-2-3");
            }
        } 
        while (i!=0);
        scanner.close();
    }
    public static void showMenu () 
    {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        System.out.print("Enter your choice: ");
    }
    public static void viewStore(Store store, Cart cart, Scanner scanner) 
    {
        store.displayStore();
        int i;
        do
        {
            storeMenu();
            i = scanner.nextInt();
            scanner.nextLine();
            switch (i) 
            {
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
                    System.out.println("Invalid! Please choose a number: 0-1-2-3-4");
            }
        } 
        while (i!=0);
    }
    public static void storeMenu() 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        System.out.print("Enter your choice: ");
    }
    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) 
    {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayDetails();
            int i;
            do {
                mediaDetailsMenu();
                i = scanner.nextInt();
                scanner.nextLine(); 
                switch (i) 
                {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) 
                        {
                            ((Playable) media).play();
                        } 
                        else 
                        {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number: 0-1-2");
                }
            } while (i != 0);
        }
        else 
        {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) 
    {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Store store, Scanner scanner) 
    {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) 
        {
            ((Playable) media).play();
        } 
        else 
        {
            System.out.println("This media cannot be played or not found.");
        }
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
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
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
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    public static void addMediaToStore(Store store, Scanner scanner) 
    {
        System.out.print("Enter the type of media (CD/DVD/Book): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("DVD")) {
            scanner.nextLine();
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
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, cost, length);
            store.addMedia(dvd);
            System.out.println("DVD added to store.");
        } 
        else if (type.equalsIgnoreCase("CD")) 
        {
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the director:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter the artist:");
            String artist = scanner.nextLine();

            CompactDisc cd = new CompactDisc(title, category, cost, artist, length);
            store.addMedia(cd);
            System.out.println("CD added to store.");
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
            System.out.println("Book added to store.");
        } 
        else 
        {
            System.out.println("Invalid media type.");
        }
    }
    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }
    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cart.printcart();
        int i;
        do {
            cartMenu();
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
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
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
        System.out.print("Enter your choice: ");
        int i = scanner.nextInt();
        scanner.nextLine(); 
        switch (i) {
            case 1:
                cart.SortByTitleCost();
                break;
            case 2:
                cart.SortByCostTitle();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
        cart.printcart();
    }
    public static void filterMediasInCart(Cart cart, Scanner scanner) 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");
        int i = scanner.nextInt();
        scanner.nextLine(); 
        switch (i) {
            case 1:
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                cart.SearchByTitle(title);
                break;
            case 2:
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                cart.SearchById(id);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }
    public static void removeFromCart(Cart cart, Scanner scanner) 
    {
        Media media = cart.FindMediaByTitle();
        if (media != null) 
        {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else 
        {
            System.out.println("Media not found.");
        }
    }
    public static void playMedia(Cart cart, Scanner scanner) 
    {
        Media media = cart.FindMediaByTitle();
        if (media != null) 
        {
            ((Playable) media).play();
        } else 
        {
            System.out.println("This media cannot be played or not found.");
        }
    }
    public static void placeOrder(Cart cart) 
    {
        if (cart.GetItemsOrdered().isEmpty()) 
        {
            System.out.println("Cart is empty. Nothing to order.");
            return;
        }
        System.out.println("Placing order for " + cart.GetItemsOrdered().size() + " items:");
        for (Media media : cart.GetItemsOrdered()) {
            System.out.println("- " + media.getTitle() + " (" + media.getCategory() + ")");
        }
        double total = cart.totalCost();
        System.out.printf("Total cost: $%.2f%n", total);
        cart.GetItemsOrdered().clear();
        System.out.println("Order placed successfully!");
    }
    public static void cartMenu() 
    {
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
        System.out.print("Enter your choice: ");
    }
    }