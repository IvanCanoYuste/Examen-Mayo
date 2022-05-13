package jcolonia.daw2021.mayo;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class VistaListado.
 */
public class VistaListado extends Vista{


	/**
	 * Instantiates a new vista listado.
	 *
	 * @param título the título
	 * @param sc the sc
	 */
	public VistaListado(String título,Scanner sc) {
		super(título, sc);
	}

	/**
	 * Muestra el contenido de listaNombres.
	 *
	 * @param imprimir array con las cosas que mostrar por pantalla.
	 */
	public void mostrarListado(ArrayList<String> imprimir) {

		for (int i = 0; i < imprimir.size(); i++) {
			out.printf("%s%n", imprimir.get(i).toString());
		}
		out.println();
	}
	

}
