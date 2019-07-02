package modelos;

public class Adivinanza {

	private String adivina, respuesta;
	
	public Adivinanza(){
		adivina="";
		respuesta="";
	}
	public Adivinanza(String a, String r){
		adivina=a;
		respuesta=r;
	}
	
	public String getAdivina(){
		return adivina;
	}
	
	public String getRespuesta(){
		return respuesta;
	}
	
	public void setAdivina(String a){
		adivina=a;
	}
	
	public void setRespuesta(String r){
		respuesta=r;
	}
	
	 public String mostrarAdivinanza(){
	        return "La Adivinanza a resolver es: "+ adivina;
	    }
	 
	 public String mostrarRespuesta(){
	        return "La respuesta a esta Adivinanza: "+adivina + " Es: /n"+ respuesta;
	    }
}

