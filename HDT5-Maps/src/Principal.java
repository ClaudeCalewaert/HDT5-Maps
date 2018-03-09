import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Principal {

	public static void main(String[] args) throws IOException  {
		
		
		MapFactory fabricaMap = new MapFactory();
		Map<String,ArrayList<String>> mapa = null;
		Scanner entradaUsuario = new Scanner(System.in);
		
		System.out.println("Bienvenido al programa de cartas \n");
		System.out.println("Por favor seleccione el tipo de implementacion: \n");
		System.out.println("1) HashMap\n2) TreeMap\n3) LinkedHashMap\n");
		
		int numero = 0;
		
		while (numero != 1 && numero != 2 && numero != 3) {
			if (entradaUsuario.hasNextLine()) {
				numero = entradaUsuario.nextInt();
				mapa = fabricaMap.crearMapa(numero);
				
				if (numero != 1 && numero != 2 && numero != 3) {
					System.out.println("Por favor ingrese un numero valido \n");
				}
			}
		}
		
		
		
		System.out.println("Por favor seleccione la accion a realizar: \n");
		System.out.println("1)Agregar carta a la coleccion");
		System.out.println("2)Indicar tipo de carta");
		System.out.println("3)Mostrar el nombre, tipo y cantidad de cada carta en la colección");
		System.out.println("4)Mostrar el nombre, tipo y cantidad de cada carta en la colección, ordenadas por tipo");
		System.out.println("5)Mostrar nombre y tipo de cartas de las cartas existentes en la coleccion");
		System.out.println("6)Mostrar nombre y tipo de cartas de las cartas existentes en la coleccion, ordenadas por tipo");
		
		
		numero = entradaUsuario.nextInt();
		
		//----------------------------------------------- OPCION NO 1 -------------------------------------------------------//
		
		if (numero == 1) {
			
			String archivo = "cards_desc.txt";
			
			String linea;
			BufferedReader reader = new BufferedReader(new FileReader(archivo));
			
			System.out.println("Por favor ingrese el nombre de la carta que desea agregar: \n");
			
			entradaUsuario.nextLine();
			
			String nombreCarta = entradaUsuario.nextLine();
			
			while ((linea = reader.readLine()) != null ) {
				String[] partes = linea.split("[|]",2);
				
				String llave = partes[1];
				String nombre = partes[0];
				
				System.out.println(nombre+ "@" + llave);
				
				if (nombre.equals(nombreCarta)) {
					if (mapa.containsKey(llave) == false) {
						ArrayList<String> lista = new ArrayList<>();
						lista.add(nombre);
						mapa.put(llave, lista);
					}
					
					else {
						ArrayList<String> lista = mapa.get(llave);
						lista.add(nombreCarta);
						mapa.put(llave, lista);
					}
					break;
				}
				
			}
		
			
			
			//prueba de map
			
			
			for (Entry<String, ArrayList<String>> ent: mapa.entrySet()) {
				ArrayList<String> list = ent.getValue();
				for (int i=0; i<list.size(); i++) {
				System.out.println("Tipo: " + ent.getKey() + " Nombre: " + list.get(i));
				}
			}
			
			
			//----------------------------------------------- OPCION NO 2 -------------------------------------------------------//
		}
	}


}
