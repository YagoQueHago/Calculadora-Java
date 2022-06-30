/************ CALCULADORA (LAYOUTS) *****************************
 * 
 * SEGUNDA PARTE:
 * Insertar operadores aritméticos
 * 
 ***************************************************************/  

package git;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora2 {

	public static void main(String[] args) {
		
		MarcoCalculadora2 mimarco=new MarcoCalculadora2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}


class MarcoCalculadora2 extends JFrame{
	
	public MarcoCalculadora2() {
		
		setTitle ("Calculadora");
		
		setBounds(500,300,450,300);
		
		 //pack(); //para darle un tamaño predeterminado (en vez de setBounds)
		
		LaminaCalculadora2 milamina=new LaminaCalculadora2();
		
		add (milamina);
		
		
	}
	
}//CIERRE CLASE MARCO


class LaminaCalculadora2 extends JPanel{//lamina donde estará el display
	
	public LaminaCalculadora2() {
		
		
		/** CREAMOS UNA LAMINA PARA EL DISPLAY **/ 
		
		setLayout(new BorderLayout());
		
		pantalla=new JButton("0");//este será el display (iniciada en el constructor, declarada fuera) 
		
		pantalla.setEnabled(false);//inabilitamos botón
		
		add(pantalla, BorderLayout.NORTH);
		
		
		
		/** CREAMOS LA SEGUNDA LÁMINA PARA EL TECLADO **/
		
		milamina2=new JPanel(); //la iniciamos dentro del constructor, pero la declaramos fuera, para tener acceso a ella desde el método
		
		milamina2.setLayout(new GridLayout(4,4));//lo ordena por filas (1,2,3,4...) no por columnas.
		
		
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
		
		ActionListener insertar=new InsertaNumero2();
		
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
  		 * 		Añadimos la lámina "2" (de tipo grill) en la zona centro (tipo border)
		 * 
		 */

		
		add(milamina2, BorderLayout.CENTER);
		
	}
	
	/** NOTA 3:
	 * 
	 * Utilizaremos este método no solo para añadir los botones sino 
	 * que además nos servirá para ponerlos a la escucha con 'ActionListener'
	 * 
	 */
	
	private void ponerBoton(String caracter, ActionListener oyente) {
		
		JButton boton=new JButton(caracter); // añade botón
		
		boton.addActionListener(oyente); // ponemos el botón a la escucha y desencadena el evento 'actionPerformed' cuando hacemos click. 
		
		milamina2.add(boton);
	}
	
	
	/** NOTA 4
	 * 
	 * 1º PONER A LA ESCUCHA TODOS LOS BOTONES
	 * 
	 * 2º CAPTURAR EL TEXTO PARA QUE APAREZCA EN EL DISPLAY
	 *
	 */
	
	
	private class InsertaNumero2 implements ActionListener{ //interface, debe implementar método 'actionPerformed'
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String entrada=e.getActionCommand(); // 1º almacenamos aquí el texto del botón pulsado.
			
			
			/** NOTA (método)
			 * 
			 *  2º hacemos aparecer en el display el texto almacenado.(variable entrada)
			 *  y para que se vayan poniendo en linea todos los numeros utilizamos el método 'getText' (lo que hay en el display) 
			 *  de lo contrario solo sale un número en el display.
			 *  
			 */
			
			
			pantalla.setText(pantalla.getText() + entrada); 
			
		}
		
		
	}
	
	
	/** NOTA 5:
	 * 
	 * Variables iniciadas en el constructor, pero declaradas fuera para poder acceder a ellas
	 *  
	 */
	
	
	private JPanel milamina2; 
		
	private JButton pantalla; 
	
	
}//CIERRE CLASE LÁMINA





