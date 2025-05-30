package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application
{
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(cart, store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        store = new Store();
        cart = new Cart();

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.50f);
        store.addMedia(dvd5);

        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 16.90f);
        store.addMedia(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.99f);
        store.addMedia(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 21.05f);
        store.addMedia(dvd8);

        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 18.50f);
        store.addMedia(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 15.95f);
        store.addMedia(dvd10);

        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon-ho", 132, 23.00f);
        store.addMedia(dvd11);

        Book book5 = new Book("1984", "Dystopian", 14.90f);
        store.addMedia(book5);

        Book book6 = new Book("To Kill a Mockingbird", "Classic", 12.50f);
        store.addMedia(book6);

        Book book7 = new Book("The Great Gatsby", "Classic", 13.75f);
        store.addMedia(book7);

        Book book8 = new Book("Pride and Prejudice", "Romance", 11.99f);
        store.addMedia(book8);

        Book book9 = new Book("Sapiens: A Brief History of Humankind", "Non-Fiction", 27.80f);
        store.addMedia(book9);

        Book book10 = new Book("The Catcher in the Rye", "Fiction", 16.20f);
        store.addMedia(book10);

        Book book11 = new Book("Brave New World", "Dystopian", 15.25f);
        store.addMedia(book11);

        CompactDisc cd5 = new CompactDisc("Thriller", "Pop", "Michael Jackson (Director for Disc)", 0, "Michael Jackson", 20.50f);
        cd5.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
        cd5.addTrack(new Track("Baby Be Mine", 4));
        cd5.addTrack(new Track("The Girl Is Mine", 4));
        cd5.addTrack(new Track("Thriller", 6));
        cd5.addTrack(new Track("Beat It", 4));
        cd5.addTrack(new Track("Billie Jean", 5));
        cd5.addTrack(new Track("Human Nature", 4));
        store.addMedia(cd5);

        CompactDisc cd6 = new CompactDisc("The Wall", "Progressive Rock", "Pink Floyd (Director for Disc)", 0, "Pink Floyd", 24.00f);
        cd6.addTrack(new Track("Another Brick in the Wall, Part 1", 3));
        cd6.addTrack(new Track("The Happiest Days of Our Lives", 2));
        cd6.addTrack(new Track("Another Brick in the Wall, Part 2", 4));
        cd6.addTrack(new Track("Comfortably Numb", 6));
        cd6.addTrack(new Track("Run Like Hell", 4));
        store.addMedia(cd6);

        CompactDisc cd7 = new CompactDisc("Back in Black", "Hard Rock", "AC/DC (Director for Disc)", 0, "AC/DC", 17.99f);
        cd7.addTrack(new Track("Hells Bells", 5));
        cd7.addTrack(new Track("Shoot to Thrill", 5));
        cd7.addTrack(new Track("Back in Black", 4));
        cd7.addTrack(new Track("You Shook Me All Night Long", 4));
        store.addMedia(cd7);

        CompactDisc cd8 = new CompactDisc("Rumours", "Rock", "Fleetwood Mac (Director for Disc)", 0, "Fleetwood Mac", 19.00f);
        cd8.addTrack(new Track("Dreams", 4));
        cd8.addTrack(new Track("Go Your Own Way", 3));
        cd8.addTrack(new Track("The Chain", 4));
        store.addMedia(cd8);

        CompactDisc cd9 = new CompactDisc("Nevermind", "Grunge", "Nirvana (Director for Disc)", 0, "Nirvana", 16.50f);
        cd9.addTrack(new Track("Smells Like Teen Spirit", 5));
        cd9.addTrack(new Track("Come as You Are", 4));
        cd9.addTrack(new Track("Lithium", 4));
        store.addMedia(cd9);

        CompactDisc cd10 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis (Director for Disc)", 0, "Miles Davis", 22.00f);
        cd10.addTrack(new Track("So What", 9));
        cd10.addTrack(new Track("Freddie Freeloader", 10));
        cd10.addTrack(new Track("Blue in Green", 5));
        store.addMedia(cd10);

        CompactDisc cd11 = new CompactDisc("21", "Pop", "Adele (Director for Disc)", 0, "Adele", 21.50f);
        cd11.addTrack(new Track("Rolling in the Deep", 4));
        cd11.addTrack(new Track("Someone Like You", 5));
        cd11.addTrack(new Track("Set Fire to the Rain", 4));
        store.addMedia(cd11);

        Application.launch(TestViewStoreScreen.class, args);
    }
}
