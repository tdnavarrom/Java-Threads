package paralelismo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void findMaxMins(int row, int col, float val) {
		
		if(row == 0) {
			System.out.print("Max ");
		}else {
			System.out.print("Min ");
		}
		
		if(col == 0) {
			System.out.println("Apertura: " + val);
		}else if(col == 1) {
			System.out.println("Maximo: " + val);
		}else if(col == 2) {
			System.out.println("Bajo: " + val);
		}else {
			System.out.println("Cierre: " + val);
		}
		
	}
	
	public static void printResult(float[][] result) {
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				findMaxMins(i,j,result[i][j]);
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		Results results = new Results();
		Reader readFile = new Reader("D:\\EAFIT\\CompOrg\\projects\\Final\\Paralelism\\DAT_ASCII_EURUSD_M1_2017_2019.csv");
		System.out.println("Press 1 to run secuencial, press 2 to run directly with threads, press 3 to run with master thread and slave threads: ");
		Scanner in = new Scanner(System.in); 
	    int option = in.nextInt(); 
	    
	    long ini = System.currentTimeMillis();
	    
	    if(option == 1) {
	    	
	    	readFile.readFile();
			
			List<List<String>> dataString = readFile.getData();

			Converter converter = new Converter(dataString);
			converter.convertToFloat();
			List<List<Float>> data = converter.getList();
			
			System.out.print(data.size());

			Evaluator evaluator = new Evaluator(data);

			float[][] temp_precios = evaluator.ComparatorPrecio();
			
			for(int j = 0; j < 4; j++){
				results.updateMax(0, j, temp_precios[0][j]) ;
				results.updateMax(1, j, temp_precios[1][j]) ;
			}
			ini = System.currentTimeMillis() - ini;
	    	
	    }
	    else if(option == 2) {
	    	int contador = readFile.countNumLines();
			int num_hilos = 20;
			int particiones = contador / num_hilos;
			int restantes = 0;
			
			Slave slave = new Slave(0, particiones, readFile, results, restantes);
			for (int i = 1; i < num_hilos; i++) {
				
				if(i == num_hilos-1) restantes = contador % num_hilos;
				
				slave = new Slave(i, particiones, readFile, results, restantes);
				slave.start();
			}
			slave.join();
			ini = System.currentTimeMillis() - ini;
	    }
	    else if(option == 3){
	    	System.out.println("Nothing jet");
	    }
		
		System.out.println("Time: " + ini);
		printResult(results.getResults());
	}
}
