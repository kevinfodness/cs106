import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Contains a program to run a sound check.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class SoundCheck {

    public static void main(String[] args) {
        // open the sound file as a Java input stream
        String gongFile = "/Volumes/Sites/cs106/Sound Check/src/chicken.au";
        InputStream in = null;
        try {
            in = new FileInputStream(gongFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // create an audiostream from the inputstream
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}
