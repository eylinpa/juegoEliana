package controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelos.Jugador;
import modelos.ManejoArchivo;
import vistas.MenuJugador;

public class ControlMenuJugador {
	ControlMenuPrincipal cmp;
	ManejoArchivo ma;
	MenuJugador vista;

	public static int max=99;
	public Jugador j[];
	String archivo[];
	public int indice;
	
	ControlMenuJugador (ControlMenuPrincipal x, MenuJugador v){
		cmp=x;
		vista=v;
		indice=-1;
		j= new Jugador[max];
		archivo=new String[max];
		ma = new ManejoArchivo();
	}
	
	
	public boolean Verificar(String alias){
	  	
	    for(int i=0; i<indice; i++){
	          if(j[i].getAlias().equals(alias))
	              return true;
	       }
	      return false;
	  }
	
	public void agregarJugador(String n,String a, String e,String c){
	  	indice++;
	    if(indice<max && indice!=0 )
	    {    	
	    	boolean x= Verificar(a);
	    	if(x){
	    		vista.A.mensaje("El jugador ingresado ya se encuentra registrado");
	    	}
	    	else {
	    		j[indice] = new Jugador(n,a,e,c);
	       	  ma.escribirArchivo(j[indice].Almacenar()); 
            	vista.A.mensaje("El jugador ingresado "  + " es " + j[indice].mostrarJugador());
        	    vista.A.vaciarCampoDeTexto();       
           }
        }
	    else if (indice==0)
	    {
	    	j[indice] = new Jugador(n,a,e,c);	 
	    	 ma.escribirArchivo(j[indice].Almacenar());  
	    	vista.A.mensaje("El jugador ingresado "+" es " + j[indice].mostrarJugador());
	    	vista.A.vaciarCampoDeTexto();
	    }
	    else{
	    	vista.A.mensaje("No hay mas espacio para ingresar jugadores");		    	
	    }
	}
	
	public String eliminarJugador(String alias){
		int pos=Buscar(alias);
		Jugador aux;
		if(pos!=9999)
		{	
			for(int k = pos; k <indice; k++)
		    {
				aux = j[k];
		        j[k] = j[k+1];
		        j[k+1] = aux;
		     }
			indice--;
			         guardarEnArchivo();
            return "El jugador ha sido eliminado";
		    }
		else{
			return "El Alias no existe en el juego";
		}
	}

	public String[][] mostrarJugador(){
	   String cadena[][]= new String[max][5];
	   for(int i=0; i<=indice ; i++)
	   {   
		   cadena[i][0]= Integer.toString(i+1);
		   cadena[i][1]= j[i].getNombre();
		   cadena[i][2]= j[i].getAlias();
		   cadena[i][3]= j[i].getNivel();
		   cadena[i][4]= Integer.toString(j[i].getPuntuacion());
	   } 
	    return cadena;
	}

	public int Buscar(String alias){
	    for(int i=0; i<=indice; i++){
	        if(j[i].getAlias().equals(alias))
	            return i;
	     }	    
	   return 9999;
	}

	public String modificar(int pos, String al,String nom,String nivel, String clave){
		if(!Verificar(al))     
    	   {
			j[pos].setAlias(al);
    	   	j[pos].setNombre(nom);
    	   	j[pos].setNivel(nivel);
    	   	j[pos].setClave(clave);
    	   	
    	   	guardarEnArchivo();
    	   	
    	   	return "Jugador Modificado con exito";
    	   }
		else
			{
				return "El alias ya existe en registro";
			}
    }
 
	public boolean VerificarClave(int a, String b){
		if(j[a].getClave().equals(b))
			return true;
		else
			return false;
	}
    public boolean validaTexto(String texto){
  
    	Pattern p = Pattern.compile("[^A-Za-z]+");
    	Matcher m = p.matcher(texto);
    	
    	if (m.find())
    		return true;
    	else
    		return false;
    }
	
	public void llenarArregloJugador(){
		
		archivo=ma.leerArchivo();
		String[] cadena;
		if(archivo!=null)
		{	
			for(indice=0; archivo[indice]!=null; indice++)
			{  
	  			cadena=archivo[indice].split(" ");
	  			j[indice] = new Jugador();
	  			j[indice].setNombre(cadena[0]);
	  			j[indice].setAlias(cadena[1]);
	  			j[indice].setNivel(cadena[2]);
	  			j[indice].setClave(cadena[3]);
	  			j[indice].setPuntuacion(Integer.parseInt(cadena[4]));
	  		}
	  	}
		indice--;
	}
	
	public void guardarEnArchivo(){
		for(int i=0; i<=indice; i++){
			if(i==0)
				ma.remplazarEscrituraArchivo(j[i].Almacenar());
			else
				ma.escribirArchivo(j[i].Almacenar());	
		}
	}
}
	
	