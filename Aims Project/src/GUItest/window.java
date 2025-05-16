package GUItest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class window extends JFrame 
{
    public window() 
    {
        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 750);
        setVisible(true);
        setLayout(new BorderLayout());
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.CYAN);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(3, 3, 10, 10)); 
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[][] media = {
            {"Book 1", "10"},
            {"Book 2", "15"},
            {"Book 3", "20"},
            {"CD 1", "5"},
            {"CD 2", "8"},
            {"CD 3", "12"},
            {"DVD 1", "25"},
            {"DVD 2", "30"},
            {"DVD 3", "35"}
        };
        for (String[] item : media) 
        {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            itemPanel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel(item[0], SwingConstants.CENTER);
            JLabel costLabel = new JLabel(item[1] + " $", SwingConstants.CENTER);
            JButton playButton = new JButton("Play");

            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            costLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            itemPanel.add(Box.createVerticalStrut(10));
            itemPanel.add(titleLabel);
            itemPanel.add(Box.createVerticalStrut(10));
            itemPanel.add(costLabel);
            itemPanel.add(Box.createVerticalStrut(10));
            itemPanel.add(playButton);
            itemPanel.add(Box.createVerticalGlue());

            centerPanel.add(itemPanel);
        }

        add(centerPanel, BorderLayout.CENTER);



        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View store");
        JMenu updateStoreMenu = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        updateStoreMenu.add(addBookItem);
        updateStoreMenu.add(addCDItem);
        updateStoreMenu.add(addDVDItem);

        optionsMenu.add(viewStoreItem);
        optionsMenu.add(updateStoreMenu);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);
        setVisible(true);
    }
}
