package fr.mael.lecteur.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import fr.mael.lecteur.file.AbstractFile;

public class ReadReverse implements IReadFile {

	private FileInputStream fileInputStream;

	
	public ReadReverse(AbstractFile file) throws FileNotFoundException {
		this.fileInputStream = new FileInputStream(file.getFile());
	}

	
	@Override
	public String show() {
		String txt = "";
		try {
			int content;
			while ((content = this.fileInputStream.read()) != -1) {
				txt += (char) content;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (this.fileInputStream != null)
				this.fileInputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
        StringBuilder input1 = new StringBuilder();
        
        // append a string into StringBuilder input1
        input1.append(txt);
		return input1.reverse().toString();
	}
	

}
