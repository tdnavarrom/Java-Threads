
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
	private List<float[]> data = new ArrayList<>();
	private int contador = 0;

	public Reader(String filename) {
		this.filename = filename;
	}

	public int countNumLines() {
		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				this.contador++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.contador;
	}

	public synchronized void readFile(int start, int end) {

		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
			String line;
			String[] values;
			float[] floatData;
			
			for (int i = 0; i < end; i++) {
				line = br.readLine();
				if (i >= start && i < end && line != null) {
					values = line.split(";");
					floatData = new float[values.length];
					for(int j =0; j < values.length; j++ ){
						floatData[j] = Float.parseFloat(values[j]);
					}

					this.data.add(floatData);
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
			String line;
			float[] floatData;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				floatData = new float[values.length];
				for(int j =0; j < values.length; j++ ){
					floatData[j] = Float.parseFloat(values[j]);
				}

				this.data.add(floatData);
				this.contador++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<float[]> getData() {
		return this.data;
	}

	public int getContador(){
		return this.contador;
	}
}