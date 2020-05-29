package paralelismo;

import java.util.List;

public class Main {

		public static void main(String[] args) {
			Rsults results = new Results();
			Reader readFile = new Reader("DAT_ASCII_EURUSD_M1_2017_2019.csv");
			int contador = readFile.getContador();
			int num_hilos = 20;
			int particiones =  contador/num_hilos;
			
			for(int i = 0; i < num_hilos; i++) {
				
				//0 ---- part 1 - part1+1 --- part2 
				
				readFile.readFile(i*particiones, i+1*particiones); //begin , end of thread
				List<List<String>>dataString = readFile.getData();
				
				Converter converter = new Converter(dataString);
				converter.convertToFloat();
				List<List<Float>>data = converter.getList();
				
				Evaluator evaluator = new Evaluator(data);
				evaluator.ComparatorPrecioApertura();
				evaluator.ComparatorPrecioMaximo();
				evaluator.ComparatorPrecioBajo();
				evaluator.ComparatorPrecioCierre();
				
				List<List<Float>> resultMax = evaluator.getMaxResults(); //  
				List<List<Float>> resultMin = evaluator.getMinResults(); //
				
				
				
			}
			
			
			
			
			
			
			
		}
}
