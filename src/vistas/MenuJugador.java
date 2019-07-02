package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladores.ControlMenuJugador;

@SuppressWarnings("serial")
public class MenuJugador extends JFrame implements ActionListener{
	 
	
    JButton BAgregar, BEliminar,BModificar,BMostrar,bvolver;
    
    public AgregarJFrame A;
    public EliminarJFrame E;
    public ModificarJFrame M;
    public MostrarJFrame R;
    ControlMenuJugador control;
    PrincipalFrame pf;

	public MenuJugador(PrincipalFrame p){
        pf=p;
        
        MenuJugador.this.setResizable(false);          
        
        setTitle("JUEGO DIDACTICO FAUNA DEL CONO MONETARIO");
        setSize(new Dimension(300, 300));
	    setLocationRelativeTo(null);
        setLayout(null); 
        this.getContentPane().setBackground(Color.white);
                           
        BAgregar = new JButton("Agregar Jugador");
	   	BAgregar.setBounds(60,30,180,25);
	   	
	    BModificar = new JButton("Modificar Jugador");
	   	BModificar.setBounds(60,70,180,25);
	    
	    BEliminar = new JButton("Eliminar Jugador");
	   	BEliminar.setBounds(60,110,180,25);
	   	
	    BMostrar = new JButton("Mostrar Jugador");
	   	BMostrar.setBounds(60,150,180,25);
	    
	    bvolver = new JButton("Volver");
	    bvolver.setBounds(60,190,180,25);
	   	
	    BAgregar.addActionListener(this);
	   	BModificar.addActionListener(this);
	    BEliminar.addActionListener(this);
	    BMostrar.addActionListener(this);
	    bvolver.addActionListener(this);  
	    
	    add(BAgregar);
	    add(BModificar);
	    add(BEliminar);
	    add(BMostrar);
	    add(bvolver);  
	    
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                	 MenuJugador.this.windowClosed();
                }
            }
        );  
	}
	
	public void ConectarControlador(ControlMenuJugador c){
		control=c;
	}
	
	public void windowClosed() {
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource().equals(BAgregar)){
			A = new AgregarJFrame(this, control);
		    A.setLocationRelativeTo(null);
			A.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(BModificar)){
				M= new ModificarJFrame(this, control);
		     	M.setLocationRelativeTo(null);
				M.setVisible(true);
				this.setVisible(false);
			}   
			else if(ae.getSource().equals(BEliminar)){
					E= new EliminarJFrame(this, control);
					E.setLocationRelativeTo(null);
					E.setVisible(true);
					this.setVisible(false);
				}
		
			else if(ae.getSource().equals(BMostrar)){
				R= new MostrarJFrame(this, control);
				R.setLocationRelativeTo(null);
				R.setVisible(true);
				this.setVisible(false);
			}
		
				else if(ae.getSource().equals(bvolver)){
						pf.setVisible(true);
						pf.EstadoDeBotones(true);
						this.setVisible(false);
					}
				   	else
				   	{
					   JOptionPane.showMessageDialog(null, "Tiene que Seleccionar opcion valida",
				               "JUEGO DIDACTICO FAUNA DEL CONO MONETARIO", JOptionPane.ERROR_MESSAGE);
				    }
		}
	
	public void mensajes(String msj){
		 JOptionPane.showMessageDialog(null, msj,
	               "Menu Jugador", JOptionPane.ERROR_MESSAGE);	    
	}
}
