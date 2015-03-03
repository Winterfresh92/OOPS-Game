package Music;

/* Carlos Peña III
 * Last Updated: March 2, 2015
 * Known Bugs: None
 */

import java.io.*;
import javax.sound.sampled.*;

public enum SoundEffects {
    Blast("src/res/Sound Effects/blast.wav"),
    SaberSwing("src/res/Sound Effects/swing.wav"),
    SaberHit("src/res/Sound Effects/hit.wav"),
    SaberThrow("src/res/Sound Effects/throw.wav"),
    ForcePush("src/res/Sound Effects/push.wav"),
    ForcePull("src/res/Sound Effects/pull.wav");

    public static enum Volume { //nested class used to set volume for sound effects
        Mute, Low, Medium, High
    }
    public static Volume volume = Volume.High; //sets starting volume of sound effects to medium
    private Clip clip; //each sound effect will have its own clip with its own file
    
    SoundEffects(String soundfile) {    //loading sound effect
        try {
            File sound = new File(soundfile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch(UnsupportedAudioFileException e){
            System.out.println("Unsupported audio file");
        } catch(IOException e){
            System.out.println("IO Exception");
        } catch(LineUnavailableException e){
            System.out.println("Line Unavailable");
        }
    }
    
    public void play() {    //function called to play sound effect, and replay
        if(volume != Volume.Mute) {
            if(clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
        }
    }
    static void init() {    //this will load all sound effects, good to call when loading level
        values();
    }
}
