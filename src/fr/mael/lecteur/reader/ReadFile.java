package fr.mael.lecteur.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.mael.lecteur.file.AbstractFile;

public class ReadFile implements IReadFile {

	private AbstractFile file;
	private FileInputStream fileInputStream;

	public ReadFile(AbstractFile file) throws FileNotFoundException {
		this.file = file;
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
		return txt;
	}
	
	public void compareTo(ReadFile file) throws IOException {
		
	    BufferedReader reader1 = new BufferedReader(new FileReader(this.file.getFile()));       
	    BufferedReader reader2 = new BufferedReader(new FileReader(file.getFile().getFile()));
		
		List<String> line1 = new ArrayList<String>();        
        List<String> line2 = new ArrayList<String>();
        
        int lineNum = 0;
         
        while (line1 != null || line2 != null)
        {
        	String str1 = reader1.readLine();
        	String str2 = reader2.readLine();
        	
            line1.add(str1 == null ? "" : str1);        
            line2.add(str2 == null ? "" : str2);
                        
            if(str1 == null && str2 == null)
            {
                break;
            }
                          
            lineNum++;
        }
        
        boolean areEqual = true;
        
        for (int i = 0; i < Math.max(line1.size(), line2.size()); i++) {
        	String str1 = line1.get(i);
        	String str2 = line2.get(i);
        	if (!str1.equals(str2)) {
        		System.out.println(String.format("\u001B[31m %s : %s", i+1, str1));
        		System.out.println(String.format("\u001B[32m %s : %s", i+1, str2));
        		
        		areEqual = false;
        	}
        }
        
        if(areEqual)
        {
            System.out.println("Les 2 fichiers sont identiques.");
        }
       
        reader1.close();        
        reader2.close();
		
	}
	
	public AbstractFile getFile() {
		return this.file;
	}
	
}
