package jcolonia.daw2021.mayo;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class VistaAlta {

	private Scanner sc;
	
	private VistaMenúBásico menúPrincipal;
	private ListaNúmeros conjunto;
	
	public VistaAlta(Scanner sc) {
		this.sc = sc;
		conjunto = new ListaNúmeros();
		menúPrincipal = new VistaMenúBásico(null, sc, null);
	}
	
	public double cargarVotos() {
		
		String líneaTexto="";
		double numeroDecimal=0.0;
		boolean seguir=false;
	
		while(!seguir) {
			try {
				out.println("\nIntroduce el número: ");
				líneaTexto = menúPrincipal.getEntrada().nextLine();
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
