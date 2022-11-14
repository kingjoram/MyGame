package game;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Audio {
    private String track;
    private Clip clip = null;
    private FloatControl volumeC = null;  
    private double wt;
    
    public Audio(String track, double wt) {
        this.track = track;
        this.wt = wt;
    }
    
    public void Sound() {
        File f = new File(track);
        AudioInputStream tr = null;
        try {
            tr = AudioSystem.getAudioInputStream(f);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            clip = AudioSystem.getClip();
            clip.open(tr);
            
            volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            
            clip.setFramePosition(0);
            clip.start();
        } catch (LineUnavailableException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    public void setVolume() {
        if(wt < 0) wt = 0;
        if(wt > 1) wt = 1;
        float min = volumeC.getMinimum();
        float max = volumeC.getMaximum();
        volumeC.setValue((max - min) * (float)wt + min);
    }
}
