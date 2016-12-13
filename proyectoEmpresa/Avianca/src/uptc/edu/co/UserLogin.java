package uptc.edu.co;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


import uptc.edu.persistencia.*;


/**
 * @author leonardo
 *
 */

/**
 * 
 *
 */
public class UserLogin extends JDialog implements ActionListener {
	//en esta clase implementamos el usuario exendiendo un jdialog
	//	mostrando el mensaje para que el usuario verifique bien sus datos
	//	antes de ingresarlos ya que solo tiene 3 intentos utilizamos un
	//	contador para esto y mostramos un mensaje ya cuando el usuario ha fallado los 3 intentos



	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel login;
	private JButton registrar;
	private JButton btnAcept;
	private JButton btnCancel;
	private MainWindow jtabbed;
	private LogicProperties lp;
	private int cont=0;
	private MainWindow tabePane;
	Font fuente=new Font("Dialog", Font.BOLD, 19);



	/**
	 * este es el constructor para el usuario
	 *en donde agrego un icono en un jradio no es funcional pero lo utilice para poner la imagen de un usuario
	 */


	public UserLogin(){

		//		JOptionPane.showMessageDialog(null, "Tiene solo 3 intentos para entrar al sistema verifique bien su usuario y contraseña");
		this.getContentPane();
		setSize(300,400);
		setResizable(false);
		setTitle("Login user");
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		beginComponents();
		addComponents();

	}


	public static void main1 (String[]args){
		UserLogin u = new UserLogin();	
		u.setVisible(true);



	}

	private void beginComponents() {


		jtabbed = new MainWindow();

		lp = new LogicProperties();

		//login = new JLabel(new ImageIcon("Resource/icon/crane.gif"));
		//login.setBounds(100, 250, 100, 100);


		txtUser = new JTextField();
		txtUser.setFont(fuente);
		txtUser.setBounds(180, 30, 100, 40);

		txtPass = new JPasswordField();
		txtPass.setFont(fuente);
		txtPass.setBounds(180, 90, 100, 40);

		registrar = new JButton("Registrar");
		registrar.setBounds(40, 280, 100, 40);


		btnAcept = new JButton("Aceptar");
		btnAcept.setBounds(10, 200, 100, 40);
		btnAcept.addActionListener(this);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(180, 200, 100, 40);
		btnCancel.addActionListener(this);


	}

	private void addComponents() {
		// TODO Auto-generated method stub

		JLabel lblGestionCliente = new JLabel("Usuario :");
		lblGestionCliente.setFont(fuente);
		lblGestionCliente.setBounds(10, 30, 100, 40);

		add(lblGestionCliente);
		add(txtUser);
		JLabel lblGestion = new JLabel("Contraseña :");
		lblGestion.setFont(fuente);
		lblGestion.setBounds(10, 90, 150, 40);
		add(lblGestion);
		add(txtPass);
		//		add(login);
		add(btnAcept);
		add(btnCancel);
		JLabel lblreg =new JLabel("Si no te has registrado has clic aqui");
		lblreg.setBounds(20, 210, 300, 100);
		add(lblreg);
		add(registrar);
		JLabel lblGes = new JLabel("IMPORTANTE:Solo tiene 3 intentos");
		lblGes.setBounds(10, 300, 300, 100);
		add(lblGes);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAcept){
			if(lp.pro(txtUser.getText(), txtPass.getText())){
				tabePane.main();
				this.setVisible(false);
			}
			else if (cont<2) {
				cont=cont+1;
				JOptionPane.showMessageDialog(null, "Error contraseña");
			}
			else {
				JOptionPane.showMessageDialog(null, "ha fallado 3 intentos hasta luego");
				this.dispose();
			}

		}

		else{
			System.exit(0);
		}



	}
	public JTextField getTxtUser() {
		return txtUser;
	}

	public JTextField getTxtPass() {
		return txtPass;
	}

	public static void main (){
		UserLogin u = new UserLogin();		
		u.setVisible(true);

	}
	
	
}