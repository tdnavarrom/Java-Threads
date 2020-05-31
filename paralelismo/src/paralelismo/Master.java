public class Master extends Thread {

    private ReadFile readfile;
    private Result results;
    private int contador = 0;
    private int num_hilos = 0;
    private int particiones = 0;
    private int restantes = 0;

    public Master(ReadFile readfile, Result results, int contador, int num_hilos, int particiones) {
        this.readfile = readfile;
        this.results = results;
        this.contador = contador;
        this.num_hilos = num_hilos;
        this.particiones = particiones;
    }

    public void run() {

        readFile.readFile();
        List<List<String>> dataString = readFile.getData();

        Minions minions = new Minions(i, particiones, results, restantes);

        for (int i = 1; i < num_hilos; i++) {

            System.out.println("NEGRO MK");
            int temp_end_of_range = (i + 1) * particiones;
            
            if (i == num_hilos - 1)
                restantes = contador % num_hilos;

            if (restantes != 0) temp_end_of_range = ((i + 1) * particiones) + restantes;

            List<List<String>> temp_data;

            for(int j = i*particiones; j < temp_end_of_range; ++j){
                temp_data.add(dataString.get(j));
            }


            minions = new Minions(temp_data, results);
            minions.start();
        
        }
        minions.join();

    }
}