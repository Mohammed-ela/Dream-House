package engine.process;

import config.HouseConfig;

import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Meuble;

public class BoxBuilder {
	

	
	
	public static MobileElementManager buildInitMobile(Salon salon) {
		MobileElementManager manager = new MobileElementManager(salon);
		
		intializeDreamHouse(salon, manager);
		
		return manager;
	}

	private static void intializeDreamHouse(Salon salon, MobileElementManager manager) {
		Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
		Meuble meuble = new Meuble(block);
		manager.set(meuble);

}
}
