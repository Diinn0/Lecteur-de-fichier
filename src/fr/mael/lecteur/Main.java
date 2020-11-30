package fr.mael.lecteur;

import fr.mael.lecteur.file.FileTxt;
import fr.mael.lecteur.reader.ReadFile;

public class Main {
	
	public static void main(String[] args) {

		FileTxt txt = new FileTxt("test");
		txt.create();
		
		FileTxt txt2 = new FileTxt("test2");
		txt2.create();
		
		try {

			ReadFile read1 = new ReadFile(txt);
			ReadFile read2 = new ReadFile(txt2);
			
			read1.compareTo(read2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
