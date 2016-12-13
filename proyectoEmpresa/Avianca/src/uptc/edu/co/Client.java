package uptc.edu.co;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Client extends JPanel implements ActionListener{
	private JTextField idClient;
	private JTextField name;
	private JTextField lastName;
	private JTextField phone;
	private JTextField address;
	private JTextField city;
	private JTextField age;
	private JButton adding;
	private JButton consult;
	private JButton delete;
	private JTextField genero;
	private ManFacCLient man;
	private JButton modifi;
	private JTable table;
	private JInternalFrame managamentUser;
	private JInternalFrame admin_cliente;
	private JInternalFrame Datos_cliente;
	private DefaultTableModel model;
private MainWindow mainWindow;




public Client(){
	
}
	

	public Client(MainWindow mainWindow){

		setLayout(null);
		this.mainWindow = mainWindow;	
		man=new ManFacCLient();
		String[] titulos={" ID ","NOMBRES","APELLIDOS","TELEFONO","GENERO","EDAD","EMAIL","CIUDAD"};
		model = new DefaultTableModel(titulos,0);
		table= new JTable(model);
		table.setSize(500,800);

//		this.setModel(model);
		begin();
		addComponents();


	}

	public JTextField getIdClient() {
		return idClient;
	}



	public void setIdClient(JTextField idClient) {
		this.idClient = idClient;
	}



		public void setModel(DefaultTableModel model) {
			this.model = model;
		}
		


		public JTable getTable() {
			return table;
		}



	public DefaultTableModel getModel() {
		return model;
	}

	public void	begin(){

		idClient = new JTextField();
		idClient.setColumns(10);
		idClient.setBounds(80, 53, 179, 19);
		idClient.addKeyListener(mainWindow.getEvents());

		name = new JTextField();
		name.setBounds(80, 85, 179, 19);


		lastName = new JTextField();
		lastName.setBounds(80, 121, 179, 19);


		phone = new JTextField();
		phone.setBounds(80, 157, 179, 19);

		address = new JTextField();
		address.setBounds(80, 193, 179, 19);

		city = new JTextField();
		city.setBounds(80, 226, 179, 19);
		
		age = new JTextField();
		age.setBounds(80, 250, 179, 19);
		
		genero = new JTextField();
		genero.setBounds(80, 280, 179, 19);


		adding = new JButton("Insertar Cliente");
		adding.setBounds(12, 46, 152, 25);
		adding.addActionListener(this);

		consult = new JButton("Buscar");
		consult.setBounds(176, 46, 117, 25);
		consult.addActionListener(this);

		modifi = new JButton("Modificar");
		modifi.setBounds(305, 46, 117, 25);

		delete = new JButton("Eliminar");
		delete.setBounds(434, 46, 117, 25);
		delete.addActionListener(this);

		String[] titulos={" ID ","NOMBRE ","APELLIDO","TELEFONO","EMAIL","CIUDAD","EDAD","GENERO"};
		model = new DefaultTableModel(titulos,0);
		table= new JTable(model);

		managamentUser = new JInternalFrame("Geston Cliente");
		managamentUser.setBounds(12, 12, 285, 400);
		managamentUser.setResizable(true);
		managamentUser.getContentPane().setLayout(null);

		admin_cliente = new JInternalFrame("Acciones");
		admin_cliente.setBounds(102, 500, 588, 121);

		admin_cliente.getContentPane().setLayout(null);
		admin_cliente.setResizable(true);

		Datos_cliente = new JInternalFrame("Datos Cliente");
		Datos_cliente.setBounds(312, 12, 500, 400);

		Datos_cliente.getContentPane().setLayout(null);
		Datos_cliente.setResizable(true);

	}



	public void addComponents(){

		add(managamentUser);

		JLabel lblNombre = new JLabel("ID");
		lblNombre.setBounds(12, 55, 70, 15);
		managamentUser.getContentPane().add(lblNombre);

		managamentUser.getContentPane().add(idClient);

		JLabel lblGestionCliente = new JLabel("GESTION CLIENTE");
		lblGestionCliente.setBounds(61, 12, 123, 15);
		managamentUser.getContentPane().add(lblGestionCliente);
		managamentUser.setMaximizable(true);
		managamentUser.setClosable(true);

		JLabel lblApellido = new JLabel("Nombre");
		lblApellido.setBounds(12, 87, 70, 15);
		managamentUser.getContentPane().add(lblApellido);

		managamentUser.getContentPane().add(name);
		name.setColumns(10);

		JLabel lblId = new JLabel("Apellido");
		lblId.setBounds(12, 123, 70, 15);
		managamentUser.getContentPane().add(lblId);

		managamentUser.getContentPane().add(lastName);
		lastName.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 159, 70, 15);
		managamentUser.getContentPane().add(lblTelefono);

		managamentUser.getContentPane().add(phone);
		phone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 195, 70, 15);
		managamentUser.getContentPane().add(lblEmail);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(12, 228, 70, 15);
		managamentUser.getContentPane().add(lblCiudad);
		
		JLabel edad = new JLabel("Edad");
		edad.setBounds(12, 270, 70, 15);
		managamentUser.getContentPane().add(edad);
		
		JLabel lbgenero = new JLabel("Genero");
		lbgenero.setBounds(12, 290, 70, 15);
		managamentUser.getContentPane().add(lbgenero);

		managamentUser.getContentPane().add(address);
		address.setColumns(10);

		managamentUser.getContentPane().add(city);
		city.setColumns(10);
		
		managamentUser.getContentPane().add(age);
		age.setColumns(10);
		
		managamentUser.getContentPane().add(genero);
		genero.setColumns(10);

		add(admin_cliente);

		JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione Una opcion o accion a realizar");
		lblSeleccioneUnaOpcion.setBounds(0, 0, 578, 15);
		admin_cliente.getContentPane().add(lblSeleccioneUnaOpcion);


		admin_cliente.getContentPane().add(adding);

		admin_cliente.getContentPane().add(consult);

		admin_cliente.getContentPane().add(modifi);

		admin_cliente.getContentPane().add(delete);

		add(Datos_cliente);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 457, 272);
		Datos_cliente.getContentPane().add(scrollPane);

		Datos_cliente.setVisible(true);
		admin_cliente.setVisible(true);
		managamentUser.setVisible(true);

	}








	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(adding)) {
			System.out.println("paletillassss");
			addin();
		}
		if (e.getSource().equals(delete)) {
			deleteG();
		}
         if (e.getSource().equals(consult)) {
        	 findderCode();
			
		}

	}
	public void addin(){
		String id = idClient.getText(); 
		System.out.println(id);
		String nam = name.getText();
		String last = lastName.getText();
		String phon= phone.getText(); 
		String addres=address.getText();
		String cit=city.getText();

		if (idClient.getText().length()>0&&name.getText().length()>0&&lastName.getText().length()>0&&phone.getText().length()>0&&address.getText().length()>0&&city.getText().length()>0){	
			System.out.println("Wntro");
			if(mainWindow.getGestmManage().addCli(id, nam, last, phon,addres,cit)){
				JOptionPane.showMessageDialog(null, "Cliente agregado", "Agregacion", JOptionPane.INFORMATION_MESSAGE);

				Object[] record= {id, nam, last, phon,addres,cit};
				((DefaultTableModel) mainWindow.getPanel2().getTable().getModel()).addRow(record);
         System.out.println(record);
			}
			else{
				JOptionPane.showMessageDialog(null, "No Agrego", "Error",JOptionPane.ERROR_MESSAGE);
			}

		}

		else{
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}
	}

	private void deleteG(){
System.out.println("Eliminacionnnn");
		String code = idClient.getText();
		code=JOptionPane.showInputDialog("Digite el codigo a eliminar");

		if(idClient.getText().length() > 0){
			if(mainWindow.getGestmManage().delete(code) != null){
				JOptionPane.showMessageDialog(null, "Cliente Eliminado.....", "Delete", JOptionPane.INFORMATION_MESSAGE);
				mainWindow.refreshTable();
			}
			else{
				JOptionPane.showMessageDialog(null, "No Existe el cliente", "vacio", JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, ""
					+ "Campos Vacios!!!...", "Campos Vacios", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void findderCode() {
System.out.println("Busquedaaaaa");
		String code = idClient.getText();
         code=JOptionPane.showInputDialog("Digite el codigo del dato que desea buscar");
		if(idClient.getText().length() > 0){
			if(mainWindow.getGestmManage().findDocument(code) != null){

				for (int i = 0; i < mainWindow.getGestmManage().getGuntz().size(); i++) {
					if(mainWindow.getGestmManage().getGuntz().get(i).getIdClient().equalsIgnoreCase(code)){
						JOptionPane.showMessageDialog(null, "Cliente encontrado Exitosamente", "Busqueda", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "descripcion: " + man.getGuntz().get(i).getName(), "Nombre", JOptionPane.INFORMATION_MESSAGE);
						idClient.setText(String.valueOf(""));

						int option= JOptionPane.showConfirmDialog(null, "Desea modificar el Arma?", "Modificar", JOptionPane.YES_NO_OPTION);
						if (option== JOptionPane.YES_NO_OPTION) {
							mainWindow.getGestmManage().getGuntz().remove(i);
							mainWindow.refreshTable();
							
							
						}
					}

				}	

			}

			else{
				JOptionPane.showMessageDialog(null, "No Existe!!!...", "No Existe", JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Hay Campos Vacios!!!...", "Campos Vacios", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}




