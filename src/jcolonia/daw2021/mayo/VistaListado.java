package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;

public class VistaListado {

	private Scanner sc;
	
	public VistaListado(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Muestra el contenido de listaNombres.
	 *
	 * @param imprimir array con las cosas que mostrar por pantalla.
	 */
	public void mostrarListado(String imprimir) {
		out.println(imprimir);
		}
}
