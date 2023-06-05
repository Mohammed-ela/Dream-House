package engine.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import engine.box.PathExplorer;
import engine.mobile.Meuble;

public class BoxElementManager {
	private List<Meuble> toolBox = new ArrayList<Meuble>();


public BoxElementManager()  {	// Explore the images files from a path
	

}

public void createToolBox() throws IOException   {
		PathExplorer toolbox = new PathExplorer();
		this.toolBox = toolbox.explorePath(".\\src\\Images","png");
	}
public Meuble chooseMeuble(int i)  {
	Meuble meuble = toolBox.get(i); 
	
	return meuble;
	
	 
}


public ArrayList<Meuble> FiltreNature(String nature) {
	
	int i;	
	
		
	if (nature == "f") {  
		
		 ArrayList<Meuble> toolBox1 = new ArrayList<Meuble>();
		for(i = 0; i < toolBox.size(); i++) {
			if(toolBox.get(i).getNature()==nature) {
				toolBox1.add(toolBox.get(i));
				
			}
			
			}
		return  toolBox1;
	}
		if (nature == "a") {  
			
			 ArrayList<Meuble> toolBox2 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getNature()==nature) {
					toolBox2.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox2;
		}

		
		if (nature == "t") {  
			
			 ArrayList<Meuble> toolBox3 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				
				if(toolBox.get(i).getNature()==nature) {
					toolBox3.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox3;
		}
				 

		if (nature == "c") {  
			
			 ArrayList<Meuble> toolBox4 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getNature()==nature) {
					toolBox4.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox4;
		}
				
		if (nature == "b") {  
			
			 ArrayList<Meuble> toolBox5 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getNature()==nature) {
					toolBox5.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox5;
		}
		
		
		
		if (nature == "o") {  
			
			 ArrayList<Meuble> toolBox6 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getNature()==nature) {
					toolBox6.add(toolBox.get(i));
					
				}
				
				}
			return  toolBox6;
		}
		else {
			return null;
		}
}

public ArrayList<Meuble> FiltrePiece(String piece) {
	
	int i;	
	
		
	if (piece == "s") {  
		
		 ArrayList<Meuble> toolBox7 = new ArrayList<Meuble>();
		for(i = 0; i < toolBox.size(); i++) {
			if(toolBox.get(i).getPiece()== piece) {
				toolBox7.add(toolBox.get(i));
				
			}
			
			}
		return  toolBox7;
	}
		if (piece == "c") {  
			
			 ArrayList<Meuble> toolBox8 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getPiece()==piece) {
					toolBox8.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox8;
		}

		
		if (piece == "k") {  
			
			 ArrayList<Meuble> toolBox9 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				
				if(toolBox.get(i).getPiece()==piece) {
					toolBox9.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox9;
		}
				 

		if (piece == "t") {  
			
			 ArrayList<Meuble> toolBox10 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getPiece()==piece) {
					toolBox10.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox10;
		}
				
		if (piece == "o") {  
			
			 ArrayList<Meuble> toolBox11 = new ArrayList<Meuble>();
			for(i = 0; i < toolBox.size(); i++) {
				if(toolBox.get(i).getPiece()==piece) {
					toolBox11.add(toolBox.get(i));
				}
				
				
			}
			return  toolBox11;
		}
		else {
			return null;
		} 
		
}
		public ArrayList<Meuble> FiltreStyle(String style) {
			
			int i;	
			
				
			if (style == "a") {  
				
				 ArrayList<Meuble> toolBox12 = new ArrayList<Meuble>();
				 
				for(i = 0; i < toolBox.size(); i++) {
					if(toolBox.get(i).getStyle()==style) {
						toolBox12.add(toolBox.get(i));
						
					}
					
					}
				return  toolBox12;
			}
				if (style == "c") {  
					
					 ArrayList<Meuble> toolBox13 = new ArrayList<Meuble>();
					for(i = 0; i < toolBox.size(); i++) {
						if(toolBox.get(i).getStyle()==style) {
							toolBox13.add(toolBox.get(i));
						}
						
						
					}
					return  toolBox13;
				}

				
				if (style == "m") {  
					
					 ArrayList<Meuble> toolBox14 = new ArrayList<Meuble>();
					for(i = 0; i < toolBox.size(); i++) {
						
						if(toolBox.get(i).getStyle()==style) {
							toolBox14.add(toolBox.get(i));
						}
						
						
					}
					return  toolBox14;
				}
						 

				if (style == "o") {  
					
					 ArrayList<Meuble> toolBox4 = new ArrayList<Meuble>();
					for(i = 0; i < toolBox.size(); i++) {
						if(toolBox.get(i).getStyle()==style) {
							toolBox4.add(toolBox.get(i));
						}
						
						
					}
					return  toolBox4;
				}
				else {
					return null;
				} 
				
				}
		

		
		
		

public List<Meuble> getToolBox() {
	return toolBox;
}


	 
 

public String[] getTitreToolBox(){
	String[] meubleList = new String[16];
	
	for(int i=0 ; i< 16 ; i++) {
		if(toolBox.get(i).getApparence() == 0 ) {
			meubleList[i]=toolBox.get(i).getTitre();
		}
		
	}
	
	return meubleList;
}





}




