package jcolonia.daw2021.mayo;

import static java.lang.System.out;

import java.util.Scanner;

public class VistaMenúBásico extends Vista{
	
	private String [] OPCIONES_MENÚ_PRINCIPAL;
	
	public VistaMenúBásico(String TÍTULO_MENÚ_PRINCIPAL, Scanner entrada, String [] OPCIONES_MENÚ_PRINCIPAL) {
		super(TÍTULO_MENÚ_PRINCIPAL, entrada);
		this.OPCIONES_MENÚ_PRINCIPAL = OPCIONES_MENÚ_PRINCIPAL;
	}

	public void mostrarOpciones() {
		out.println("Elige una opción");
		out.println("----------------------------------------\n");
		for (int i = 0; i < OPCIONES_MENÚ_PRINCIPAL.length; i++) {
			out.printf("%d. %s%n",i+1, OPCIONES_MENÚ_PRINCIPAL[i]);
		}
		out.println("----------------------------------------\n");
	}
	
	public int pedirOpción() {
		String lineaTexto;
		int número = 0;

		boolean numEsCorrecto = false;

		out.println("Introduce la opcion del menu elegida.\n");
		while (!numEsCorrecto) {
			try {
				lineaTexto = getEntrada().nextLine();
				número = Integer.parseInt(lineaTexto);
				if (número < 0 || número > OPCIONES_MENÚ_PRINCIPAL.length) {
					out.println("No ha elegido una opcion valida.\n");
					throw new NumberFormatException("Valor introducido fuera de rango de opciones.\n");
				} else {
					numEsCorrecto = true;
				}
			} catch (NumberFormatException ex) {
				out.printf("\tNo es una de las opciones validas: �%s�%n", ex.getMessage());
			}
		}

		return número;
	}
	
}
