package jcolonia.daw2021.mayo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestión de números «decimales»: recogida y visualización de la suma.
 *
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @versión 2022.3.1
 */
public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * Título de la aplicación. Se mostrará como encabezado del menú principal.
	 */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estándar de la aplicación. Debe ser un objeto
	 * único a compartir con las diferentes vistas creadas.
	 */
	private Scanner entrada;

	/** The conjunto. */
	private ListaNúmeros conjunto;

	/** The menú principal. */
	private VistaMenúBásico menúPrincipal;
	

	/**
	 * Instantiates a new control sumatorio.
	 *
	 * @param in the in
	 */
	public ControlSumatorio(Scanner in) {
		this.entrada = in;
		conjunto = new ListaNúmeros();
	}

	/**
	 * Bucle principal.
	 *
	 * @throws SumatorioNumberException the sumatorio number exception
	 */
	private void buclePrincipal() throws SumatorioNumberException {
		int opciónElegida;
		boolean fin = false;

		menúPrincipal = new VistaMenúBásico(TÍTULO_MENÚ_PRINCIPAL, entrada, OPCIONES_MENÚ_PRINCIPAL);

		// Bucle general
		do {
			menúPrincipal.mostrarTítulo1();
			menúPrincipal.mostrarOpciones();
			opciónElegida = menúPrincipal.pedirOpción();
			switch (opciónElegida) {
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("¡¡¡A-D-I-O-S!!");
				break;
			case 1: //Opción 1: Entrada datos
				cargarSumando();
				break;
			case 2: // Opción 2: Mostrar sumandos
				mostrarSumandos();
				break;
			case 3: // Opción 3: Mostrar suma
				mostrarSuma();
				break;
			case 4: // Opción 4: Reset
				restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(opciónElegida);
				System.err.println("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}

	/**
	 * Cargar sumando.
	 *
	 * @throws SumatorioNumberException the sumatorio number exception
	 */
	private void cargarSumando() throws SumatorioNumberException {
		VistaAlta altas = new VistaAlta(TÍTULO_MENÚ_PRINCIPAL,menúPrincipal.getEntrada());
		
		conjunto.add(altas.cargarNúmeros());		
	}

	/**
	 * Mostrar sumandos.
	 */
	private void mostrarSumandos() {
		VistaListado listado = new VistaListado(TÍTULO_MENÚ_PRINCIPAL,menúPrincipal.getEntrada());
		
		listado.mostrarListado(conjunto.toListaString());
		
	}

	/**
	 * Mostrar suma.
	 */
	private void mostrarSuma() {
		
		Vista.mostrarTexto(conjunto.toString());
	}

	/**
	 * Restablecer.
	 */
	private void restablecer() {
		conjunto = new ListaNúmeros();
		
	}

	/**
	 * Ejecutar genérico.
	 *
	 * @param id the id
	 */
	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opción %d: «%s»", id, OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SumatorioNumberException the sumatorio number exception
	 */
	public static void main(String[] args) throws SumatorioNumberException {
		Scanner entrada = new Scanner(System.in);

		ControlSumatorio control = new ControlSumatorio(entrada);
		control.buclePrincipal();
		entrada.close();
	}
}
