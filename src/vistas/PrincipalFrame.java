package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladores.ControlMenuPrincipal;

@SuppressWarnings("serial")
public class PrincipalFrame extends JFrame implements ActionListener{ 
	 
	//PRINCIPAL
	   
    JButton bjugador, bjuego, bayuda;
    MenuJugador menu;
    ControlMenuPrincipal control;
    AdivinanzaJFrame adivina;
    String password, alias;
    
public PrincipalFrame(){
    
     setSize(new Dimension(300,300));
     setTitle("JUEGO DIDACTICO FAUNA DEL CONO MONETARIO");
     setLayout(null);     
     this.getContentPane().setBackground(Color.white);
     
    bjugador = new JButton("JUGADOR");
   	bjugador.setBounds(60,50,180,25);
   	
    bjuego = new JButton("JUEGO");
   	bjuego.setBounds(60,100,180,25);
   	
   	bayuda = new JButton("AYUDA");
   	bayuda.setBounds(60,150,180,25);
   	
    bjugador.addActionListener(this);
   	bjuego.addActionListener(this);
   	bayuda.addActionListener(this);
   	
    add(bjugador);
    add(bjuego); 
    add(bayuda);
    this.addWindowListener
    (
        new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                PrincipalFrame.this.windowClosed();
            }
        }
    );  
}

@Override
public void actionPerformed(ActionEvent ae) {
   //Principal
   if(ae.getSource().equals(bjugador)){     
	   menu.setVisible(true);
	   this.setVisible(false);
	   EstadoDeBotones(false);
	   
	}
   else if(ae.getSource().equals(bjuego)){   
	  
	   if(control.verificarJugadores())
		   verificarJugador();
	   else
		   mensaje("Primer Jugador a Ingresar por favor crea una cuenta");
    }
   
   else if(ae.getSource().equals(bayuda)){
	   casoAyuda();
   }
   
 }
	public void mensaje(String msj){
		JOptionPane.showMessageDialog(null, msj,
	               "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.ERROR_MESSAGE);
	}
	
	public void EstadoDeBotones(boolean x){
	       bjugador.setVisible(x);
	       bjuego.setVisible(x);
	       bayuda.setVisible(x);
	}

public void casoAyuda()
{
    JOptionPane.showMessageDialog(null, "Reglas\n" +
            "Para poder empezar primero tienes que pasar el juego preliminar.\n" +
            "Premios \n" +
            "1a Pregunta    1000 Puntos \n" +
            "2a Pregunta    1000 Puntos \n" +
            "3a Pregunta    1000 Puntos \n" +
            "4a Pregunta    1000 Puntos \n" +
            "5a Pregunta    1000 Puntos \n" +
            "6a Pregunta    1000 Puntos \n" +
            "7a Pregunta    1000 Puntos \n" +
            "8a Pregunta    1000 Puntos \n"+ "Por cada respuesta incorrecta se descontará 500 Puntos, y tendrás la posibilidad de realizar 2 intentos en cada pregunta \n",
           "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.INFORMATION_MESSAGE);
    
}

public void ConectarControlador(ControlMenuPrincipal controlPrincipal){
	control=controlPrincipal;
	menu= new MenuJugador(this);
	adivina = new AdivinanzaJFrame(this);
	control.Vista(menu,adivina);
}
	
	public void verificarJugador(){
		alias=JOptionPane.showInputDialog(null, "Alias");
		if(alias.equals(" ")){
			int x = JOptionPane.showConfirmDialog(this, "El alias esta vacio");
			if (JOptionPane.CANCEL_OPTION  == x ) {
		       	 System.exit(0);
		    }
		    else		
		    	if (JOptionPane.CLOSED_OPTION  == x )
		       		System.exit(0);		        	
		}
		else
			control.verificarUsuario(alias);						        	
	}
	
	public String buscarClave(){
		return password= JOptionPane.showInputDialog(null, "Password");
		}
	
	
	public void entrarEnAdivinanza(){
		adivina.setVisible(true);
		control.preliminar.escrituraDeDato();
		   this.setVisible(false);
		   EstadoDeBotones(false);	
	}
	public void windowClosed() {
		System.exit(0);
	}
}

