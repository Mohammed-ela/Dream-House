package engine.box;



import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import engine.mobile.Meuble;

public class PathExplorer {
	
	public ArrayList<Meuble> explorePath(String path, String ext) throws IOException {
	
	ArrayList<Meuble> filePaths = new ArrayList<Meuble>();
	File file = new File(path);
	 
	
	if (file.exists()) {  
		
		if (file.isFile()) {
			
			// Get the extension of the file
			int index = path.lastIndexOf(".");
			String extensionFile = path.substring(index+1).toLowerCase();
			
			
			
			if (extensionFile.equals(ext) )  {
				
				Meuble meuble = new Meuble(file.getPath());
				filePaths.add(meuble);					
			}
		} else {
			File[] directoryContent = file.listFiles();
			for (int i = 0; i < directoryContent.length; i++) {
				filePaths.addAll(this.explorePath(directoryContent[i].getPath(), ext));					
			}
		}
		
	}	
	
	return filePaths;
}
}