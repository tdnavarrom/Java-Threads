import java.util.List;

public class Slave extends Thread{
	private int temp_cont, particiones;
	private Reader readFile;
	private Results results;
	
	public Slave(int temp_cont, int particiones, Reader readFile, Results results) {
		this.temp_cont = temp_cont;
		this.particiones = particiones;
		this.readFile = readFile;
		this.results = results;
	}
	
	public void run() {
		readFile.readFile(temp_cont * particiones, temp_cont + 1 * particiones); // begin , end of thread
		List<List<String>> dataString = readFile.getData();

		Converter converter = new Converter(dataString);
		converter.convertToFloat();
		List<List<Float>> data = converter.getList();

		Evaluator evaluator = new Evaluator(data);

		float[][] temp_precios = evaluator.ComparatorPrecio();
		
		for(int j = 0; j < 4; j++){
			results.updateMax(0, j, temp_precios[0][j]) ;
			results.updateMax(1, j, temp_precios[1][j]) ;
		}
	}
	
}
