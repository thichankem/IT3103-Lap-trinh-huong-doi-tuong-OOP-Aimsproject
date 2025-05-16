package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.event.*;

public class ButtonListener implements ActionListener {
    private JTextField tfDisplay;

    public ButtonListener(JTextField tfDisplay) {
        this.tfDisplay = tfDisplay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
            tfDisplay.setText(tfDisplay.getText() + button);
        } 
        else if (button.equals("DEL")) {
            String currentText = tfDisplay.getText();
            if (!currentText.isEmpty()) {
                tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        } 
        else if (button.equals("C")) {
            tfDisplay.setText("");
        }
    }
}