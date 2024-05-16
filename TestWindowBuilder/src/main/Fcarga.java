package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

public class Fcarga extends JFrame {
	
	private static final long serialVersionUID = 3987168850280778055L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JProgressBar progressBar = new JProgressBar();
	
	public Fcarga(Empresa emp) {
		this.emp = emp;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				dispose();
			}
		});
		//*******************************************************************************
		//*******************************************************************************
		//--------------------IMPORTANTE ESTE "2" ES DISPOSE.ON.CLOSE--------------------
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//*******************************************************************************
		//*******************************************************************************
		setBounds(100, 100, 355, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(113, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		progressBar.setBounds(10, 261, 316, 20);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int id = Integer.parseInt(textField.getText());
					Long dni = Long.parseLong(textField_1.getText());
					String nombre = textField_2.getText();
					Cliente c = new Cliente(nombre, dni, id);
					
					if (emp.listaSetAgregar(c))
						JOptionPane.showMessageDialog(btnNewButton, "Agregado !");
					else JOptionPane.showMessageDialog(btnNewButton, "Ya existe el ID !");
					
					actualizarTabla();
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "'Agregar' - Error de formato numerico en 'ID' o 'DNI'");
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 227, 71, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("Quitar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//int id = System.out.println( table.getValueAt(table.getSelectedRow(), 0) );
					int id = Integer.parseInt(textField.getText());
					int opc = JOptionPane.showConfirmDialog(null, "Seguro desea borrar el ID: "+id, "Confirmar", JOptionPane.OK_CANCEL_OPTION);
					if (opc == JOptionPane.OK_OPTION)
					{
						if (emp.listaSetQuitar(id))
							JOptionPane.showMessageDialog(null, "Quitado !");
						else JOptionPane.showMessageDialog(null, "No existe el ID "+id);
						
						actualizarTabla();
					}
					progressBar.setValue(progressBar.getValue()+1);
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "'Quitar' - Error de formato numerico en 'ID'");
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(91, 227, 71, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int id = Integer.parseInt(textField.getText());
					Long dni = Long.parseLong(textField_1.getText());
					String nombre = textField_2.getText();
					Cliente c = new Cliente(nombre, dni, id);
					
					if (emp.listaSetModificar(c))
						JOptionPane.showMessageDialog(btnNewButton, "Modificado !");
					else JOptionPane.showMessageDialog(btnNewButton, "No modificado. No existe el ID !");
					
					actualizarTabla();
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "'Modificar' - Error de formato numerico en 'ID' o 'DNI' ");
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("Volver");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(263, 227, 63, 23);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(10, 39, 25, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 36, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 64, 86, 20);
		contentPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 316, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Cliente", "DNI"
			}
		));
		scrollPane.setViewportView(table);
		
		
		btnNewButton_1.setBounds(174, 227, 79, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Agregar Rnd");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emp.listaSetAgregarRandoms();
				actualizarTabla();
			}
		});
		btnNewButton_3.setBounds(227, 10, 99, 21);
		
		contentPane.add(btnNewButton_3);
		contentPane.add(progressBar);
		
		// ******************* VA AL FINAL EL ACTUALIZAR *****************************************
		actualizarTabla();
		//****************************************************************************************
	}
	Empresa emp;
	private JTextField textField;
	public void actualizarTabla() {
        Object [][] aux=new Object[emp.getListaSet().size()][3];
        int reng=0;
        for (Cliente cli : emp.getListaSet())
        {
        	aux[reng][0]=cli.getId();
        	aux[reng][1]=cli.getNombre();
        	aux[reng][2]=cli.getDni();
        	reng++;
        }
        table.setModel(new DefaultTableModel(
        aux, new String[] {"ID", "Cliente", "DNI" }));
        
        progressBar.setValue(emp.getListaSet().size());
	}
}
