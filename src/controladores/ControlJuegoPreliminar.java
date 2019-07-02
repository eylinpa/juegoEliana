package controladores;

import java.util.Calendar;
import java.util.GregorianCalendar;
import modelos.Adivinanza;
import vistas.AdivinanzaJFrame;
import vistas.IniciarJuego;

public class ControlJuegoPreliminar{
	AdivinanzaJFrame vista;
	ControlJuego controlJuego;
	ControlMenuPrincipal controlPrincipal;
	ControlMenuJugador jugador;
	
	public static int min = 1, max = 3, sIni = 0, sFin = 0;
	public int pregunta, aleatorioPrel, posJugador;
	static String segundoIni, segundoFin;    
	static Calendar seg1;
	Adivinanza adivina[];
	
	
	
	public ControlJuegoPreliminar(ControlMenuPrincipal c, ControlMenuJugador cj, AdivinanzaJFrame af){
		
		jugador=cj;
		vista= af;
		controlPrincipal= c;
		adivina= new Adivinanza[3];	
		
		adivina[0]=new Adivinanza("Soy un animal muy elegante, muy veloz y poco fiero, \n cuando quiero calzarme, \n voy a casa del herrero. \n ¿Qué es?","CABALLO");
		adivina[1]=new Adivinanza("Tengo nombre de animal, cuando el caucho se pincha, \n me tienes que utilizar. \n ¿Qué es?","GATO");
		adivina[2]=new Adivinanza("Soy ave y soy llana, pero no tengo pico ni alas. \n ¿Qué es?","AVELLANA");
		
	}
		
	public void escrituraDeDato(){
		seg1 = new GregorianCalendar();                
		aleatorioPrel = (int)(Math.random()*(max))+min;            
		 switch (aleatorioPrel)
	        {
	        case 1:
	        	vista.LAdivina.setText(adivina[0].mostrarAdivinanza());
	        	pregunta=0;
	        	break; 
	        case 2:
	        	vista.LAdivina.setText(adivina[1].mostrarAdivinanza());
	        	pregunta=1;
	        	break;
	        case 3:
	        	vista.LAdivina.setText(adivina[2].mostrarAdivinanza());
	        	pregunta=2;
	        	break;
	        }
}
	
	public boolean verificarRespuesta(String respuesta){
		if(tiempoResponder()<=10)
    	{       
    		if(respuesta.equalsIgnoreCase(adivina[pregunta].getRespuesta())){
    			vista.casoCorrecto("Contesto correctamente en un tiempo de  " + tiempoResponder()+ "Seg");   			
    			return true;   			
    		}
    		else{
    			vista.casoIncorrecto("Respuesta Incorrecta");
    			vista.tRespuesta.setText("");   
    			seg1 = new GregorianCalendar(); 
    			return false;
    		}   		
     	}
		else{ 
			
			vista.casoIncorrecto("Tardo mucho tiempo en Responder");
			vista.tRespuesta.setText("");
			seg1 = new GregorianCalendar(); 
			return false;
			
		}
	}
	
	public static int tiempoResponder()
    {
        Calendar seg2 = new GregorianCalendar();
        
        segundoIni = Integer.toString(seg1.get(Calendar.SECOND));
        segundoFin = Integer.toString(seg2.get(Calendar.SECOND));
       
        sIni = Integer.parseInt(segundoIni);
        sFin = Integer.parseInt(segundoFin);

        int resEntrar = sIni - sFin;
        if (resEntrar < 0)
        {
            resEntrar = resEntrar * (-1);
        }
        return resEntrar;
    }
	public void VistaJuego(IniciarJuego preguntas){
		controlJuego = new ControlJuego(controlPrincipal, jugador, preguntas);
		preguntas.ConectarControlador(controlJuego);
	}
	public void JugadorEnJuego(int pos){
		posJugador=pos;
		vista.LNombre.setText("El Alias es: " +jugador.j[pos].getAlias() + " Puntuacion " + jugador.j[pos].getPuntuacion());
		
	}
	public int enviarJugador(){
		return posJugador;
	}
	
	
}