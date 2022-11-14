package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Hit {
    private static Shooting shot;
    private static Flight flight;
    private static Bullet bullet;
    private static Birds bird;
    private static JLabel scoreLabel;
    private static Audio hit = new Audio("bird.wav", 0.8);
    
    private static void checkHit() {
        if(bullet.getY() >= bird.getY() && bullet.getY() <= bird.getY() + bird.getH()
                && bullet.getX() >= bird.getX() && bullet.getX() <= bird.getX() + bird.getW()) {
            if(flight.getSpeed() <= 20) {
                flight.changeSpeed(Panels.getScore() + 5);
            }  
            shot.stopTimer();
            hit.Sound();
            hit.setVolume();
            flight.stopTimer();
            Panels.setScore(Panels.getScore() + 1);
            scoreLabel.setText(Integer.toString(Panels.getScore())); 
        }
    }
    private static Timer hitTimer = new Timer(15, new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e) {
                Hit.checkHit();
            }
        });
    
        public Hit(Shooting s, Flight f, Bullet blt, Birds brd, JLabel scL) {
            shot = s;
            flight = f;
            bullet = blt;
            bird = brd;
            scoreLabel = scL;
            hitTimer.start();
        }
}
