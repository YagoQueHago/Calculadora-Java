package git;

import java.awt.*;

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


class LaminaCalculadora extends JPanel{//lamina donde estar� el display
	
	public LaminaCalculadora() {
		
		
		/** CREAMOS UNA LAMINA PARA EL DISPLAY **/ 
		
		setLayout(new BorderLayout());
		
		JButton pantalla=new JButton("0");//este ser� el display
		
		pantalla.setEnabled(false);//inabilitamos bot�n
		
		add(pantalla, BorderLayout.NORTH);
		
		
		/** CREAMOS LA SEGUNDA L�MINA PARA EL TECLADO **/
		
		milamina2=new JPanel(); //la iniciamos dentro del constructor, pero la declaramos fuera, para tener acceso a ella desde el m�todo
		
		milamina2.setLayout(new GridLayout(4,4));//lo ordena por filas (1,2,3,4...) no por columnas.
		
		
		/** NOTA 1:
		 * 
		 * 		Creamos un m�todo, fuera del constructor, que a�ade los botones.
		 * 
		 */
		
		ponerBoton("7");
		
		ponerBoton("8");
		
		ponerBoton("9");
		
		ponerBoton("/");
		
		ponerBoton("4");
		
		ponerBoton("5");
		
		ponerBoton("6");
		
		ponerBoton("*");
		
		ponerBoton("1");
		
		ponerBoton("2");
		
		ponerBoton("3");
		
		ponerBoton("-");
		
		ponerBoton("0");
		
		ponerBoton(".");
		
		ponerBoton("-");
		
		ponerBoton("+");
		
		
		/** NOTA 2:
		 * 
  		 * 		A�adimos la l�mina "2" (de tipo grill) en la zona centro (tipo border)
		 * 
		 */

		
		add(milamina2, BorderLayout.CENTER);
		
	}
	
	private void ponerBoton(String caracter) {
		
		JButton boton=new JButton(caracter);
		
		milamina2.add(boton);
	}
	
	private JPanel milamina2; // (declarada fuera del constructor, iniciada en el constructor)
		
	
}//CIERRE CLASE L�MINA





