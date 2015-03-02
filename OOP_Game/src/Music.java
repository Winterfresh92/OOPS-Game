/* Carlos Peña III
 * Last Updated: March 2, 2015
 * Known Bugs: None
 */

import java.io.*;
import javax.sound.sampled.*;

public class Music {
    private String[] LevelMusic = {"src/res/Music/The Asteriod Field.wav",
                           "src/res/Music/Anakin vs. Obi-Wan.wav",
                           "src/res/Music/Battle of the Heroes.wav","src/res/Music/Tie Fighter Attack.wav"};
    private String[] Boss = {"src/res/Music/Duel of the Fates.wav","src/res/Music/Duel of the Fates(8bit).wav"};
    private String MenuMusic = "src/res/Music/Main Title.wav";
    private Clip clip;
    public static int track;
    private static boolean bossFight;
    public static boolean Menu;
    private static boolean playing;
    
    private File sound;
    
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
            if(Menu) {
                sound = new File(MenuMusic);
            }
            else {
                if(bossFight == true) {
                    sound = new File(Boss[track]);
                }
                else {
                    sound = new File(LevelMusic[track]);
                }
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
    
    public void Pause() {
        clip.stop();
        playing = false;
    }
    
    public void MenuPlay() {
        if(Menu == true) {
            if(playing == true) {}
            else if(volume != Volume.Mute) {
                play();
            }
        }
        
    }
    public void update() {
        if(clip == null){
            playing = false;
        }
        if (playing == false) { //just incase clip doesnt load properly
            if (volume != Volume.Mute && clip == null) {
                play();
            } 
        }
        else if(playing == true && !clip.isActive()) {  //checks for end of song
            if (volume != Volume.Mute) {                //and plays next song
                next();
            }
        }
    }
}
