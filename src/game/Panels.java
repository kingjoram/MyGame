package game;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;



public class Panels {  
    private static JFrame gameFrame = new JFrame("My Game");
    private static JLayeredPane gamePanel = new JLayeredPane();
    private static Font myFont = new Font("TimesRoman", Font.BOLD, 35);
    private static int score = 0;
    private static int speed = 5; 
    
    public static void main(String[] args) {           
        Images background = new Images("BG1");
        background.setSize(1185, 835);
        //Кнопка старта
        JButton playButton = new JButton("Play");
        playButton.setBounds(500, 300, 200, 100);
        gameFrame.setResizable(false);
        ActionListener startListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                gamePanel.removeAll();
                gameFrame.setVisible(false);
                Panels.startGame();
            }
        };
        playButton.addActionListener(startListener);
        playButton.setFont(myFont);
        
        
        gamePanel.setLayout(null);
        gamePanel.add(background);
        gamePanel.add(playButton);
        gamePanel.moveToFront(playButton);
        gameFrame.add(gamePanel);
        gameFrame.setBounds(100, 100, 1200, 840);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }     
    
    private static void startGame() {
        gameFrame.setVisible(true);
        Images background = new Images("BG2");
        background.setBounds(0, 0, 1200, 800);
        JLabel scoreLabel = new JLabel(String.valueOf("0"));
        scoreLabel.setBounds(1125, 720, 50, 50);       
        scoreLabel.setFont(myFont);
        
        gamePanel.setLayout(null);
        gamePanel.add(scoreLabel);
        gamePanel.add(background);
        gamePanel.moveToBack(background);
        
        Bullet bullet = new Bullet(gamePanel);
        Shooting shooting = new Shooting(bullet, gameFrame);
        gameFrame.addKeyListener(shooting);
        gameFrame.add(gamePanel);
        
        Birds bird = new Birds(gamePanel);
        Flight flight = new Flight(bird, scoreLabel, speed);   
        
        Hit hitChecker = new Hit(shooting, flight, bullet, bird, scoreLabel);
    }
    public static void setScore(int newScore) {
        score = newScore;
    }
    public static int getScore() {
        return score;
    }
}
