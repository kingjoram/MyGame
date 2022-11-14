package game;
import javax.swing.JLayeredPane;

public class Bullet {
    private Images bullet = new Images("bullet");
    
    public Bullet(JLayeredPane jP) {
        jP.add(bullet);
        bullet.setBounds(605, 565, 10, 30);
        bullet.setVisible(false);
        jP.moveToFront(bullet);
    }
    
    public int getX() {
        return bullet.getX();
    }
    public int getY() {
        return bullet.getY();
    }
    public int getW() {
        return bullet.getWidth();
    }
    public int getH() {
        return bullet.getHeight();
    }
    public void setVisible(boolean bool) {
        bullet.setVisible(bool);
    }
    public void setY(int y) {
        bullet.setBounds(605, y, 10, 30);
    }
}
