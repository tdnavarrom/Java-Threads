

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	List<float[]> mat = new ArrayList<>();
	List<float[]> resultMax = new ArrayList<>();
	List<float[]> resultMin = new ArrayList<>();

	public Evaluator(List<float[]> mat) {
		this.mat = mat;
	}

	public float[][] ComparatorPrecio() {

		float[][] result = new float[2][4];

		result[0][0] = mat.get(0)[2]; // max apertura
		result[1][0] = mat.get(0)[2]; // min apertura

		result[0][1] = mat.get(0)[3]; // max maximo
		result[1][1] = mat.get(0)[3]; // min maximo

		result[0][2] = mat.get(0)[4]; // max bajo
		result[1][2] = mat.get(0)[4]; // min bajo

		result[0][3] = mat.get(0)[5]; // max cierre
		result[1][3] = mat.get(0)[5]; // min cierre

		for (float[] list : this.mat) {
			
			

			if (list[2] > result[0][0]) {
				result[0][0] = list[2];
			} else if (list[2] < result[1][0]) {
				result[1][0] = list[2];
			}
			if (list[3] > result[0][1]) {
				result[0][1] = list[3];
			} else if (list[3] < result[1][1]) {
				result[1][1] = list[3];
			}
			if (list[4] > result[0][2]) {
				result[0][2] = list[4];
			} else if (list[4] < result[1][2]) {
				result[1][2] = list[4];
			}
			if (list[5] > result[0][3]) {
				result[0][3] = list[5];
			} else if (list[5] < result[1][3]) {
				result[1][3] = list[5];
			}
		}

		return result;

	}

}
