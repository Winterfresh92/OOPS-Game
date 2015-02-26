//Carlos Peña III 
//Last Updated: February 26, 2015
//Known Bugs: None

import java.io.*;
import javax.sound.sampled.*;

public class Music {
    String[] LevelMusic = {"src/res/Music/The Asteriod Field.wav",
                           "src/res/Music/Anakin vs. Obi-Wan.wav",
                           "src/res/Music/Battle of the Heroes.wav","src/res/Music/Tie Fighter Attack.wav"};
    String[] Boss = {"src/res/Music/Duel of the Fates.wav","src/res/Music/Duel of the Fates(8bit).wav"};
    private Clip clip;
    public static int track;
    public static boolean bossFight;
    public static boolean playing;
    File sound;
    
    public enum Volume {
        Mute, Low, Medium, High
    }
    public static Volume volume;
    
    Music(boolean fight) {
        track = 0;
        volume = Volume.Medium;
        bossFight = fight;
    }
    
    
    public void play(){
        try {
            if(bossFight == true) {
                sound = new File(Boss[track]);
            }
            else {
                sound = new File(LevelMusic[track]);
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch(UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file");
        } catch(IOException e) {
            System.out.println("IO Exception");
        } catch(LineUnavailableException e) {
            System.out.println("Line  Unavailable");
        }
        if(volume != Volume.Mute) {
            if(clip.isRunning()) {
                clip.stop();
            }
//            clip.setFramePosition(0);
            clip.start();
            playing = true;
        }
    }
    
    public void next() {
        playing = false;
        if(bossFight == true){
            if(track == 1) {
                track = 0;
            }
            else{
                track++;
            }
        }
        else{
            if(track == 3) {
                track = 0;
            }
            else {
                track++;
            }
        }
        clip.stop();
        play();
    }
    
    public void Mute() {
        volume = Volume.Mute;
        playing = false;
        clip.stop();
    }
    
    public void update() {
        if(clip == null){
            playing = false;
        }
        if (playing == false) {
            if (volume != Volume.Mute && clip == null) {
                play();
            } 
        }
        else if(playing == true && !clip.isActive()) {
            if (volume != Volume.Mute) {
                System.out.println("update called this");
                next();
            }
        }
    }
}
