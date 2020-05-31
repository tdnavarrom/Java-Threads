import java.util.List;
import java.util.ArrayList;


public class Master extends Thread {

    private Reader readfile;
    private Results results;
    private int num_hilos = 0;
    
    public Master(Reader readfile, Results results, int num_hilos) {
        this.readfile = readfile;
        this.results = results;
        this.num_hilos = num_hilos;
    }

    public void run(){

        readfile.readFile();
        int contador = readfile.getContador();
        int particiones = contador/num_hilos;
        int restantes = 0;
        
        List<List<Float>> data = readfile.getData();
        
        List<List<Float>> temp_data = data.subList(0,particiones);

        Minions minions = new Minions(results, temp_data);

        for (int i = 0; i < num_hilos; i++) {

            int temp_end_of_range = (i + 1) * particiones;
            
            if( i == num_hilos-1) restantes = contador % num_hilos;
            
            if(restantes != 0) {
    			temp_end_of_range = ((i + 1) * particiones) + restantes;
    			
    			//Sleep thread 32 to guarantee it is the last thread to join the main thread.
    			try {
    				Thread.currentThread().sleep(2500);  //Do not use 1600ms by testing, 1500 is the perfect value.
    			}
    			catch (Exception e) {
    				System.out.println(e);
    			}
    			
    		}
            
            temp_data = new ArrayList<>();
            int start = i * particiones;
            
            temp_data.addAll(data.subList(start,temp_end_of_range));
            
            
            minions = new Minions(results, temp_data);
            minions.start();
        
        }
        try {
			minions.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}