package gui.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

	import javax.swing.JPanel;

	import config.HouseConfig;
	import engine.map.Case;
	import engine.map.Salon;
	import engine.mobile.Wall;
	import engine.mobile.Meuble;
	
	import engine.process.MobileElementManager;
	
	

public class MapDisplay extends JPanel{
	
	

	

		private static final long serialVersionUID = 1L;
		
	
		private Salon salon;
		private MobileElementManager manager;
		private Paint paint = new Paint();

		public MapDisplay(Salon salon, MobileElementManager manager) {
			this.salon = salon;
			this.manager = manager;
		}
		
		
		

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			

			paint.paint(salon, g);
		
			Meuble meuble = manager.getMeuble();
			
			List<Meuble> meubleZone = manager.getMeubleZone();
			

		
		Wall wall = manager.getWall();
				if (wall != null) {
					List<Case> wallZone = manager.getWallZone();
					paint.paint(wallZone, g);
			}
				paint.printMeuble(meuble, g2);
				paint.printMeubleZone(meubleZone, g2);
		}
		
		
		
		public Case getWallPosition(int x, int y) {
			int line = y / HouseConfig.CASE_SIZE;
			int column = x / HouseConfig.CASE_SIZE;
			return salon.getCase(line, column);
		}
		
		
		
	
		
		
	}


