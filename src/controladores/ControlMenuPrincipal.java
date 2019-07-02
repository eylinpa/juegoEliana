package controladores;

import javax.swing.JOptionPane;
import vistas.AdivinanzaJFrame;
import vistas.MenuJugador;
import vistas.PrincipalFrame;

public class ControlMenuPrincipal {

	public ControlMenuJugador jugadores;
	public ControlJuegoPreliminar preliminar;	
	public PrincipalFrame framePrincipal; 

	public ControlMenuPrincipal(PrincipalFrame fp){	
		framePrincipal=fp;
	}
	
	public void vistaPrincipal(){	
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setLocationRelativeTo(null);
	}
	
	public void Vista(MenuJugador vistaJugadores, AdivinanzaJFrame vistaPreliminar){
		jugadores= new ControlMenuJugador(this, vistaJugadores);
		preliminar= new ControlJuegoPreliminar(this,jugadores, vistaPreliminar);
		vistaJugadores.ConectarControlador(jugadores);
		vistaPreliminar.ConectarControlador(preliminar);		
	}
	
	public void verificarUsuario(String alias){
		int pos=jugadores.Buscar(alias);
		
		if (pos!=9999){
			//framePrincipal.mensaje("Ingreso correcto");
			String clave=framePrincipal.buscarClave();
			 if(jugadores.VerificarClave(pos,clave)){
					framePrincipal.entrarEnAdivinanza();
					preliminar.JugadorEnJuego(pos);							           
			}			
			else{
					framePrincipal.mensaje("Clave Incorrecta");
					clave=framePrincipal.buscarClave();
				}
			}	
		else{	
				framePrincipal.mensaje("No es su Alias Correcto");
				framePrincipal.verificarJugador();				
				
				int x = JOptionPane.showConfirmDialog(framePrincipal, "¿Desea SALIR?");				
		        if (JOptionPane.CANCEL_OPTION  == x ) {
		        	 System.exit(0);
		        }
		        else{		
		        		if (JOptionPane.CLOSED_OPTION  == x ) {
		        		System.exit(0);
		        		}
		        	}		        
			}
		}
	
	public boolean verificarJugadores(){
		if(jugadores.j[0]!=null){
			return true;
		}
		else
			return false;
	}
	
	}



