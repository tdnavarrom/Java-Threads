

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	List<List<Float>> mat = new ArrayList<>();
	List<List<Float>> resultMax = new ArrayList<>();
	List<List<Float>> resultMin = new ArrayList<>();

	public Evaluator(List<List<Float>> mat) {
		this.mat = mat;
	}

	public float[][] ComparatorPrecio() {

		float[][] result = new float[2][4];

		result[0][0] = mat.get(0).get(2); // max apertura
		result[1][0] = mat.get(0).get(2); // min apertura

		result[0][1] = mat.get(0).get(3); // max maximo
		result[1][1] = mat.get(0).get(3); // min maximo

		result[0][2] = mat.get(0).get(4); // max bajo
		result[1][2] = mat.get(0).get(4); // min bajo

		result[0][3] = mat.get(0).get(5); // max cierre
		result[1][3] = mat.get(0).get(5); // min cierre

		for (List<Float> list : this.mat) {

			if (list.get(2) > result[0][0]) {
				result[0][0] = list.get(2);
			} else if (list.get(2) < result[1][0]) {
				result[1][0] = list.get(2);
			}
			if (list.get(3) > result[0][1]) {
				result[0][1] = list.get(3);
			} else if (list.get(3) < result[1][1]) {
				result[1][1] = list.get(3);
			}
			if (list.get(4) > result[0][2]) {
				result[0][2] = list.get(4);
			} else if (list.get(4) < result[1][2]) {
				result[1][2] = list.get(4);
			}
			if (list.get(5) > result[0][3]) {
				result[0][3] = list.get(5);
			} else if (list.get(5) < result[1][3]) {
				result[1][3] = list.get(5);
			}
		}

		return result;

	}

	// public void ComparatorPrecioMaximo() {

	// float maxPrecio = mat.get(0).get(3);
	// float minPrecio = mat.get(0).get(3);

	// int contMax = 0, idMax = 0, contMin = 0, idMin = 0;

	// for(List<Float> list : this.mat) {
	// if (list.get(3) > maxPrecio) {
	// maxPrecio = list.get(3);
	// idMax = contMax;
	// }else if(list.get(3) < minPrecio) {
	// minPrecio = list.get(3);
	// idMin = contMin;
	// }
	// contMax++;
	// contMin++;
	// }

	// this.resultMax.add(mat.get(idMax));
	// this.resultMin.add(mat.get(idMin));
	// }

	// public void ComparatorPrecioBajo() {

	// float maxPrecio = mat.get(0).get(4);
	// float minPrecio = mat.get(0).get(4);

	// int contMax = 0, idMax = 0, contMin = 0, idMin = 0;

	// for(List<Float> list : this.mat) {
	// if (list.get(4) > maxPrecio) {
	// maxPrecio = list.get(4);
	// idMax = contMax;
	// }else if(list.get(4) < minPrecio) {
	// minPrecio = list.get(4);
	// idMin = contMin;
	// }
	// contMax++;
	// contMin++;
	// }

	// this.resultMax.add(mat.get(idMax));
	// this.resultMin.add(mat.get(idMin));
	// }

	// public void ComparatorPrecioCierre() {

	// float maxPrecio = mat.get(0).get(5);
	// float minPrecio = mat.get(0).get(5);

	// int contMax = 0, idMax = 0, contMin = 0, idMin = 0;

	// for(List<Float> list : this.mat) {
	// if (list.get(5) > maxPrecio) {
	// maxPrecio = list.get(5);
	// idMax = contMax;
	// }else if(list.get(5) < minPrecio) {
	// minPrecio = list.get(5);
	// idMin = contMin;
	// }
	// contMax++;
	// contMin++;
	// }

	// this.resultMax.add(mat.get(idMax));
	// this.resultMin.add(mat.get(idMin));
	// }

	// public List<List<Float>> getMaxResults(){
	// return this.resultMax;
	// }

	// public List<List<Float>> getMinResults(){
	// return this.resultMin;
	// }

}
