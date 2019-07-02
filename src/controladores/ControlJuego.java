package controladores;

import java.util.Random;
import modelos.Pregunta;
import vistas.IniciarJuego;

public class ControlJuego {

	 public int aleatorioJuego, respCorrJuego, puntuacion=0, caso=0, posJug;
	 public static int maxOpc=4, min=1, max=8;
	 public String  opc, preg, resp;
	 public Random rnd; 
	 public Pregunta [] pregunta;
	 public IniciarJuego ij;
	 public ControlMenuPrincipal menuPrincipal;
	 public ControlMenuJugador controlJugador;
	 	 
	public ControlJuego(ControlMenuPrincipal c,ControlMenuJugador j,IniciarJuego inic ) {
		 
		rnd = new Random();
		ij= inic;
		menuPrincipal= c;
		controlJugador=j;
		posJug=c.preliminar.enviarJugador();
		
		pregunta=new Pregunta[8];
		pregunta[0]=new Pregunta("¿Cuál es el ave que se encuentra en el reverso del billete de 2 Bs.S?","Cotorra Cambercia Amarrilla","Paraulata", "Loro", "Guacamaya");
		pregunta[1]=new Pregunta("¿Cuál de los siguientes animales es un anfibio que se encuentra en el reverso del billete de 5 Bs.S?","Sapito Rayado","Iguana", "Serpiente", "Cocodrilo");
		pregunta[2]=new Pregunta("¿Cómo se llama el animal que representa la fauna en el billete de 10 Bs.S?","Oso Palmero","Cachicamo","Oso Pardo","Danta");
		pregunta[3]=new Pregunta("¿Cuál de los siguientes animales es un carnívoro presente en el cono monetario de 20 Bs.S?","Jaguar","Puma","Leopardo","Tigre");
		pregunta[4]=new Pregunta("Es un felino de hábitos nocturnos presente en el billete de 50 Bs.S","Cunaguaro","Lapa","León","Gato");
		pregunta[5]=new Pregunta("¿Cuál es el nombre del primate presente en el billete de 100 Bs.S?","Mono Araña","Mono Capuchino","Chimpance","Gorila");
		pregunta[6]=new Pregunta("¿Cuál es el ave presente en el billete de 200 Bs.S?","Guacamaya Verde","Australiano","Agapon","Aguila");
		pregunta[7]=new Pregunta("Es un ave con un canto melodioso y muy peculiar presente en el billete de 500 Bs.S?","Turpial","Zanate","Canario","Chiruli");
	  	
		}
	
	public void agregarPreguntas()
	{ 	
		ij.vaciarRadioButton();
		aleatorioJuego = (int)(Math.random()*(8))+1;

		ij.LNombre.setText("El jugador es " + controlJugador.j[posJug].getAlias() + " La puntuacion: " + controlJugador.j[posJug].getPuntuacion());
		switch (aleatorioJuego)
	    {
	      	case 1:
	      		ij.LPregunta.setText(pregunta[0].mostrarPregunta());
	      		llenarRadioButton(0);
	      		caso=0;
	      		break;
	        case 2:
	        	ij.LPregunta.setText(pregunta[1].mostrarPregunta());
	        	llenarRadioButton(1);
	        	caso=1;
	        	break;
	        case 3:
	        	ij.LPregunta.setText(pregunta[2].mostrarPregunta());
	        	llenarRadioButton(2);
	        	caso=2;
	        	break;
            case 4:
            	ij.LPregunta.setText(pregunta[3].mostrarPregunta());
            	llenarRadioButton(3);
            	caso=3;
            	break;
	        case 5:
	        	ij.LPregunta.setText(pregunta[4].mostrarPregunta());
	        	llenarRadioButton(4);
	        	caso=4;
	        	break;
            case 6:
            	ij.LPregunta.setText(pregunta[5].mostrarPregunta());
            	llenarRadioButton(5);
            	caso=5;
            	break; 		
	        case 7:
	        	ij.LPregunta.setText(pregunta[6].mostrarPregunta());
	        	llenarRadioButton(6);
	        	caso=6;	                
	        	break;
	        case 8:
	        	ij.LPregunta.setText(pregunta[7].mostrarPregunta());
	        	llenarRadioButton(7);
	        	caso=7;
	        	break;
	      }	
   }
    public void llenarRadioButton(int pos){
        int aleatorioOpc = (int)(Math.random()*(4))+1;
        switch (aleatorioOpc)
        {
             case 1:
            	 
            	 ij.RBOpc1.setText(pregunta[pos].getCorrecta());
			   	 ij.RBOpc2.setText(pregunta[pos].getOpc1());
            	 ij.RBOpc3.setText(pregunta[pos].getOpc2());
            	 ij.RBOpc4.setText(pregunta[pos].getOpc3());
            	           	
            	 break;
             case 2:
            	 ij.RBOpc1.setText(pregunta[pos].getOpc1());
            	 ij.RBOpc2.setText(pregunta[pos].getCorrecta());
            	 ij.RBOpc3.setText(pregunta[pos].getOpc3());
            	 ij.RBOpc4.setText(pregunta[pos].getOpc2());
            	 break;
             case 3:
            	 ij.RBOpc1.setText(pregunta[pos].getOpc2());
            	 ij.RBOpc2.setText(pregunta[pos].getOpc3());
            	 ij.RBOpc3.setText(pregunta[pos].getCorrecta());
            	 ij.RBOpc4.setText(pregunta[pos].getOpc1());
            	 break;
             case 4:
            	 ij.RBOpc1.setText(pregunta[pos].getOpc3());
            	 ij.RBOpc2.setText(pregunta[pos].getOpc2());
            	 ij.RBOpc3.setText(pregunta[pos].getOpc1());
            	 ij.RBOpc4.setText(pregunta[pos].getCorrecta());
            	 break;
         }
     }	
	

	public boolean verificarRespuesta(String respuesta){ 

        if(respuesta.equals(pregunta[caso].getCorrecta()))
        {
        	controlJugador.j[posJug].setPuntuacion(controlJugador.j[posJug].getPuntuacion()+1000);
        	controlJugador.guardarEnArchivo();
        	       	
        	return true;
        }
        
        else
        {
        	controlJugador.j[posJug].setPuntuacion(controlJugador.j[posJug].getPuntuacion()-500);
        	return false;
        }
		
   	}
	
	public String buscarRadioButonSeleccionado(){
		if(ij.RBOpc1.isSelected())
			return ij.RBOpc1.getText();
		else if(ij.RBOpc2.isSelected())
				return ij.RBOpc2.getText();
			else if(ij.RBOpc3.isSelected())
					return ij.RBOpc3.getText();
				else if(ij.RBOpc4.isSelected())
					return ij.RBOpc4.getText();
	return "error";
	}
	
	public int PuntosObtenidos(){
		return controlJugador.j[posJug].getPuntuacion();
		
	}
	
	
}