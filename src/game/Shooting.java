package game;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.*;

public class Shooting implements KeyListener{    
    private static JFrame gameFrame = new JFrame();
    private static Bullet bullet;
    private static int speed = 20;
    private static Audio shot = new Audio("shot.wav", 0.8);
    
    Shooting(Bullet b, JFrame jF) {
        gameFrame = jF;
        bullet = b;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shot.Sound();
            shot.setVolume();
            Shooting.shot();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {}
        
    private static Timer bulletTimer = new Timer(20, new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e) {
            bullet.setY(bullet.getY() - speed);
            if(bullet.getY() < -30 ) {
                
                bulletTimer.stop();
                bullet.setVisible(false);
                gameFrame.setEnabled(true);
            }
        }
    });
    
    public static void shot() { 
        bullet.setY(565);
        bullet.setVisible(true);
        bulletTimer.start();
        gameFrame.setEnabled(false);
    }
    public void stopTimer() {
        bulletTimer.stop();
        bullet.setVisible(false);
        gameFrame.setEnabled(true);
        bullet.setY(565);
    }
}
