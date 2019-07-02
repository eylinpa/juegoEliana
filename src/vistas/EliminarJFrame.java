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
public class EliminarJFrame extends JFrame implements ActionListener  { 
	
	 public JButton BEliminar, BVolver;
     public JTextField tAlias;
     public JLabel LAlias;
     ControlMenuJugador control ;
     MenuJugador mj;
     
     public EliminarJFrame(MenuJugador x, ControlMenuJugador con){
   	 
    	setSize(new Dimension(300, 200));
   	 	setTitle("Eliminar Jugador");
        setLayout(null);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    this.getContentPane().setBackground(Color.white);
	    mj=x;
        control=con;
                  
   	 	LAlias = new JLabel("ALIAS JUGADOR: ");
   	 	LAlias.setBounds(30,38,200,25);
        
   	 	tAlias = new JTextField("");
   	 	tAlias.setBounds(30, 70, 200, 25);
        
   	 	BEliminar = new JButton("Eliminar");
   	 	BEliminar.setBounds(30, 100 , 100, 25);         
        BEliminar.addActionListener(this);
          
        
        BVolver = new JButton("Volver");
        BVolver.setBounds(150,100,100,25);
        BVolver.addActionListener(this);
       
        add(LAlias);
        add(tAlias);
        add(BEliminar);
        add(BVolver);
       
        this.addWindowListener
        (
           new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {            	
            	   EliminarJFrame.this.windowClosed();
               }
           }
        ); 
     }
     public void mensaje(String m){
    	 JOptionPane.showMessageDialog(null, m);
     }
     
     public void ocultarVista(){
    	 mj.setVisible(true);
    	 this.setVisible(false);
     }
     @Override
     public void actionPerformed(ActionEvent ae) {
          if(ae.getSource().equals(BEliminar)){    	  
              if(tAlias.getText().equals("")){
            	  mensaje(" Dejo espacios vacios");
                  }
              else{   
            	  	  mensaje(control.eliminarJugador(tAlias.getText()));
                	  tAlias.setText("");
                	  ocultarVista();
              }
         }
         else if(ae.getSource().equals(BVolver)){
        	 ocultarVista();
         }
     }
	private void windowClosed() {
		ocultarVista();
    }
}
