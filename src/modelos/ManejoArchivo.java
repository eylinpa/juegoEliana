package modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivo {
	FileReader lectura;
	FileWriter escritura;
	BufferedReader bufferLectura;
	BufferedWriter bufferEscritura;
	String linea, archivo[];
	public int i=0;
	
	public ManejoArchivo(){
		linea="";
		archivo= new String[99];
		
	}
	
	public String[] leerArchivo(){

		try {		
				lectura = new FileReader("adjunto/jugador.dat");
				bufferLectura= new BufferedReader(lectura);
					
				while(linea!=null){
					
					linea=bufferLectura.readLine();
					if (linea!=null){
						archivo[i++]=linea;
					}
				}

				lectura.close();
				return archivo;
			} 
		catch (IOException e) {
				
			System.out.println("ocurrio un error al leer en el archivo");
		}
		return archivo;
	}
	
	public void escribirArchivo(String escribir){
		try {
		
			escritura = new FileWriter("adjunto/jugador.dat", true);
			bufferEscritura= new BufferedWriter(escritura);
			escritura.write(escribir);
			
			escritura.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void remplazarEscrituraArchivo(String escribir){
		try {
		
			escritura = new FileWriter("adjunto/jugador.dat");
			bufferEscritura= new BufferedWriter(escritura);
			escritura.write(escribir);
			
			escritura.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
