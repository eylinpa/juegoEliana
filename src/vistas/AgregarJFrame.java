package vistas;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import controladores.ControlMenuJugador;


@SuppressWarnings("serial")
public class AgregarJFrame extends JFrame implements ActionListener{ 
	
	JLabel lNombre, lAlias, lNivel,lClave;
    JTextField tNombre, tAlias, tNivel,tClave;
   	JComboBox comboNivel;
    JButton bAgregar, bVolver;
    ControlMenuJugador control;
    MenuJugador mj;
    boolean verificar;
    
    
    String A;
    static String gra [] = {" Seleccione ","1°año", "2°año", "3°año", "4°año", "5°año"};

    /**
     * The constructor.
     */  
     public AgregarJFrame(MenuJugador x, ControlMenuJugador con) {
       
      
       	setLayout(null); 
	    setResizable(false);
	    setLocationRelativeTo(null);
        setTitle("Agregar Jugador");
        setSize(new Dimension(400, 400)); 
        this.getContentPane().setBackground(Color.white);
        mj= x;
       	control=con;    
       	      	
       	lNombre = new JLabel("NOMBRE:");
       	lNombre.setBounds(30,40,200,25);
       	
       	tNombre = new JTextField(10);
       	tNombre.setBounds(90,40,200,25);
       	
       	lAlias = new JLabel("ALIAS: ");
       	lAlias.setBounds(30,80,200,25);
       	
       	tAlias = new JTextField("");
       	tAlias.setBounds(80,80,200,25);
       	
       	lNivel = new JLabel("NIVEL ESTUDIO: ");
       	lNivel.setBounds(10,130,200,25);
       	
       	comboNivel = new JComboBox(gra);
       	comboNivel.setBounds(120,130,125,25);
       	
       	lClave = new JLabel("CONTRASEÑA:");
       	lClave.setBounds(30,200,200,25);	      
             	       	                   	
     	tClave = new JTextField (4);
       	tClave.setBounds(130,200,200,25);
       	
       	bAgregar = new JButton("AGREGAR");
       	bAgregar.setBounds(150,260,100,25);
       	bAgregar.addActionListener((ActionListener) this);
       	
       	bVolver = new JButton("VOLVER");
       	bVolver.setBounds(150,300,100,25);      	
       	bVolver.addActionListener(this);
       	     	
       	add(lNombre); add(tNombre);
       	add(lAlias); add(tAlias);
       	add(lNivel); add(comboNivel);
       	add(lClave); add(tClave);
       	add(bAgregar); add(bVolver);  
       	
        // Add window listener.
        this.addWindowListener
        (new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    AgregarJFrame.this.windowClosed();
                }
            }
        );  
    }
    public void mensaje(String msj){
    	JOptionPane.showMessageDialog(null, msj);
    }
    
    public void actionPerformed(ActionEvent ae){
 
    	if(ae.getSource().equals(bAgregar)){
    		if(tAlias.getText().equals("")||tNombre.getText().equals("")||comboNivel.getSelectedItem().equals(" Seleccione ")||tClave.getText().equals("")){
    			mensaje("Error dejo espacios vacios");
    		}
    		else if(control.validaTexto(tAlias.getText()) || control.validaTexto(tNombre.getText())){
    			mensaje(" No introduzca números ni caracteres especiales");
    		}
     		else{    
    				control.agregarJugador(tNombre.getText(), tAlias.getText(),(String)comboNivel.getSelectedItem(),tClave.getText());                  
    			}   
    	}   	
    	else if(ae.getSource().equals(bVolver)){
            setVisible(false);
            vaciarCampoDeTexto();
            mj.setVisible(true);
        }
    	}
    
    public void vaciarCampoDeTexto(){
        tNombre.setText("");
        tAlias.setText("");
        comboNivel.setSelectedIndex(0);
        tClave.setText(""); 
    }
    
    protected void windowClosed() {
            setVisible(false);
            vaciarCampoDeTexto(); 
            mj.setVisible(true);
    }  
}