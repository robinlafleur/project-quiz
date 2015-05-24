package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Startar programmet Code Quiz.
 */
public class StartQuiz {
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(768,768));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setTitle("CodeQuiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new UI());
		frame.pack();
		frame.setResizable(false);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		new StartQuiz().run();
	}
}
