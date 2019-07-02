package modelos;

public class Jugador
{
	private String nombre, alias, nestudio, clave;
	private int puntuacion;
	
	public Jugador() {
    	
    	this.nombre = "";
        this.alias = "";
        this.nestudio = "";
        this.clave = "";
        puntuacion=0;
    }
	
    public Jugador(String nombre, String alias, String nestudio, String clave) {
    	
    	this.nombre = nombre;
        this.alias = alias;
        this.nestudio = nestudio;
        this.clave = clave;
        puntuacion=0;
    }
        
       public String getNombre() {
        return nombre;
    }
       public String getClave() {
           return clave;
       }
       
        public String getAlias() {
        return alias;
    }

        public String getNivel() {
        return nestudio;
    }
       public int getPuntuacion(){
        	return puntuacion;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setNivel(String nestudio) {
        this.nestudio = nestudio;
    }
    public void setPuntuacion(int p){
    	puntuacion=p;
    }
    
    public String mostrarJugador(){
        return "NOMBRE: "+nombre+"  ALIAS: "+alias+"  NIVEL DE ESTUDIO: "+nestudio +" LA PUNTUACION ES: " + puntuacion;
    }
    
    public String Almacenar(){
    	return nombre + " " + alias + " " + nestudio + " " + clave+ " "+ puntuacion + "\r"+"\n";
    }

	 
}
