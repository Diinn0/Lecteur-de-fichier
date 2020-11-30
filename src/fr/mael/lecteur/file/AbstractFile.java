package fr.mael.lecteur.file;

import java.io.File;
import java.io.IOException;

public abstract class AbstractFile {

	private File file;
	
	public AbstractFile(String fileStr) {
		File file = new File(fileStr);
		this.file = file;
	}
	
	
	public boolean create() {
		if (!file.exists()) {
			try {
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
		
	public String getName() {
		return file.getName();
	}
	
	public String getNameWithoutExtension() {
		return file.getName().replaceFirst("[.][^.]+$", "");
	}
	
	public String getNameReverse() {
		StringBuilder string = new StringBuilder();
		string.append(this.getNameWithoutExtension());	
		return string.reverse().toString();
	}
	
	public File getFile() {
		return this.file;
	}

}
