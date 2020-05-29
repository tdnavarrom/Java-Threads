package paralelismo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
	private String fileneame = null;
	private List<List<String>> data = new ArrayList<>();
	private int contador = null;
	
	public Reader(String filename) {
		this.fileneame = filename;
		countLines();
	}
	
	public void countLines() {
		try (BufferedReader br = new BufferedReader(new FileReader(this.fileneame))) {
		    int cont = 0;
		    while ((line = br.readLine()) != null) {
		       cont++;
		    }
		    this.contador = cont;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void readFile(int start, int end) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.fileneame))) {
		    String line;
		    int cont = 0;
		    while ((line = br.readLine()) != null) {
		    	if(cont >= start && cont < end){
		    		String[] values = line.split(";");
			        this.data.add(Arrays.asList(values));
			        cont++;
		    	}
		        cont++;
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
	
	public int getContador() {
		return this.contador;
	}
	
}
