package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    private Clip clip;

    // Constructor to load the sound
    public SoundPlayer(String soundFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(soundFile);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    // Play once
    public void play() {
        clip.setFramePosition(0); // rewind to the beginning
        clip.start();
    }

    // Loop continuously
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Stop playback
    public void stop() {
        clip.stop();
    }

    // Static method to play looped background music
    public static void playSound(String soundFile) {
        System.out.println("🔊 Attempting to play: " + soundFile);
        try {
            File file = new File("data/" + soundFile);
            System.out.println("📁 Full path: " + file.getAbsolutePath());

            if (!file.exists()) {
                return;
            }

            SoundPlayer player = new SoundPlayer("data/" + soundFile);
            player.loop();  // or player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
