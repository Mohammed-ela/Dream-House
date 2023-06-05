package gui.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

import config.HouseConfig;

import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Meuble;
import engine.mobile.Wall;
import engine.process.BoxElementManager;
import engine.process.MobileElementManager;

public class BoxDisplay extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private BoxElementManager manager;
	private Paint paint = new Paint();

	public BoxDisplay( BoxElementManager manager) {
		
	
		this.manager = manager;
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
			
		

		
		
		try {
		
			paint.printMeubleBis(g2);
		
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	
}
