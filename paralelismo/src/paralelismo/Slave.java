package paralelismo;

import java.util.List;

public class Slave extends Thread{
	private int temp_cont, particiones;
	private Reader readFile;
	private Results results;
	private int restantes;
	
	public Slave(int temp_cont, int particiones, Reader readFile, Results results, int restantes) {
		this.temp_cont = temp_cont;
		this.particiones = particiones;
		this.readFile = readFile;
		this.results = results;
		this.restantes = restantes;
	}
	
	public void run() {
		
		int temp_end_of_range = (temp_cont + 1) * particiones;
		
		if(restantes != 0) temp_end_of_range = ((temp_cont + 1) * particiones) + restantes;
		
		readFile.readFile(temp_cont * particiones, temp_end_of_range); // begin , end of thread
		
		//System.out.println(temp_cont * particiones);
		//System.out.println(temp_end_of_range);
		
		List<List<String>> dataString = readFile.getData();
		
		//System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 

		Converter converter = new Converter(dataString);
		converter.convertToFloat();
		List<List<Float>> data = converter.getList();

		Evaluator evaluator = new Evaluator(data);

		float[][] temp_precios = evaluator.ComparatorPrecio();
		
		for(int j = 0; j < 4; j++){
			results.updateMax(0, j, temp_precios[0][j]) ;
			results.updateMax(1, j, temp_precios[1][j]) ;
		}
		//System.out.println ("Thread " + Thread.currentThread().getId() + " is finished"); 
	}
	
}
