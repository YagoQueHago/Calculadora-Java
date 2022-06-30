/************ CALCULADORA (LAYOUTS) *****************************
 * 
 * PRIMER PASO:
 * crear marco y l�mina. 
 * crear Layout display y botones con dos l�minas
 * El display ir� en disposici�n "BorderLayout.NORTH"
 * El teclado ir� en una segunda l�mina en la zona CENTER en disposici�n "GridLayout"
 * Poner los botones y utilizar el mismo m�todo para ponerlos a la escucha
 * Omitir, de momento, los botones de operaciones y conseguir que los botones
 *  se pongan a continuaci�n el uno del otro
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
		
		 //pack(); //para darle un tama�o predeterminado (en vez de setBounds)
		
		LaminaCalculadora milamina=new LaminaCalculadora();
		
		add (milamina);
		
		
	}
	
}//CIERRE CLASE MARCO


class LaminaCalculadora extends JPanel { 
	
	public LaminaCalculadora() {
		
		
		/** CREAMOS UNA LAMINA PARA EL DISPLAY **/ 
		
		principio=true; // variable iniciada fuera del constructor (para eliminaci�n del 0 en el display)
		
		/** Instanciamos la disposici�n dentro de los argumentos del m�todo (forma abreviada) **/
		
		setLayout(new BorderLayout()); //"setLayout" establece o determina la disposici�n (m�todo de la clase "Container").
		
		display=new JButton("0"); //este ser� el display (variable iniciada en el constructor, declarada fuera tb) 
		
		display.setEnabled(false); //inhabilitamos bot�n para que no se pueda presionar
		
		add(display, BorderLayout.NORTH); // el segundo argumento es una constante de clase de tipo INT
		
		// ("add" pertenece a la clase "Container" ; JPanel y JFrame heredan de "Container").
		
		
		/** CREAMOS LA SEGUNDA L�MINA PARA EL TECLADO **/
		
		teclado=new JPanel(); //la iniciamos dentro del constructor, pero la declaramos fuera, para tener acceso a ella desde el m�todo que a�ade los botones y queda a la escucha.
		
		teclado.setLayout(new GridLayout(4,4)); //lo ordena por filas, no por columnas.
		
		// ("setLayout" pertenece a la clase "Container" ; JPanel y JFrame heredan de "Container").
		
		
		/** NOTA 1:
		 * 
		 * 	Creamos un m�todo, fuera del constructor, que a�ade los botones. (est� m�s abajo)
		 * 
		 *  Utilizaremos este mismo m�todo para poner los n�meros a la escucha y que se cree un 
		 *  
		 *  evento ActionEvent que se almacene en la variable "e" de dicho evento.
		 *  
		 *  (por eso debemos pasar dos par�metros al m�todo 'ponerBoton')
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
  		 * 		A�adimos la l�mina "teclado" (tipo grill) en la zona "CENTER" (tipo border)
		 * 
		 */

		
		add(teclado, BorderLayout.CENTER);
		
	}
	
	/** NOTA 3:
	 * 
	 * Utilizaremos este m�todo no solo para a�adir los botones sino 
	 * 
	 * que adem�s nos servir� para ponerlos a la escucha con 'ActionListener'
	 * 
	 */
	
	private void ponerBoton(String caracter, ActionListener oyente) {
		
		JButton boton=new JButton(caracter); // a�ade bot�n
		
		boton.addActionListener(oyente); // ponemos el bot�n a la escucha y desencadena el evento 'actionPerformed' cuando hacemos click. 
		
		teclado.add(boton);
	}
	
	/** NOTA 4
	 * 
	 * 1� PONER A LA ESCUCHA TODOS LOS BOTONES
	 * 
	 * 2� CAPTURAR EL TEXTO PARA QUE APAREZCA EN EL DISPLAY
	 *
	 */
	
	private class InsertaNumero implements ActionListener{ //interface, debe implementar m�todo 'actionPerformed'
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// 1� almacenamos aqu� el texto del bot�n pulsado.
			
			String entrada=e.getActionCommand(); 
			
			// IF para que no aparezca 0 por defecto en el display
			
			if (principio) {
				
				display.setText("");
				
				principio=false;
			}
			
			
			
			/** NOTA (m�todo)
			 * 
			 *  2� hacemos aparecer en el display el texto almacenado.(variable entrada)
			 *  y para que se vayan poniendo en linea todos los numeros utilizamos el m�todo 'getText' (lo que hay en el display) 
			 *  de lo contrario solo sale un n�mero en el display.
			 *  
			 */
			
			display.setText(display.getText() + entrada); 
			
		}
		
		
	}
	
	/** NOTA 5:
	 * 
	 * Variables declaradas, pero iniciadas en el constructor (se necesitan aqu� para acceso por fuera)
	 *  
	 */
	
	private JPanel teclado; 
		
	private JButton display; 
	
	private boolean principio; //variable para que no salga "0" al principio
	
	
}//CIERRE CLASE L�MINA





