package vistas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import controladores.ControlJuego;


@SuppressWarnings("serial")
public class IniciarJuego extends JFrame  implements ActionListener{ 
	
	ControlJuego control;
	PrincipalFrame pf;
    public JLabel LPregunta, LNombre;
    public JButton BVolver,BAceptar;
    public JRadioButton RBOpc1, RBOpc2, RBOpc3, RBOpc4;
    public ButtonGroup BGOopciones;
    int puntos, intentos, intentoTotal;
	
    
    public IniciarJuego(PrincipalFrame p){
   	 
  	 setSize(new Dimension(800, 350));
  	 setResizable(false);
  	 setLocationRelativeTo(null);	
     setLayout(null);
    
     pf=p;
  	 setTitle("Juego Didáctico Fauna Del Cono Monetario Venezolano");
  	 intentos=0;
  	 intentoTotal=0;
  	 
  	 LNombre = new JLabel("");
  	 LNombre.setBounds(550,20,250,25);
  	 
  	 LPregunta = new JLabel("");
  	 LPregunta.setBounds(30,40,2000,25);
  	 
  	 
	 RBOpc1 = new JRadioButton();
  	 RBOpc1.setBounds(30,70,135,25);
  	
  	 RBOpc2 = new JRadioButton();
  	 RBOpc2.setBounds(30,100,135,25);
  	
  	 RBOpc3 = new JRadioButton();
  	 RBOpc3.setBounds(30,130,135,25);
  	
  	 RBOpc4 = new JRadioButton();
  	 RBOpc4.setBounds(30,160,135,25);
  	 
  		
  	BGOopciones= new ButtonGroup();
  	BGOopciones.add(RBOpc1);
  	BGOopciones.add(RBOpc2);
  	BGOopciones.add(RBOpc3);
  	BGOopciones.add(RBOpc4);
    
  	 BAceptar = new JButton("Aceptar");
  	 BAceptar.setBounds(30, 200 , 100, 25);
    
  	 BVolver = new JButton("Volver");
  	 BVolver.setBounds(30, 250 , 100, 25);
          
     BVolver.addActionListener(this);
     BAceptar.addActionListener(this);
         
      add(LPregunta);
      add(RBOpc1);
      add(RBOpc2);
      add(RBOpc3);
      add(RBOpc4);
      add(BVolver);
      add(BAceptar);
      add(LNombre);
      
      this.addWindowListener
      (
          new WindowAdapter() {
              @Override
              public void windowClosing(WindowEvent e) {
              	
           	   IniciarJuego.this.windowClosed();
              }
          }
      ); 
    }
    public void ConectarControlador(ControlJuego c){
		control=c;		
		control.agregarPreguntas();
		
	}
    
   private void windowClosed() {
       setVisible(false);
   }
   
   public void vaciarRadioButton(){
	   BGOopciones.clearSelection();
	   
	}
   	
	public void respuestaCorrecta(){
				
			JOptionPane.showMessageDialog(null, "Es Correcta tu Respuesta llevas acumulado un total de: " +puntos+ " Puntos ",
                 "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/correcta.png"));
	}

	public void dejoEspacios(){
		 JOptionPane.showMessageDialog(null, " No realizo selección  ");
	}
	public void finJuego(){
		JOptionPane.showMessageDialog(null, " FELICITACIONES GANASTE " + puntos + " Puntos ",
				"JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/logro.jpg"));
	}
	
	
	public void respuestaIncorrecta(String msj){
		JOptionPane.showMessageDialog(null, msj,
                "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/Intentalo.jpg"));
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(BAceptar==ae.getSource()){
			String r=control.buscarRadioButonSeleccionado();
					
			intentoTotal++;	
			if(intentoTotal<=8)	{ 	
				if (control.verificarRespuesta(r)){			
					puntos=control.PuntosObtenidos();
					respuestaCorrecta();  
					
					control.agregarPreguntas();	
					}
					else {
						intentos++;
						if(intentos<=2){
							puntos=control.PuntosObtenidos();
							respuestaIncorrecta(" La respuesta es incorrecta tiene una segunda oportunidad: " + puntos + " Puntos");	    			
							this.setVisible(true);
						}
						else{
							puntos=control.PuntosObtenidos();
							respuestaIncorrecta(" La respuesta es incorrecta no tiene mas oportunidades su puntuacion es: " + puntos + " Puntos hasta luego");
							this.setVisible(false);
							pf.setVisible(true);	
							pf.EstadoDeBotones(true);
						}
	            	}	               
	        	}
			else {
				finJuego();
			   	this.setVisible(false);
				pf.setVisible(true);	
				pf.EstadoDeBotones(true);
			}
		}
				
	    else if(BVolver==ae.getSource()){
	        	setVisible(false);
	        	pf.setVisible(true);  
	        	pf.EstadoDeBotones(true);
	        }	
		}
	

}