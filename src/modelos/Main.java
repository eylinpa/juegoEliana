package modelos;

import javax.swing.JFrame;
import controladores.ControlMenuPrincipal;
import vistas.PrincipalFrame;

public class Main {
	public static PrincipalFrame framePrincipal;
	public static ControlMenuPrincipal controlPrincipal;
	
	 public static void main(String [] args)
	    {
			framePrincipal = new PrincipalFrame();			
			controlPrincipal = new ControlMenuPrincipal(framePrincipal);		
			
			framePrincipal.ConectarControlador(controlPrincipal);
			controlPrincipal.vistaPrincipal();		
			framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			controlPrincipal.jugadores.llenarArregloJugador();
	    }	
	 
}
