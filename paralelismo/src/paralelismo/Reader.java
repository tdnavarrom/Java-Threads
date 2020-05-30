package paralelismo;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
	private String filename = null;
	private List<List<String>> data = new ArrayList<>();
	
	public Reader(String filename) {
		this.filename = filename;
	}
	
	public int countNumLines() {
		int cont = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	cont++;
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cont;
	}
	
	public void readFile(int start, int end) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
		    String line;
		    
		    for(int i = 0; i < end; i++) {
		    	line = br.readLine();
		    	if(i >= start && i < end && line != null){
		    			String[] values = line.split(";");
				        this.data.add(Arrays.asList(values));
		    	}
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split(";");
			    this.data.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<List<String>> getData() {
		return this.data;
	}
	
}
