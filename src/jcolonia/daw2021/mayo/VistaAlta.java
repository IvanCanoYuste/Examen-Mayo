package jcolonia.daw2021.mayo;

import java.util.Scanner;
import static java.lang.System.out;

public class VistaAlta extends Vista{

	
	public VistaAlta(String título,Scanner sc) {
		super(título, sc);
	}
	
	public double cargarNúmeros() {
		
		String líneaTexto="";
		double numeroDecimal=0.0;
		boolean seguir=false;
	
		while(!seguir) {
			try {
				out.println("\nIntroduce el número: ");
				líneaTexto = getEntrada().nextLine();
				if(líneaTexto.equals("")){
					out.println("Campo vacío");
				}else {	
					numeroDecimal = Double.parseDouble(líneaTexto);
					seguir=true;
				}
			}catch(Exception ex) {
				System.err.printf("El valor «%s» no es válido%n", numeroDecimal);
			}
		}
		
		
	return numeroDecimal;
	}
}
