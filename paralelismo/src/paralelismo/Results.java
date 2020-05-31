package paralelismo;

import java.util.ArrayList;

public class Results {
	float[][] results = new float[2][4];

	public synchronized void updateMax(int row, int col, float value) {
		this.results[row][col] = value;
	}

	public float[][] getResults() {
		return results;
	}

}
