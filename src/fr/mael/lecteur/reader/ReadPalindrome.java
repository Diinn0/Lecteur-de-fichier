package fr.mael.lecteur.reader;

import java.io.FileNotFoundException;

import fr.mael.lecteur.file.AbstractFile;

public class ReadPalindrome implements IReadFile {

	private AbstractFile file;

	public ReadPalindrome(AbstractFile file) throws FileNotFoundException {
		this.file = file;
	}

	@Override
	public String show() {
		try {
			ReadFile readFile = new ReadFile(this.file);
			ReadReverse readReverse = new ReadReverse(this.file);
			
			return readFile.show() + readReverse.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
