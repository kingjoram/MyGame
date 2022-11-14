package game;
import javax.swing.*;
import java.awt.*;


public class Images extends JPanel {
    String filename = new String();
    Images(String s) {
        filename = s + ".png";
    }
    @Override
    public void paintComponent (Graphics g) {
        Image image = new ImageIcon(filename).getImage();
        g.drawImage(image, 0, 0, this);        
    }
    
}
