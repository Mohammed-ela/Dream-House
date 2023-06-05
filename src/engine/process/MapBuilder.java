package engine.process;



import java.io.IOException;

import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Meuble;




public class MapBuilder {

	public static Salon buildSalon() {
		return new Salon(HouseConfig.LIGNE_COUNT, HouseConfig.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Salon salon, int i) {
		MobileElementManager manager = new MobileElementManager(salon);
		
		intializeDreamHouse(salon, manager, i);
		System.out.println(manager.toString());
		
		return manager;
	}

	private static void intializeDreamHouse(Salon salon, MobileElementManager manager, int i) {
		Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
		Meuble meuble = new Meuble(block);
		BoxElementManager toolBox = new BoxElementManager();
		try {
			toolBox.createToolBox();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meuble = toolBox.chooseMeuble(i); 
		manager.set(meuble);

}
}
