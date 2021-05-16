package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.controllers.EstudianteControlador;
import model.controllers.MateriaControlador;
import model.controllers.ProfesorControlador;
import model.controllers.ValoracionMateriaControlador;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnlValoracion2 extends JPanel {

	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Integer> jcbValoracion;
	JList jListNoSeleccionados;
	JList jListSeleccionados;
	
	DefaultListModel<Estudiante> dlmNoSeleccionados = new DefaultListModel<Estudiante>();
	DefaultListModel<Estudiante> dlmSeleccionados = new DefaultListModel<Estudiante>();
	
	/**
	 * Create the panel.
	 */
	public PnlValoracion2() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Valoración:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbValoracion = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbValoracion = new GridBagConstraints();
		gbc_jcbValoracion.insets = new Insets(0, 0, 5, 0);
		gbc_jcbValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbValoracion.gridx = 1;
		gbc_jcbValoracion.gridy = 2;
		add(jcbValoracion, gbc_jcbValoracion);
		
		JButton btnNewButton_5 = new JButton("Refrescar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 3;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		jListNoSeleccionados = new JList(dlmNoSeleccionados);
		jListNoSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(jListNoSeleccionados);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionarUno();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(">");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarUno();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(">>");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 3;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		jListSeleccionados = new JList(dlmSeleccionados);
		jListSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(jListSeleccionados);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		add(btnNewButton, gbc_btnNewButton);

		
		cargarMaterias();
		cargarProfesores();
		cargarNotas();
	}
	
	
	/**
	 * 
	 */
	private void cargarMaterias() {
		List<Materia> materias = MateriaControlador.getInstancia().findAll();
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}

	/**
	 * 
	 */
	private void cargarProfesores() {
		List<Profesor> profesores = ProfesorControlador.getInstancia().findAll();
		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
	}

	/**
	 * 
	 */
	private void cargarNotas() {
		for (int i = 0; i < 11; i++) {
			this.jcbValoracion.addItem(Integer.valueOf(i));
		}
	}
	
	/**
	 * 
	 */
	private void refrescarEstudiantes() {
		Profesor p = (Profesor) this.jcbProfesor.getSelectedItem();
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		Integer v = (Integer) this.jcbValoracion.getSelectedItem();
		List<Estudiante> estudiantes = EstudianteControlador.getInstancia().findAll();
		
		this.dlmNoSeleccionados.clear();
		this.dlmSeleccionados.clear();
		
		for (Estudiante e : estudiantes) {
			if (ValoracionMateriaControlador.getInstancia().findByMateriaAndProfesorAndEstudianteAndValoracion(m, p, e, v.floatValue()) == null) {
				this.dlmNoSeleccionados.addElement(e);
			}
			else {
				this.dlmSeleccionados.addElement(e);
			}
			
		}
	}
	
	
	/**
	 * 
	 */
	private void deseleccionarTodos() {
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) {
			this.dlmNoSeleccionados.addElement(this.dlmSeleccionados.elementAt(i));
		}
		this.dlmSeleccionados.clear();
	}
	
	/**
	 * 
	 */
	private void seleccionarTodos() {
		for (int i = 0; i < this.dlmNoSeleccionados.size(); i++) {
			this.dlmSeleccionados.addElement(this.dlmNoSeleccionados.elementAt(i));
		}
		this.dlmNoSeleccionados.clear();
	}
	
	/**
	 * 
	 */
	private void deseleccionarUno() {
		// Agregar seleccionados
		for (int i = 0; i < this.jListSeleccionados.getSelectedIndices().length; i++) {
			this.dlmNoSeleccionados.addElement(this.dlmSeleccionados.getElementAt(jListSeleccionados.getSelectedIndices()[i]));
		}
		// Elimino seleccionados
		for (int i = this.jListSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmSeleccionados.removeElementAt(this.jListSeleccionados.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void seleccionarUno() {
		// Agregar seleccionados
		for (int i = 0; i < this.jListNoSeleccionados.getSelectedIndices().length; i++) {
			this.dlmSeleccionados.addElement(this.dlmNoSeleccionados.getElementAt(jListNoSeleccionados.getSelectedIndices()[i]));
		}
		// Elimino seleccionados
		for (int i = this.jListNoSeleccionados.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmNoSeleccionados.removeElementAt(this.jListNoSeleccionados.getSelectedIndices()[i]);
		}

	}
	
	/**
	 * 
	 */
	private void guardar() {
		Profesor p = (Profesor) this.jcbProfesor.getSelectedItem();
		Materia m = (Materia) this.jcbMateria.getSelectedItem();
		Integer v = (Integer) this.jcbValoracion.getSelectedItem();
		
		for (int i = 0; i < this.dlmSeleccionados.size(); i++) {
			Estudiante e  = this.dlmSeleccionados.elementAt(i);
			// ¿Existe una valoración para este estudiante?
			ValoracionMateria vm = ValoracionMateriaControlador.getInstancia().
					findByMateriaAndProfesorAndEstudiante(m, p, e);
			if (vm == null) { 
				vm = new ValoracionMateria();
				vm.setEstudiante(e);
				vm.setProfesor(p);
				vm.setMateria(m);
				vm.setValoracion(v);
			}
			else {
				vm.setValoracion(v);
			}
			// Guardo el registro
			ValoracionMateriaControlador.getInstancia().save(vm);
		}
	}
}
