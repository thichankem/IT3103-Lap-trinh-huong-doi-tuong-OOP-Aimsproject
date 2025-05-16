package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import java.util.List;
import javax.swing.*;
public class StoreManagerScreen
{
    private final Store store;
    private final JFrame frame;
    public StoreManagerScreen(Store store)
    {
        this.store = store;
        frame = new JFrame("Store Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());
        showStoreScreen();
        frame.setVisible(true);
    }
    private JPanel createNorth()
    {
    return createNorth(store, frame);
    }
    private void showStoreScreen() 
    {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createNorth(store, frame), BorderLayout.NORTH);
        mainPanel.add(createCenter(), BorderLayout.CENTER);
        frame.setContentPane(mainPanel);
        frame.revalidate();
        frame.repaint();
    }
    public static JPanel createNorth(Store store, JFrame frame)
    {
    JPanel north = new JPanel();
    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
    north.add(createMenuBar(store, frame));
    north.add(createHeader());
    return north;
    }
public static JPanel createHeader()
    {
    JPanel header = new JPanel();
    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
    JLabel title = new JLabel("AIMS");
    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
    title.setForeground(Color.CYAN);
    header.add(Box.createRigidArea(new Dimension(10, 10)));
    header.add(title);
    header.add(Box.createHorizontalGlue());
    header.add(Box.createRigidArea(new Dimension(10, 10)));
    return header;
    }
public static JMenuBar createMenuBar(Store store, JFrame frame) 
    {
    JMenu menu = new JMenu("Options");
    JMenuItem viewStoreItem = new JMenuItem("View store");
    viewStoreItem.addActionListener(e -> {
        frame.getContentPane().removeAll();
        StoreManagerScreen screen = new StoreManagerScreen(store);
        frame.add(screen.createNorth(), BorderLayout.NORTH);
        frame.add(screen.createCenter(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    });
    JMenu updateStoreMenu = new JMenu("Update Store");
    JMenuItem addBookItem = new JMenuItem("Add Book");
    addBookItem.addActionListener(e -> {
        frame.setContentPane(new AddBookToStoreScreen(store, frame));
        frame.revalidate();
        frame.repaint();
    });
    JMenuItem addCDItem = new JMenuItem("Add CD");
    addCDItem.addActionListener(e -> {
        frame.setContentPane(new AddBookToStoreScreen(store, frame));
        frame.revalidate();
        frame.repaint();
    });
    JMenuItem addDVDItem = new JMenuItem("Add DVD");
    addDVDItem.addActionListener(e -> {
        frame.setContentPane(new AddDigitalVideoDiscToStoreScreen(store, frame));
        frame.revalidate();
        frame.repaint();
    });
    updateStoreMenu.add(addBookItem);
    updateStoreMenu.add(addCDItem);
    updateStoreMenu.add(addDVDItem);
    menu.add(viewStoreItem);
    menu.add(updateStoreMenu);
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    menuBar.add(menu);
    return menuBar;
    }
    private JPanel createCenter()
    {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        List<Media> mediaInStore = store.getItemsInStore();
        int numberOfItems = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < numberOfItems; i++) 
        {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
    public static void main(String[] args) 
    {
        Store store = new Store();
    store.addMedia(new DigitalVideoDisc("Action", "Catching Fire", 4.9f));
    store.addMedia(new DigitalVideoDisc("Action", "Hunger Games", 5.5f));
    store.addMedia(new DigitalVideoDisc("Action", "Mockingjay", 5.1f));
    store.addMedia(new DigitalVideoDisc("Fantasy", "Harry Potter 1", 3.0f));
    store.addMedia(new DigitalVideoDisc("Fantasy", "Harry Potter 2", 3.5f));
    store.addMedia(new DigitalVideoDisc("Fantasy", "Harry Potter 3", 5.0f));
    store.addMedia(new DigitalVideoDisc("Fantasy", "Harry Potter 4", 4.5f));
    store.addMedia(new DigitalVideoDisc("Music", "Bolt Cutters", 10.39f));
    store.addMedia(new DigitalVideoDisc("Music", "Future Nostalgia", 9.6f));
        new StoreManagerScreen(store); 
    }
    public Container createMainPanel() 
    {
        throw new UnsupportedOperationException("Unimplemented method 'createMainPanel'");
    }
}
