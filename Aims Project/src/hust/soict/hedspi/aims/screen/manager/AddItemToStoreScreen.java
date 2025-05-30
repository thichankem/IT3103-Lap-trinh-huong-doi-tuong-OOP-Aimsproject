package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;
public abstract class AddItemToStoreScreen extends JPanel 
{
    protected Store store;
    protected JFrame frame;
    public AddItemToStoreScreen(Store store, JFrame frame) 
    {
        this.store = store;
        this.frame = frame;
        setLayout(new BorderLayout());
        add(StoreManagerScreen.createNorth(store, frame), BorderLayout.NORTH);
        add(createForm(), BorderLayout.CENTER);
    }
    protected abstract JPanel createForm();
    protected void backToStoreScreen() 
    {
        StoreManagerScreen storeScreen = new StoreManagerScreen(store);
        frame.setContentPane(storeScreen.createMainPanel());
        frame.revalidate();
        frame.repaint();
    }
}
