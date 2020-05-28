package paralelismo;

import java.util.List;

public class Main {

		public static void main(String[] args) {
			Reader readFile = new Reader("DAT_ASCII_EURUSD_M1_2017_2019.csv");
			readFile.readFile();
			List<List<String>>dataString = readFile.getData();
			
			Converter converter = new Converter(dataString);
			converter.convertToFloat();
			List<List<Float>>data = converter.getList();
			
			Evaluator evaluator = new Evaluator(data);
			evaluator.ComparatorPrecioApertura();
			evaluator.ComparatorPrecioMaximo();
			evaluator.ComparatorPrecioBajo();
			evaluator.ComparatorPrecioCierre();
			
			List<List<Float>> resultMax = evaluator.getMaxResults();
			List<List<Float>> resultMin = evaluator.getMinResults();
		}
}
