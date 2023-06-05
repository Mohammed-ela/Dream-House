package engine.map;

import config.HouseConfig;

public class Case {
	
		private int ligne ;
		private int colone  ;

		public Case(int ligne, int colone) {
			this.ligne = ligne;
			this.colone = colone;
		}

		public int getLigne() {
			return ligne;
		}

		public int getColone() {
			return colone;
		}

		@Override
		public String toString() {
			return "Case [ligne =" + ligne + ", colone =" + colone + "]";
		}

}
