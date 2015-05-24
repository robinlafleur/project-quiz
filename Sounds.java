package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.net.URL;

/**
 * Klassen är till för uppspelning av de ljud som 
 * finns i programmet
 */
public class Sounds extends Thread{
	private AudioClip clip = null;
	
	/**
	 * Konstruktorn tar emot en stäng som sökväg till
	 * en vald fil
	 */
	public Sounds(String path){
		createSound(path);
	}
	
	/**
	 * Metoden skapar ett ljudklipp av sökvägen till 
	 * en vald ljudfil
	 */
	public void createSound(String path){
		try{
			clip = Applet.newAudioClip(new URL(getClass().getResource("/main/Sounds/") + path));
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Metoden startar ljudklippet
	 */
	public void startSound(){
		clip.play();
	}
	
	/**
	 * Metoden stoppar ljudklippet
	 */
	public void stopSound(){
		clip.stop();
	}
	
	/**
	 * Metoden loopar ljudklippet
	 */
	public void loopSound(){
		clip.loop();
	}
}
