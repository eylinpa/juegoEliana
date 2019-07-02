package modelos;

public class Pregunta 
{
	private String pregunta, respCorrecta, opc1, opc2,opc3;
	private int min=1, maxOpc=3, aleatorioOpc=0;
	String a[];
	public Pregunta(){
		pregunta="";
		respCorrecta="";
		opc1="";
		opc2="";
		opc3="";
		
	}
	public Pregunta(String p, String rc, String o1, String o2, String o3){
		pregunta=p;
		respCorrecta=rc;
		opc1=o1;
		opc2=o2;
		opc3=o3;
		
	}
	
	public void setIngreso(String p, String rc, String o1, String o2, String o3){
		pregunta=p;
		opc1=o1;
		opc2=o2;
		opc3=o3;
	}
	
	public void setPregunta(String p){
		pregunta=p;
		
	}
	
	public void setCorrecta(String p){
			respCorrecta=p;
		
		}
		
	
	public void setOpciones(String p1, String p2, String p3){
			opc1=p1;
			opc2=p2;
			opc3=p3;
		}
	
	public String getPregunta(){
			return pregunta;
		}
	
	public String getCorrecta(){
			return respCorrecta;
			
		}
		
	public String getOpc1(){
			return opc1;
		}
	public String getOpc2(){
		return opc2;
	}
	public String getOpc3(){
		return opc3;
	}
	
    public String mostrarPregunta(){
        return "Pregunta: "+pregunta+" Las opciones son:";
    }
    
    public String mostrarOpciones(){
        aleatorioOpc = (int)(Math.random()*(maxOpc))+min; 
          
         switch (aleatorioOpc)
         {
             case 1:
             	return "\n 1. "+ respCorrecta+ "\n 2. "+opc1+"\n 3. "+ opc3+ "\n 4. "+ opc2;                                   
             case 2:
             	return "\n 1. "+ opc1+"\n 2. "+respCorrecta+"\n 3. "+ opc2+ "\n 4. "+ opc3;
             case 3:
             	return "\n 1. "+ opc2+"\n 2. "+opc3+"\n 3. "+respCorrecta+ "\n 4. "+opc1;                                   
             case 4:
             	return "\n 1. "+ opc3+"\n 2. "+opc2+"\n 3. "+opc1+ "\n 4. "+respCorrecta;                                   
         }
                return "\n 1. "+ opc3+"\n 2. "+opc1+"\n 3. "+opc2+ "\n 4. "+respCorrecta; 
     }
    
     } 


