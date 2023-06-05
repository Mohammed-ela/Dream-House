package engine.mobile;

import engine.map.Case;

public class Meuble extends MobileElement{
		private String lien = "src/Images/lcc3002";  
		private String titre;
		private String nature;
		private String piece;
		private String style;
		private int apparence = 0 ;
		private int LongueurMeuble = 57;
		private int LargeurMeuble = 38;
		private int prix = 0;
		
		
		public Meuble(String link) {
			super();
			this.lien = link;
			this.titre = link.substring(13,19).toLowerCase();
			this.nature = link.substring(13,14).toLowerCase();
			this.piece = link.substring(14,15).toLowerCase();
			this.style = link.substring(15,16).toLowerCase();
			this.prix = Integer.valueOf(link.substring(16,19));
			this.apparence = Integer.valueOf(link.substring(19,20));
		/*	
			this.lien = link;
			this.titre = link.substring(13,19).toLowerCase();
			this.nature = link.substring(13,14).toLowerCase();
			this.piece = link.substring(14,15).toLowerCase();
			this.style = link.substring(15,16).toLowerCase();
			this.LongueurMeuble = Integer.valueOf(link.substring(16,19));
			this.LongueurMeuble = Integer.valueOf(link.substring(19,22));
			this.prix = Integer.valueOf(link.substring(22,25));
			this.apparence = Integer.valueOf(link.substring(25,28));
			*/
		}
		
		
		
		 
		
		
		public String getTitre() {
			return titre;
		}

		public String getImage() {
			return lien;
		}
		
		public String getStyle() {
			return style;
		}


		public String getNature() {
			return nature;
		}

		public String getPiece() {
			return piece;
		}

		public int getPrix() {
			return prix;
		}

		public Meuble(Case position) {
			super(position);
		}
		
	
		

		public int getApparence() {
			return apparence;
		}


		public void setApparence(int apparence) {
			this.apparence = apparence;
		}


		public int getLargeurMeuble() {
			return LargeurMeuble;
		}


		public void setLargeurMeuble(int largeurMeuble) {
			LargeurMeuble = largeurMeuble;
		}


		public int getLongueurMeuble() {
			return LongueurMeuble;
		}


		public void setLongueurMeuble(int longueurMeuble) {
			LongueurMeuble = longueurMeuble;
		}

		public void incrementApparence() {
			apparence++;
		}


		

		@Override
		public String toString() {
			return "Meuble [lien=" + lien + ", titre=" + titre + ", nature=" + nature + ", piece=" + piece + ", style="
					+ style + ", apparence=" + apparence + ", LargeurMeuble=" + LargeurMeuble + ", LongueurMeuble="
					+ LongueurMeuble + ", prix=" + prix + "]";
		}


		



	
		
}
