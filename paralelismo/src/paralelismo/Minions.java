public class Minions extends Threads{
    
    private List<List<String>> data;
	private Results results;

	public Minions( Results results, List<List<String>> data) {
		this.results = results;
		this.data = data;
	}

	public void run() {

		// System.out.println(temp_cont * particiones);
		// System.out.println(temp_end_of_range);

		System.out.println("Thread " + Thread.currentThread().getId() + " is running");

		Converter converter = new Converter(data);
		converter.convertToFloat();
		List<List<Float>> data = converter.getList();

		Evaluator evaluator = new Evaluator(data);

		float[][] temp_precios = evaluator.ComparatorPrecio();

		for (int j = 0; j < 4; j++) {
			results.updateMax(0, j, temp_precios[0][j]);
			results.updateMax(1, j, temp_precios[1][j]);
		}
		System.out.println("Thread " + Thread.currentThread().getId() + " is finished");
	}
}