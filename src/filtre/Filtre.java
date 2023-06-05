package filtre;



public class Filtre {
	
	private String[] nature ;

	
	
	public Filtre() {
		String[] nature = { "fauteuil" ,"Armoire", "table" , "chaise", "bureau","others" } ;
		this.nature = nature;
	}



	public String[] getNature() {
		return nature;
	}


	
}



