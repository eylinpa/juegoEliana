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

import controladores.ControlMenuJugador;

@SuppressWarnings("serial")
public class ModificarJFrame extends JFrame implements ActionListener{

	    ControlMenuJugador control ;
	    public JTextField tNombre, tAlias, tAlias2, tNivel, tClave;
	    public JLabel lNombre, lAlias2, lNivel, LAlias,lClave;
	    public JButton bBuscar, bGuardar,BVolver;
	    String A;
	    MenuJugador mj;
        private int posicion;
	     
	    public ModificarJFrame(MenuJugador x, ControlMenuJugador con){
	        
	    	setSize(new Dimension(400, 400));
	        setLayout(null);
	        setTitle("Modificar Jugador");
	        setResizable(false);
		    setLocationRelativeTo(null);
		    this.getContentPane().setBackground(Color.white);
		    mj=x;
	        control=con;
	        
	        LAlias = new JLabel("ALIAS JUGADOR: ");
	       	LAlias.setBounds(30,10,200,25);
	        
	        tAlias = new JTextField("");
	        tAlias.setBounds(30, 40, 200, 25);
	       	        
	        lNombre = new JLabel("NOMBRE:");
	       	lNombre.setBounds(30,110,200,25);
	       	lAlias2 = new JLabel("ALIAS: ");
	       	lAlias2.setBounds(30,140,200,25);
	       	lNivel= new JLabel("NIVEL: ");
	       	lNivel.setBounds(30,170,200,25);
	       	lClave= new JLabel("CONTRASEÑA: ");
	       	lClave.setBounds(30,220,200,25);
	        	        
	        tNombre = new JTextField("");
	       	tNombre.setBounds(140,110,200,25);
	       	tAlias2 = new JTextField("");
	       	tAlias2.setBounds(80,140,200,25);
	       	tNivel = new JTextField("");
	       	tNivel.setBounds(100,170,120,25);
	       	tClave = new JTextField("");
	       	tClave.setBounds(130,220,120,25);
	        	     
	        bGuardar = new JButton("GUARDAR");
	       	bGuardar.setBounds(150,260,100,25);
	       	bGuardar.addActionListener(this);   	
	       	
	       	BVolver = new JButton("VOLVER");
	       	BVolver.setBounds(150,300,100,25);
	       	BVolver.addActionListener(this);
	       	
	       	bBuscar = new JButton("BUSCAR");
	       	bBuscar.setBounds(30, 70 , 100, 25);
	       	bBuscar.addActionListener(this);
		        
		    add(LAlias);
		    add(tAlias);
		    add(bBuscar);
		    
		    add(lNombre);  add(tNombre);
		   	add(lAlias2);  add(tAlias2);
		   	add(lNivel);   add(tNivel);
		   	add(lClave);   add(tClave);
		   	add(bGuardar); add(BVolver);
		   	
	        this.addWindowListener
	        (
	            new WindowAdapter() {
	                @Override
	                public void windowClosing(WindowEvent e) {
	                    ModificarJFrame.this.windowClosed();
	                }
	            }
	        ); 
	    }
		public void mensaje(String msj){
            JOptionPane.showMessageDialog(null, msj);
		}
		public void vaciarCampoDeTexto(){
            tAlias.setText("");
            tAlias2.setText("");
            tNombre.setText("");
            tNivel.setText("");
            tClave.setText("");
		}
	    @Override
	    public void actionPerformed(ActionEvent ae) {

	        if(ae.getSource().equals(bBuscar)){
                
	            if(tAlias.equals("")){
	            	mensaje("Error dejo espacios vacios");
	            }
	            else if(control.validaTexto(tAlias.getText())){
	            	mensaje("No Introduzca Números ni Caracteres Especiales");
	            }
	            else{
	            		posicion = control.Buscar(tAlias.getText());
	            		if(posicion!=9999){
	            			tNombre.setText(control.j[posicion].getNombre());
	            			tAlias2.setText(control.j[posicion].getAlias());
	            			tNivel.setText(control.j[posicion].getNivel());	
	            			tClave.setText(control.j[posicion].getClave());	 
	            		}
	            		else {
	            				mensaje("No existe el Alias");
	            				vaciarCampoDeTexto();
	            			}
	            	}
	        	}
	        else if(ae.getSource().equals(bGuardar)){
	    		if(tAlias2.getText().equals("")||tNombre.getText().equals("")||tNivel.getText().equals("")||tClave.getText().equals("")){
	    			mensaje("Error dejo espacios vacios");
	    		}
	    		else if(control.validaTexto(tAlias2.getText()) || control.validaTexto(tNombre.getText())){
	    			mensaje(" No introduzca números ni caracteres especiales ");
	    		}
	            else{
	            		String a=control.modificar(posicion, tAlias2.getText(), tNombre.getText(),tNivel.getText(),tClave.getText());
	            		mensaje(a);
	            		vaciarCampoDeTexto();	            		
	            	}	          	            
	        	}
	        else if(ae.getSource().equals(BVolver)){
	            setVisible(false);
	            vaciarCampoDeTexto();
	            mj.setVisible(true);
	        }	       
	    }

	    private void windowClosed() {
	        setVisible(false);
            vaciarCampoDeTexto();
	    }   
}
