package l2kstudios.gme.swing.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioFactory {
	
//	"/Users/rileylittlefield/Desktop/Opener - 11_2_15, 6.58 PM.wav"
	
	public static StopAudioLoopCallback startAudioClip(String resourcePath, int numberOfLoops) {
		try {
			File file = new File(resourcePath);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(numberOfLoops);
			
			StopAudioLoopCallback stopAudioLoopCallback = new StopAudioLoopCallback();
			stopAudioLoopCallback.setClip(clip);
			return stopAudioLoopCallback;
		} catch (Exception exception) { exception.printStackTrace(); }
		
		return null;
	}
	
	public static class StopAudioLoopCallback {
		private Clip clip;
		
		public void call() {
			clip.stop();
		}
		
		private void setClip(Clip clip) {
			
		}
	}
	
}
