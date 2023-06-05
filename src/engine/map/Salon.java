package engine.map;


public class Salon {
	private Case[][] Cases;

	private int ligneMax;
	private int coloneMax;

	public Salon(int ligneMax, int coloneMax) {
		this.ligneMax = ligneMax;
		this.coloneMax = coloneMax;

		Cases = new Case[ligneMax][coloneMax];

		for (int ligneIndex = 0; ligneIndex < ligneMax; ligneIndex++) {
			for (int coloneIndex = 0; coloneIndex < coloneMax; coloneIndex++) {
				Cases[ligneIndex][coloneIndex] = new Case(ligneIndex, coloneIndex);
			}
		}
	}

	public Case[][] getCases() {
		return Cases;
	}

	public int getLigneMax() {
		return ligneMax;
	}

	public int getColoneMax() {
		return coloneMax;
	}

	public Case getCase(int ligne, int column) {
		return Cases[ligne][column];
	}

	public boolean isOnTop(Case Case) {
		int ligne = Case.getLigne();
		return ligne == 0;
	}

	public boolean isOnBottom(Case Case) {
		int ligne = Case.getLigne();
		return ligne == ligneMax - 1;
	}

	public boolean isOnLeftBorder(Case Case) {
		int column = Case.getColone();
		return column == 0;
	}

	public boolean isOnRightBorder(Case Case) {
		int column = Case.getColone();
		return column == coloneMax - 1;
	}

	public boolean isOnBorder(Case Case) {
		return isOnTop(Case) || isOnBottom(Case) || isOnLeftBorder(Case) || isOnRightBorder(Case);
	}

}
