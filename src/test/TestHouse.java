package test;
import java.io.IOException;

import gui.acceuil.AcceuilGUI;
import gui.game.MainGUI;

public class TestHouse {

	
	
		public static void main(String[] args)  {

			AcceuilGUI gameMainGUI = new AcceuilGUI("MY DREAM HOUSE");

			Thread gameThread = new Thread(gameMainGUI);
			gameThread.start();

		}
	

}
