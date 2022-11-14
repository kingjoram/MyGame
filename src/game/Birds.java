package game;
import javax.swing.JLayeredPane;

public class Birds {
    private Images bird = new Images("birdToRight");
    JLayeredPane gamePanel;
    public Birds(JLayeredPane jP) {
        jP.add(bird);
        bird.setBounds(150, 150, 150, 90);
        bird.setVisible(false);
        jP.moveToFront(bird);
        gamePanel = jP;
    }
    
    public int getX() {
        return bird.getX();
    }
    public int getY() {
        return bird.getY();
    }
    public int getW() {
        return bird.getWidth();
    }
    public int getH() {
        return bird.getHeight();
    }    
    
    public void setVisible(boolean bool) {
        bird.setVisible(bool);
    }
    public void setX(int x) {
        bird.setBounds(x, bird.getY(), 150, 90);
    }
    public void setY(int y) {
        bird.setBounds(bird.getX(), y, 150, 90);
    }
    public void setImage(String s) {
        bird = new Images(s);
        gamePanel.add(bird);
        gamePanel.moveToFront(bird);
    }
}
