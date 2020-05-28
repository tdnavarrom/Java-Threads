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
	private String fileneame = "";
	private List<List<String>> data = new ArrayList<>();
	
	public Reader(String filename) {
		this.fileneame = filename;
	}
	

	public void readFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(this.fileneame))) {
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
