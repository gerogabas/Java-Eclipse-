package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Fusers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2517114554237750571L;
	private JPanel contentPane;
	Empresa emp;
	
	JTextArea textArea = new JTextArea();
	
	public Fusers(Empresa emp) {
		this.emp = emp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarLista();
			}
		});
		btnNewButton.setBounds(10, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setBounds(134, 164, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quitar");
		btnNewButton_2.setBounds(266, 164, 89, 23);
		contentPane.add(btnNewButton_2);
	
		
		
		textArea.setBounds(82, 48, 108, 34);
		contentPane.add(textArea);
		actualizarLista();
	}
	private void actualizarLista() {
		//texto.removeAll();
		//Set<String> users = emp.verUsuarios();
		
		//users.forEach(x -> texto.setText(x.toString()));
		
	}
}
