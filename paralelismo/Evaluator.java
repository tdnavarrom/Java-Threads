package paralelismo;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	
	List<List<Float>> mat = new ArrayList<>();
	List<List<Float>> resultMax = new ArrayList<>();
	List<List<Float>> resultMin = new ArrayList<>();
	
	public Evaluator(List<List<Float>> mat) {
		this.mat = mat;
	}
	
	public void ComparatorPrecioApertura() {
		
		float maxPrecio = mat.get(0).get(2);
		float minPrecio = mat.get(0).get(2);
		
		int contMax = 0, idMax = 0, contMin = 0, idMin = 0;
		
		for(List<Float> list : this.mat) {
			if (list.get(2) > maxPrecio) {
				maxPrecio = list.get(2);
				idMax = contMax;
			}else if(list.get(2) < minPrecio) {
				minPrecio = list.get(2);
				idMin = contMin;
			}
			contMax++;
			contMin++;
		}
		
		this.resultMax.add(mat.get(idMax));
		this.resultMin.add(mat.get(idMin));
	}
	
	public void ComparatorPrecioMaximo() {
		
		float maxPrecio = mat.get(0).get(3);
		float minPrecio = mat.get(0).get(3);
		
		int contMax = 0, idMax = 0, contMin = 0, idMin = 0;
		
		for(List<Float> list : this.mat) {
			if (list.get(3) > maxPrecio) {
				maxPrecio = list.get(3);
				idMax = contMax;
			}else if(list.get(3) < minPrecio) {
				minPrecio = list.get(3);
				idMin = contMin;
			}
			contMax++;
			contMin++;
		}
		
		this.resultMax.add(mat.get(idMax));
		this.resultMin.add(mat.get(idMin));
	}
	
	public void ComparatorPrecioBajo() {
		
		float maxPrecio = mat.get(0).get(4);
		float minPrecio = mat.get(0).get(4);
		
		int contMax = 0, idMax = 0, contMin = 0, idMin = 0;
		
		for(List<Float> list : this.mat) {
			if (list.get(4) > maxPrecio) {
				maxPrecio = list.get(4);
				idMax = contMax;
			}else if(list.get(4) < minPrecio) {
				minPrecio = list.get(4);
				idMin = contMin;
			}
			contMax++;
			contMin++;
		}
		
		this.resultMax.add(mat.get(idMax));
		this.resultMin.add(mat.get(idMin));
	}
	
	public void ComparatorPrecioCierre() {
		
		float maxPrecio = mat.get(0).get(5);
		float minPrecio = mat.get(0).get(5);
		
		int contMax = 0, idMax = 0, contMin = 0, idMin = 0;
		
		for(List<Float> list : this.mat) {
			if (list.get(5) > maxPrecio) {
				maxPrecio = list.get(5);
				idMax = contMax;
			}else if(list.get(5) < minPrecio) {
				minPrecio = list.get(5);
				idMin = contMin;
			}
			contMax++;
			contMin++;
		}
		
		this.resultMax.add(mat.get(idMax));
		this.resultMin.add(mat.get(idMin));
	}
	
	public List<List<Float>> getMaxResults(){
		return this.resultMax;
	}
	
	public List<List<Float>> getMinResults(){
		return this.resultMin;
	}
	
}
