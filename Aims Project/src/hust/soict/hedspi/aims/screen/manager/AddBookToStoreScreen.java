package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import javax.swing.*;
public class AddBookToStoreScreen extends AddItemToStoreScreen 
{
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    public AddBookToStoreScreen(Store store, JFrame frame) 
    {
        super(store, frame);
    }
    @Override
    protected JPanel createForm() 
    {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String category = categoryField.getText().trim();
            float cost;
            try 
            {
                cost = Float.parseFloat(costField.getText().trim());
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(this, "Cost must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (title.isEmpty() || category.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            store.addMedia(new Book(title, category, cost));
            JOptionPane.showMessageDialog(this, "Book added to store!");
            backToStoreScreen();
        });
        panel.add(addButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> backToStoreScreen());
        panel.add(cancelButton);
        return panel;
    }
}
