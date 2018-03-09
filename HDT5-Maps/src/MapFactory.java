import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
	
	public Map<String, String> crearMapa(int numero) {
		
		Map<String,String> map = null;
		
		if (numero == 1) {
			return new HashMap<>();
		}
		
		else if (numero == 2) {
			return new TreeMap<>();
		}
		
		else if (numero == 3) {
			return new LinkedHashMap<>();
		}
		
		else {
			return null;
		}
		
	}
}
