/************ CALCULADORA (LAYOUTS) *****************************
 * 
 * PRIMER PASO:
 * crear marco y lámina. 
 * crear Layout display y botones con dos láminas
 * El display irá en disposición "BorderLayout.NORTH"
 * El teclado irá en una segunda lámina en la zona CENTER en disposición "GridLayout"
 * Poner los botones y utilizar el mismo método para ponerlos a la escucha
 * Omitir, de momento, los botones de operaciones y conseguir que los botones
 *  se pongan a continuación el uno del otro
 * 
 ***************************************************************/  

package git;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		
		MarcoCalculadora mimarco=new MarcoCalculadora();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}


class MarcoCalculadora extends JFrame{
	
	public MarcoCalculadora() {
		
		setTitle ("Calculadora");
		
		setBounds(500,300,450,300);
		
		 //pack(); //para darle un tamaño predeterminado (en vez de setBounds)
		
		LaminaCalculadora milamina=new LaminaCalculadora();
		
		add (milamina);
		
		
	}
	
}//CIERRE CLASE MARCO


class LaminaCalculadora extends JPanel { 
	
	public LaminaCalculadora() {
		
		
		/** CREAMOS UNA LAMINA PARA EL DISPLAY **/ 
		
		principio=true; // variable iniciada fuera del constructor (para eliminación del 0 en el display)
		
		/** Instanciamos la disposición dentro de los argumentos del método (forma abreviada) **/
		
		setLayout(new BorderLayout()); //"setLayout" establece o determina la disposición (método de la clase "Container").
		
		display=new JButton("0"); //este será el display (variable iniciada en el constructor, declarada fuera tb) 
		
		display.setEnabled(false); //inhabilitamos botón para que no se pueda presionar
		
		add(display, BorderLayout.NORTH); // el segundo argumento es una constante de clase de tipo INT
		
		// ("add" pertenece a la clase "Container" ; JPanel y JFrame heredan de "Container").
		
		
		/** CREAMOS LA SEGUNDA LÁMINA PARA EL TECLADO **/
		
		teclado=new JPanel(); //la iniciamos dentro del constructor, pero la declaramos fuera, para tener acceso a ella desde el método que añade los botones y queda a la escucha.
		
		teclado.setLayout(new GridLayout(4,4)); //lo ordena por filas, no por columnas.
		
		// ("setLayout" pertenece a la clase "Container" ; JPanel y JFrame heredan de "Container").
		
		
		/** NOTA 1:
		 * 
		 * 	Creamos un método, fuera del constructor, que añade los botones. (está más abajo)
		 * 
		 *  Utilizaremos este mismo método para poner los números a la escucha y que se cree un 
		 *  
		 *  evento ActionEvent que se almacene en la variable "e" de dicho evento.
		 *  
		 *  (por eso debemos pasar dos parámetros al método 'ponerBoton')
		 * 
		 */
		
		ActionListener insertar=new InsertaNumero();
		
		ponerBoton("7", insertar);
		
		ponerBoton("8", insertar);
		
		ponerBoton("9", insertar);
		
		ponerBoton("/", null);
		
		ponerBoton("4", insertar);
		
		ponerBoton("5", insertar);
		
		ponerBoton("6", insertar);
		
		ponerBoton("*", null);
		
		ponerBoton("1", insertar);
		
		ponerBoton("2", insertar);
		
		ponerBoton("3", insertar);
		
		ponerBoton("-", null);
		
		ponerBoton("0", insertar);
		
		ponerBoton(".", insertar);
		
		ponerBoton("=", null);
		
		ponerBoton("+", null);
		
		
		/** NOTA 2:
		 * 
  		 * 		Añadimos la lámina "teclado" (tipo grill) en la zona "CENTER" (tipo border)
		 * 
		 */

		
		add(teclado, BorderLayout.CENTER);
		
	}
	
	/** NOTA 3:
	 * 
	 * Utilizaremos este método no solo para añadir los botones sino 
	 * 
	 * que además nos servirá para ponerlos a la escucha con 'ActionListener'
	 * 
	 */
	
	private void ponerBoton(String caracter, ActionListener oyente) {
		
		JButton boton=new JButton(caracter); // añade botón
		
		boton.addActionListener(oyente); // ponemos el botón a la escucha y desencadena el evento 'actionPerformed' cuando hacemos click. 
		
		teclado.add(boton);
	}
	
	/** NOTA 4
	 * 
	 * 1º PONER A LA ESCUCHA TODOS LOS BOTONES
	 * 
	 * 2º CAPTURAR EL TEXTO PARA QUE APAREZCA EN EL DISPLAY
	 *
	 */
	
	private class InsertaNumero implements ActionListener{ //interface, debe implementar método 'actionPerformed'
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// 1º almacenamos aquí el texto del botón pulsado.
			
			String entrada=e.getActionCommand(); 
			
			// IF para que no aparezca 0 por defecto en el display
			
			if (principio) {
				
				display.setText("");
				
				principio=false;
			}
			
			
			
			/** NOTA (método)
			 * 
			 *  2º hacemos aparecer en el display el texto almacenado.(variable entrada)
			 *  y para que se vayan poniendo en linea todos los numeros utilizamos el método 'getText' (lo que hay en el display) 
			 *  de lo contrario solo sale un número en el display.
			 *  
			 */
			
			display.setText(display.getText() + entrada); 
			
		}
		
		
	}
	
	/** NOTA 5:
	 * 
	 * Variables declaradas, pero iniciadas en el constructor (se necesitan aquí para acceso por fuera)
	 *  
	 */
	
	private JPanel teclado; 
		
	private JButton display; 
	
	private boolean principio; //variable para que no salga "0" al principio
	
	
}//CIERRE CLASE LÁMINA





