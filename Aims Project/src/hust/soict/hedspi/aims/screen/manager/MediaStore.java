package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import javax.swing.*;
public class MediaStore extends JPanel 
{
    public MediaStore(Media media) 
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        JButton playButton = new JButton("Play");
        playButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle("Playing Media");
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(new BorderLayout());
            dialog.add(new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER), BorderLayout.CENTER);
            dialog.setVisible(true);
        });
        add(title);
        add(playButton);
    }
}
