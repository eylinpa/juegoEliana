package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controladores.ControlJuegoPreliminar;

@SuppressWarnings("serial")
public class AdivinanzaJFrame extends JFrame  implements ActionListener{ 
	
	ControlJuegoPreliminar control;
	IniciarJuego ij;
	PrincipalFrame pf;
	public JLabel LAdivina, LRespuesta, LNombre;
	public JTextField tRespuesta;
	public JButton BVolver,BAceptar;	
	
	public AdivinanzaJFrame(PrincipalFrame p){
	    	 
		 pf=p;
	   	 setSize(new Dimension(850,400));
	   	 setLayout(null);
	     setTitle("Juego Preliminar Adivinanza");
	     setResizable(false);
	     setLocationRelativeTo(null);
	     this.getContentPane().setBackground(Color.white);
	     LNombre = new JLabel("");
	     LNombre.setBounds(550,30,250,25);
	     
	     LAdivina = new JLabel("");
	     LAdivina.setBounds(30,60,2000,25);
	     
	     LRespuesta = new JLabel("La respuesta a la Adivinanza es: ");
	     LRespuesta.setBounds(30,100,200,25);
	        
	     tRespuesta = new JTextField(10);
	     tRespuesta.setBounds(30, 130, 200, 25);
	        	        	     	     
	     BAceptar = new JButton("Aceptar");
	     BAceptar.setBounds(30, 180 , 100, 25);
	     
	     BVolver = new JButton("Volver");
	     BVolver.setBounds(30, 230 , 100, 25);  
	          
	     this.addWindowListener
	        (
	            new WindowAdapter() {
	                @Override
	                public void windowClosing(WindowEvent e) {
	                	
	             AdivinanzaJFrame.this.windowClosed();
	                }
	            }
	        ); 
	       
	       BAceptar.addActionListener(this);
	       BVolver.addActionListener(this);  
	       
	       add(LNombre);
	       add(LAdivina);
	       add(LRespuesta);
	       add(tRespuesta);
	       add(BAceptar);
	       add(BVolver);
	     }
	public void ConectarControlador(ControlJuegoPreliminar c){
			control=c;
			control.escrituraDeDato();
	}
	
	private void windowClosed() {
	        setVisible(false);
	        tRespuesta.setText("");
	}
	    
	public void casoIncorrecto(String msj){
	        JOptionPane.showMessageDialog(null, msj,
	        "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.ERROR_MESSAGE);
	}
	
	public void limpiarDato(){

		tRespuesta.setText(" ");
		LAdivina.setText(" ");
	}
	
	public void casoCorrecto(String msj){  
		JOptionPane.showMessageDialog(null, msj,
	    "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.INFORMATION_MESSAGE);
	}		
	
	public void actionPerformed(ActionEvent ae) {
		if(BAceptar==ae.getSource()){          
	       String  r = tRespuesta.getText();           
	       if(r.equals("")){
	          JOptionPane.showMessageDialog(null, "Dejo espacios vacios");
	        }
	       else{     	
	            if (control.verificarRespuesta(r)){
	            		this.setVisible(false);
	            		ij= new IniciarJuego(pf);
	            		ij.setVisible(true);
	            		
	            		limpiarDato();
	            		
	            		control.VistaJuego(ij);  
	            		
	            	}
	           	else  this.setVisible(true);	           	
	          }
	    }
	    else if(BVolver==ae.getSource()){
	        	setVisible(false);
	        	limpiarDato();
	        	pf.setVisible(true);
	        	pf.EstadoDeBotones(true);
	        }
	   }
}
