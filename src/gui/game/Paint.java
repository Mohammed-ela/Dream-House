package gui.game;

import java.awt.BasicStroke;
import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import config.HouseConfig;

import engine.map.Case;
	import engine.map.Salon;
	import engine.mobile.Wall;
import engine.process.BoxElementManager;
import engine.process.SimulationUtility;
import engine.mobile.Meuble;
	import engine.mobile.MobileElement;


public class Paint {
	
	
	
		public void paint(Salon salon, Graphics graphics) {
			int blockSize = HouseConfig.CASE_SIZE;
			Case[][] blocks = salon.getCases();

			for (int lineIndex = 0; lineIndex < salon.getLigneMax(); lineIndex++) {
				for (int columnIndex = 0; columnIndex < salon.getColoneMax(); columnIndex++) {
					Case block = blocks[lineIndex][columnIndex];

					
				}
			}
		}
		
		

	
		
		public void paint(List<Case> wallZone, Graphics graphics) {
			for (Case block : wallZone) {

				int blockSize = HouseConfig.CASE_SIZE;

				int y = block.getLigne();
				int x = block.getColone();

				graphics.setColor(Color.BLACK);
				graphics.fillRect((x * blockSize), y * blockSize, blockSize, blockSize);
			}

		}
		public void printMeuble( Meuble meuble, Graphics2D g2) {
			Case position = meuble.getPosition();
			int blockSize = HouseConfig.CASE_SIZE;

			int y = position.getLigne();
			int x = position.getColone();
			
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(6));

			
			g2.drawImage(SimulationUtility.readImage("src/Images/"+meuble.getTitre()+meuble.getApparence()+".png"),x * blockSize , y * blockSize  , meuble.getLargeurMeuble(), meuble.getLongueurMeuble(), null);
			
		}
		public void printMeubleZone( List<Meuble> meubleZone  , Graphics2D g2) {
			for(int i = 0 ; i < meubleZone.size() ; i ++) {
				
				
			Case position = meubleZone.get(i).getPosition();
			int blockSize = HouseConfig.CASE_SIZE;

			int y = position.getLigne();
			int x = position.getColone();
			
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(6));

			
			g2.drawImage(SimulationUtility.readImage("src/Images/"+ meubleZone.get(i).getTitre()+ meubleZone.get(i).getApparence()+".png"),x * blockSize , y * blockSize  ,  meubleZone.get(i).getLargeurMeuble(),  meubleZone.get(i).getLongueurMeuble(), null);
			}
		}
		public void printMeubleBis( Graphics2D g2) throws IOException {
			

			BoxElementManager manager = new BoxElementManager();
			manager.createToolBox();
			
			
			int posX = HouseConfig.WINDOW_WIDTH_BOX/5 ;
			int posY = (HouseConfig.WINDOW_HEIGHT_BOX +1200)/5 ; 
			
			for(int i = 0 ; i < manager.getToolBox().size(); i ++) {
				
				//manager.getToolBox().size() 
			if (manager.getToolBox().get(i).getApparence() == 0) {
			g2.drawImage(SimulationUtility.readImage("src/Images/"+manager.getToolBox().get(i).getTitre()+manager.getToolBox().get(i).getApparence()+".png"),posX,posY,manager.getToolBox().get(i).getLargeurMeuble(), manager.getToolBox().get(i).getLongueurMeuble(), null);
			
			
			
			if (posX < HouseConfig.WINDOW_WIDTH_BOX - 50) {
				posX += HouseConfig.WINDOW_WIDTH_BOX/5 +20 ;
				}
				else {
					posX = HouseConfig.WINDOW_WIDTH_BOX/5 ;
					posY += 100 ;
				}
			 
			}
		}
		
	}
		
		}
