package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.JLabel;

public class Flight {
    private static Birds bird;
    private static int speed;
    private static Random toLeft = new Random();
    private static Random rand = new Random();
    private static boolean isLeft = true;
    private static JLabel scoreLabel;
    
    public Flight(Birds b, JLabel scL, int sp) {
        bird = b;
        scoreLabel = scL;
        speed = sp;
        Flight.startFlight();        
    }
    
    private static void startFlight() {
        if(toLeft.nextBoolean()) {
            bird.setImage("birdToRight");
            bird.setX(-1 * rand.nextInt(150, 250));
            bird.setY(rand.nextInt(100));
            bird.setVisible(true);
            isLeft = true;
            speed = Math.abs(speed);
        }
        else {
            bird.setImage("birdToLeft");
            bird.setX(rand.nextInt(1200, 1400));
            bird.setY(rand.nextInt(100));
            bird.setVisible(true);
            isLeft = false;
            speed = -1 * Math.abs(speed);
        }
        birdTimer.start();
    } 
    private static Timer birdTimer = new Timer(20, new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e) {
            bird.setX(bird.getX() + speed);
            if((isLeft && bird.getX() >= 1350) || (!isLeft && bird.getX() <= -150)) {
                birdTimer.stop();
                bird.setVisible(false);
                speed = 5;
                Panels.setScore(0);
                scoreLabel.setText("0");
                Flight.startFlight();
            }
        }
    });
    public void stopTimer() {
        birdTimer.stop();
        bird.setVisible(false);
        Flight.startFlight();
    }
    public void changeSpeed(int newSpeed) {
        speed = newSpeed;
    }
    public int getSpeed() {
        return Math.abs(speed);
    }
}
