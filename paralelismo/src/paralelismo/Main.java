

import java.util.List;

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

	public static void main(String[] args) {
		Results results = new Results();
		Reader readFile = new Reader("C:\\Users\\tomas\\eclipse-workspace\\ProjectoFinal\\src\\DAT_ASCII_EURUSD_M1_2017_2019.csv");
		long ini = System.currentTimeMillis();
		int contador = readFile.getContador();
		int num_hilos = 20;
		int particiones = contador / num_hilos;
		

		for (int i = 0; i < num_hilos; i++) {
			
			Slave slave = new Slave(i, particiones, readFile, results);
			slave.start();
		}
		ini = System.currentTimeMillis() - ini;
		System.out.println("Time: " + ini);
		printResult(results.getResults());
		
	}
}