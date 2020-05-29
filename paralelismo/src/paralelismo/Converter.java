package paralelismo;

import java.util.ArrayList;
import java.util.List;

public class Converter {
	List<List<String>> data = new ArrayList<>();
	List<List<Float>> mat = new ArrayList<>();
	
	public Converter(List<List<String>> data) {
		this.data = data;
	}
	
	public void convertToFloat(){

        int cont = 0;
        for(int i = 0; i < data.size(); i++) {
        	
            List<Float> pos = new ArrayList<>();


            pos.add(Float.parseFloat(data.get(i).get(0))); //fecha
            pos.add(Float.parseFloat(data.get(i).get(1))); //hora
            pos.add(Float.parseFloat(data.get(i).get(2))); //precio_apertura
            pos.add(Float.parseFloat(data.get(i).get(3))); //precio_mas_alto
            pos.add(Float.parseFloat(data.get(i).get(4))); //precio_mas_bajo
            pos.add(Float.parseFloat(data.get(i).get(5))); //precio_cierre
            pos.add(Float.parseFloat(data.get(i).get(6))); //valor 0
            
            mat.add(pos);

        }
    }

    public List<List<Float>> getList(){
        return mat;
    }
	
}
