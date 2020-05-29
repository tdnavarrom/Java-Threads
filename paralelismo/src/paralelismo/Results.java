import java.util.ArrayList;

public class Results {
	private List<List<Float>> resultsMax = new ArrayList<>();
	private List<List<Float>> resultsMin = new ArrayList<>();
	
	
	public synchronized void updateMax(List<Float> maxResultList) {
		this.resultsMax.add(maxResultList);
	}
	
	public synchronized void updateMin(List<Float> minResultList) {
		this.resultsMin.add(minResultList);
	}
	
	public void getMax() {
		return this.resultsMax;
	}
	
	public void getMin() {
		return this.resultsMin;
	}
	
}
