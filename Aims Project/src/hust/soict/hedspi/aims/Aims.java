package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Aims
{
    private static List<Media> store = new ArrayList<>();
    private static List<Media> cart = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        store.add(new Book("Book A", "Fiction", 100));
        store.add(new DigitalVideoDisc("DVD A", "Movies", "Director A", 120, 150));
        store.add(new CompactDisc("CD A", "Music", "Director B", 120, "Artist A", 60));

        while (!exit)
        {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCart(scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    public static void showMenu()
    {
        System.out.println("AIMS: ");
        System.out.println("------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore(Scanner scanner)
    {
        System.out.println("Items in the store:");
        for (Media media : store)
        {
            System.out.println(media.getTitle() + " - " + media.getCost() + "$");
        }

        boolean back = false;
        while (!back)
        {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    seeCart(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void storeMenu()
    {
        System.out.println("Options: ");
        System.out.println("------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails(Scanner scanner)
    {
        System.out.print("Enter the Title of the media: ");
        String title = scanner.nextLine();
        scanner.nextLine();

        Media foundMedia = null;
        for (Media media : store)
        {
            if (media.getTitle().equals(title))
            {
                foundMedia = media;
                break;
            }
        }

        if (foundMedia != null)
        {
            displayMediaDetails(foundMedia);
            if (foundMedia instanceof Disc)
            {
                mediaDetailsMenu(scanner, foundMedia);
            }
            else
            {
                System.out.println("This media type cannot be played.");
            }
        }
        else
        {
            System.out.println("Media not found!");
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media)
    {
        boolean back = false;
        while (!back)
        {
            System.out.println("Options: ");
            System.out.println("------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    addMediaToCart(media);
                    back = true;
                    break;
                case 2:
                    if (media instanceof Disc)
                    {
                        playMedia(media);
                    }
                    else
                    {
                        System.out.println("This media cannot be played!");
                    }
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void displayMediaDetails(Media media)
    {
        System.out.println("Media details:");
        System.out.println("Title: " + media.getTitle());
        System.out.println("Category: " + media.getCategory());
        System.out.println("Cost: " + media.getCost() + "$");
        if (media instanceof Disc)
        {
            Disc disc = (Disc) media;
            System.out.println("Length: " + disc.getLength() + " minutes");
            System.out.println("Director: " + disc.getDirector());
        }
    }

    public static void playMedia(Media media)
    {
        if (media instanceof DigitalVideoDisc)
        {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            System.out.println("Playing DVD: " + dvd.getTitle());
            System.out.println("Length: " + dvd.getLength() + " minutes");
        }
        else if (media instanceof CompactDisc)
        {
            CompactDisc cd = (CompactDisc) media;
            System.out.println("Playing CD: " + cd.getTitle());
            System.out.println("Artist: " + cd.getArtist());
        }
        else
        {
            System.out.println("This media cannot be played!");
        }
    }

    public static void addMediaToCart(Scanner scanner)
    {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();
        scanner.nextLine();

        Media foundMedia = null;
        for (Media media : store)
        {
            if (media.getTitle().equals(title))
            {
                foundMedia = media;
                break;
            }
        }

        if (foundMedia != null)
        {
            addMediaToCart(foundMedia);
        }
        else
        {
            System.out.println("Media not found!");
        }
    }

    public static void addMediaToCart(Media media)
    {
        cart.add(media);
        System.out.println("Media added to cart: " + media.getTitle());
        if (media instanceof DigitalVideoDisc)
        {
            int dvdCount = 0;
            for (Media m : cart)
            {
                if (m instanceof DigitalVideoDisc)
                {
                    dvdCount++;
                }
            }
            System.out.println("Number of DVDs in cart: " + dvdCount);
        }
    }

    public static void seeCart(Scanner scanner)
    {
        System.out.println("Items in the cart:");
        for (Media media : cart)
        {
            System.out.println(media.getTitle() + " - " + media.getCost() + "$");
        }

        boolean back = false;
        while (!back)
        {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    filterCart(scanner);
                    break;
                case 2:
                    sortCart(scanner);
                    break;
                case 3:
                    removeFromCart(scanner);
                    break;
                case 4:
                    playMedia(scanner);
                    break;
                case 5:
                    placeOrder();
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void cartMenu()
    {
        System.out.println("Options: ");
        System.out.println("------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterCart(Scanner scanner)
    {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                for (Media media : cart)
                {
                    System.out.println(media.getTitle());
                }
                break;
            case 2:
                for (Media media : cart)
                {
                    System.out.println("Title: " + media.getTitle());
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void sortCart(Scanner scanner)
    {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                cart.sort(Comparator.comparing(Media::getTitle));
                System.out.println("Cart sorted by title.");
                break;
            case 2:
                cart.sort(Comparator.comparing(Media::getCost));
                System.out.println("Cart sorted by cost.");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void removeFromCart(Scanner scanner)
    {
        System.out.print("Enter the Title of the media to remove: ");
        String title = scanner.nextLine();
        scanner.nextLine();

        boolean removed = false;
        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).getTitle().equals(title))
            {
                cart.remove(i);
                removed = true;
                break;
            }
        }

        if (removed)
        {
            System.out.println("Media removed from cart.");
        }
        else
        {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMedia(Scanner scanner)
    {
        System.out.print("Enter the name of the media to play: ");
        String name = scanner.nextLine();
        scanner.nextLine();

        Media foundMedia = null;
        for (Media media : cart)
        {
            if (media.getTitle().equals(name))
            {
                foundMedia = media;
                break;
            }
        }

        if (foundMedia != null)
        {
            playMedia(foundMedia);
        }
        else
        {
            System.out.println("Media not found in the cart.");
        }
    }

    public static void placeOrder()
    {
        System.out.println("Order placed successfully!");
        cart.clear();
    }

    public static void updateStore(Scanner scanner)
    {
        System.out.println("Update store functionality is not implemented yet.");
    }
}
