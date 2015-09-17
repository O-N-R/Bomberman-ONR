package game.resources;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sounds{
	public static AudioStream EXPLOSION;
	public static AudioStream POWERUP;
	public static AudioStream DROPBOMB;
	public static AudioStream DEATH;
	public static AudioStream SELECT;
	public static AudioStream GARDENBG;
	
	public static void playExplosion(){
		try{
			EXPLOSION = new AudioStream(new FileInputStream("res/explosion.wav"));
			AudioPlayer.player.start(EXPLOSION);
		} catch (Exception e) { }
	}
	
	public static void playPowerup(){
		try{
			POWERUP = new AudioStream(new FileInputStream("res/powerup.wav"));
			AudioPlayer.player.start(POWERUP);
		} catch (Exception e) { }
	}
	
	public static void playDropbomb(){
		try{
			DROPBOMB = new AudioStream(new FileInputStream("res/dropbomb.wav"));
			AudioPlayer.player.start(DROPBOMB);
		} catch (Exception e) { }
	}
	
	public static void playDeath(){
		try{
			DEATH = new AudioStream(new FileInputStream("res/death.wav"));
			AudioPlayer.player.start(DEATH);
		} catch (Exception e) { }
	}
	
	public static void playSelect(){
		try{
			SELECT = new AudioStream(new FileInputStream("res/select.wav"));
			AudioPlayer.player.start(SELECT);
		} catch (Exception e) { }
	}
}
