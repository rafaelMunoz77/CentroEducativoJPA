package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JToolBar;

import model.controllers.EstudianteControlador;
import model.entities.Estudiante;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnlDatosEstudiante extends JPanel {

	PnlDatosPersonales pnlDatos = new PnlDatosPersonales();
	Estudiante actual = new Estudiante();
	
	/**
	 * Create the panel.
	 */
	public PnlDatosEstudiante() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		add(pnlDatos, BorderLayout.CENTER);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = EstudianteControlador.getInstancia().findFirst();
				cargarActualEnPantalla();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = EstudianteControlador.getInstancia().findPrevious(actual);
				cargarActualEnPantalla();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = EstudianteControlador.getInstancia().findNext(actual);
				cargarActualEnPantalla();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = EstudianteControlador.getInstancia().findLast();
				cargarActualEnPantalla();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		// Cargo el primer registro en pantalla
		actual = EstudianteControlador.getInstancia().findFirst();
		cargarActualEnPantalla();
	}
	

	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.pnlDatos.setNombre(this.actual.getNombre());
			this.pnlDatos.setApellidoPrimero(this.actual.getApellido1());
			this.pnlDatos.setApellidoSegundo(this.actual.getApellido2());
			this.pnlDatos.setDNI(this.actual.getDni());
			this.pnlDatos.setDireccion(this.actual.getDireccion());
			this.pnlDatos.setEmail(this.actual.getEmail());
			this.pnlDatos.setTelefono(this.actual.getTelefono());
			this.pnlDatos.setTipologiaSexo(this.actual.getTipologiasexo());
			this.pnlDatos.setImagen(this.actual.getImagen());
		}
	}


	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setNombre(this.pnlDatos.getNombre());
		this.actual.setApellido1(this.pnlDatos.getApellidoPrimero());
		this.actual.setApellido2(this.pnlDatos.getApellidoSegundo());
		this.actual.setDni(this.pnlDatos.getDni());
		this.actual.setDireccion(this.pnlDatos.getDireccion());
		this.actual.setEmail(this.pnlDatos.getEmail());
		this.actual.setTelefono(this.pnlDatos.getTelefono());
		this.actual.setTipologiasexo(this.pnlDatos.getTipologiaSexo());
		this.actual.setImagen(this.pnlDatos.getImagen());
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		if (EstudianteControlador.getInstancia().save(this.actual)) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	

	/**
	 * 
	 */
	private void nuevo() {
		this.actual = new Estudiante();
		cargarActualEnPantalla();
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        new ImageIcon(PnlDatosEstudiante.class.getResource("/gui/res/confirm.png")), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	if (EstudianteControlador.getInstancia().remove(actual)) {
	    		JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
	    		actual = EstudianteControlador.getInstancia().findFirst();
	    		cargarActualEnPantalla();
	    	}
	    }
	}
}
