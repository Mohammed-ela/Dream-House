package engine.process;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Wall;
import engine.mobile.Meuble;

 public class MobileElementManager {
	private Salon salon;
	private Wall wall = null;
	private Meuble meuble ;
	private List<Meuble> meubleZone = new ArrayList<Meuble>();
	private List<Case> wallZone = new ArrayList<Case>();


	
	public MobileElementManager(Salon salon) {
		this.salon = salon;
	}
	
	public MobileElementManager(Salon salon, int i)  {
		this.salon = salon;
		BoxElementManager toolBox = new BoxElementManager();
		try {
			toolBox.createToolBox();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.meuble = toolBox.chooseMeuble(i); 
		System.out.println(meuble);
	

	}
	
	public void set(Meuble meuble) {
		this.meuble = meuble ;
	}
   
	
    
	
	public void putWall(Case position) {
		

			
				 wall = new Wall(position);
				 int line = position.getLigne();
				int column = position.getColone();
				 wallZone.add(salon.getCase(line, column));
				
				
	}
	public void deleteWall(Case position) {
			
		
			int line = position.getLigne();
			int column = position.getColone();
			 wallZone.remove(salon.getCase(line, column));
		
	}
	public void moveLeftMeuble() {
		Case position = meuble.getPosition();

		if (position.getColone() > 0) {
			Case newPosition = salon.getCase(position.getLigne(), position.getColone() - 1);
			meuble.setPosition(newPosition);
		}

	}

	public void moveRightMeuble() {
		Case position = meuble.getPosition();

		if (position.getColone() < HouseConfig.COLUMN_COUNT - 1) {
			Case newPosition = salon.getCase(position.getLigne(), position.getColone() + 1);
			meuble.setPosition(newPosition);
		}
	}
	
	public void moveTopMeuble() {
		Case position = meuble.getPosition();

		if (position.getLigne() > 0) {
			Case newPosition = salon.getCase(position.getLigne() -1 , position.getColone() );
			meuble.setPosition(newPosition);
		}
	}
	
	public void moveBotMeuble() {
		Case position = meuble.getPosition();

		if (position.getLigne() < HouseConfig.LIGNE_COUNT - 1) {
			Case newPosition = salon.getCase(position.getLigne() +1 , position.getColone() );
			meuble.setPosition(newPosition);
		}
	}
	
	public Wall getWall() {
			return wall;
			
	}
	public List<Case> getWallZone() {
		return wallZone;
	}
	public Meuble getMeuble() {
		return meuble;
	}
	public void pivoter() {
		int z ;
		z=meuble.getLongueurMeuble();
		meuble.setLongueurMeuble(meuble.getLargeurMeuble());
		meuble.setLargeurMeuble(z);
		if (meuble.getApparence()<3 ) {
			meuble.incrementApparence();
		}
		else {
			meuble.setApparence(0);
		}
	}
	public void mainMeuble(int i) throws IOException{
		
		BoxElementManager toolBox = new BoxElementManager();
		toolBox.createToolBox();
		this.meuble = toolBox.chooseMeuble(i); 
	
		
	}
	
	
	public void setMeuble(Meuble meuble) {
		this.meuble = meuble;
	}
	
	public void putMeuble(Meuble meuble) {
		
		 meubleZone.add(meuble);
	
		
}
	public void deleteMeuble() {
		
		 meubleZone.remove(meubleZone.get(meubleZone.size()-1));
	
}
	

	public List<Meuble> getMeubleZone() {
		return meubleZone;
	}

	public void setMeulbeZone(List<Meuble> MeulbeZone) {
		
		meubleZone = MeulbeZone;
	}

	@Override
	public String toString() {
		return "MobileElementManager [wallZone=" + wallZone + "]";
	}



	
}
