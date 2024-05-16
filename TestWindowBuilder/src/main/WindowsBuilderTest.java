package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.security.auth.login.AccountException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsBuilderTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 575850704549725912L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilderTest frame = new WindowsBuilderTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowsBuilderTest() {
		try {
			empresa = deserializar();
			login();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					serializar();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cliente");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fcarga form = new Fcarga(empresa);
				form.setVisible(true);
			}
		});
		
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serializar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(10, 126, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNewButton_1 = new JButton("Serializar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serializar();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(184, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deserializar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					empresa = deserializar();
					//System.out.println(empresa.getListaClientes());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});		
		btnNewButton_2.setBounds(184, 45, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Nueva Empresa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empresa = new Empresa();
			}
		});
		btnNewButton_3.setBounds(166, 126, 107, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Usuarios");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fusers f = new Fusers(empresa);
				f.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(10, 68, 89, 23);
		contentPane.add(btnNewButton_4);
	}
	
	public void login() {
		try{
			String user = JOptionPane.showInputDialog("Usuario?");
			String pass = JOptionPane.showInputDialog("Contraseña?");
			empresa.ingresar(user, pass);
			JOptionPane.showMessageDialog(null,"Bienvenido "+user);
		}
		catch (AccountException ex) {
			System.out.print("Credenciales Invalidas. "+ex.getMessage()+". Cerrando");
			System.exit(0);
		}
		/*
			System.out.println("Bienvenido");
		else
		{	System.out.println("Credenciales Invalidas. Cerrando");
			System.exit(0);
		}*/
	}
	private Empresa empresa;
	
	//private String path = System.getProperty("user.dir")+"\\"+"Datos.dat";
	String path = "C:\\Users\\geron\\Desktop\\Datos.txt";
	
	public void serializar() throws IOException {
		FileOutputStream file = null;
		ObjectOutputStream output = null;
		try {
			/*File f = new File(path);
			if(f.exists())
				f.delete();*/
			file = new FileOutputStream(path);
			output = new ObjectOutputStream(file);
			output.writeObject(empresa);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if (file != null)
				file.close();
		}
	}
	public Empresa deserializar() throws IOException, ClassNotFoundException, EOFException {
		Empresa emp = null;
		File f = new File(path);
		if(f.exists())
		{
			FileInputStream file = null;
			ObjectInputStream input = null;
			try {
				file = new FileInputStream(path);
				input = new ObjectInputStream(file);
				emp =  (Empresa)input.readObject();
			}
			catch (Exception ex)
			{ ex.printStackTrace(); }
			/*catch (EOFException eof){
				System.out.println("Error! Fin del fichero");
			}*/
			finally {
				if (file != null)
					file.close();
			}
		}
		else emp = new Empresa();
		
		return emp;
	}
}
