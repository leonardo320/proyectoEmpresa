package uptc.edu.co;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Reserva extends JPanel implements ActionListener {
	private JTextField idProduc;
	private JTextField description;
	private JTextField value;
	private JTextField stock;
	private JTextField iva;
	private JButton adding;
	private JButton consult;
	private JButton delete;
	private JButton modifi;
	private Client cient;
	private JTable table;
	private JInternalFrame managamentUser;
	private JInternalFrame admin_cliente;
	private JInternalFrame Datos_cliente;
	private DefaultTableModel model;
	private ManFacCLient man;
	
	
	

	
	private JButton  save;
	
	
	private MainWindow mainWindow;
	
	
	
	
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public Reserva(MainWindow mainWindow){
		
		setLayout(null);
		this.mainWindow = mainWindow;	
		man=new ManFacCLient();
		begin();
		addComponents();

		
	}
public void	begin(){
	
	
	
	idProduc = new JTextField();
	idProduc.setBounds(80, 85, 179, 19);
	

	description = new JTextField();
	description.setBounds(80, 121, 179, 19);
	

	value = new JTextField();
	value.setBounds(80, 157, 179, 19);
	
	stock = new JTextField();
	stock.setBounds(80, 193, 179, 19);
	
	iva = new JTextField();
	iva.setBounds(80, 226, 179, 19);
	
	adding = new JButton("reservar");
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
	
	
	String[] titulos={" IDRESERV ","DESCRIPCION","VALOR","CANTIDAD","IVA"};
	model = new DefaultTableModel(titulos,0);

	table= new JTable(model);
	
	managamentUser = new JInternalFrame("Geston Producto");
	managamentUser.setBounds(12, 12, 285, 316);
	managamentUser.setResizable(true);
	managamentUser.getContentPane().setLayout(null);
	
	admin_cliente = new JInternalFrame("Acciones");
	admin_cliente.setBounds(102, 338, 588, 121);

	admin_cliente.getContentPane().setLayout(null);
	admin_cliente.setResizable(true);

	Datos_cliente = new JInternalFrame("Datos Producto");
	Datos_cliente.setBounds(312, 12, 467, 316);
	
	Datos_cliente.getContentPane().setLayout(null);
	Datos_cliente.setResizable(true);

	}
public void addComponents(){
	
	add(managamentUser);

	JLabel lblGestionCliente = new JLabel("GESTION PRODUCTO");
	lblGestionCliente.setBounds(61, 12, 123, 15);
	managamentUser.getContentPane().add(lblGestionCliente);
	managamentUser.setMaximizable(true);
	managamentUser.setClosable(true);

	JLabel lblApellido = new JLabel("ID");
	lblApellido.setBounds(12, 87, 70, 15);
	managamentUser.getContentPane().add(lblApellido);

	managamentUser.getContentPane().add(idProduc);
	idProduc.setColumns(10);

	JLabel lblId = new JLabel("Descripcion");
	lblId.setBounds(12, 123, 70, 15);
	managamentUser.getContentPane().add(lblId);

	managamentUser.getContentPane().add(description);
	description.setColumns(10);

	JLabel lblTelefono = new JLabel("Valor");
	lblTelefono.setBounds(12, 159, 70, 15);
	managamentUser.getContentPane().add(lblTelefono);

	managamentUser.getContentPane().add(value);
	value.setColumns(10);

	JLabel lblEmail = new JLabel("STOCK");
	lblEmail.setBounds(12, 195, 70, 15);
	managamentUser.getContentPane().add(lblEmail);

	JLabel lblCiudad = new JLabel("IVA");
	lblCiudad.setBounds(12, 228, 70, 15);
	managamentUser.getContentPane().add(lblCiudad);


	managamentUser.getContentPane().add(stock);
	stock.setColumns(10);

	managamentUser.getContentPane().add(iva);
	iva.setColumns(10);

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
public void addin(){
	String id = idProduc.getText(); 
	System.out.println(id);
	String nam = description.getText();
	String last = value.getText();
	String phon= stock.getText(); 
	String addres=iva.getText();
	

	if (idProduc.getText().length()>0&&description.getText().length()>0&&value.getText().length()>0&&stock.getText().length()>0&&iva.getText().length()>0){	
		System.out.println("Wntro");
		if(mainWindow.getGestmManage().addProd(id, nam, last, phon,addres)){
			JOptionPane.showMessageDialog(null, "Cliente agregado", "Agregacion", JOptionPane.INFORMATION_MESSAGE);

			Object[] record= {id, nam, last, phon,addres};
			((DefaultTableModel) mainWindow.getPanel4().getTable().getModel()).addRow(record);
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
	String code = idProduc.getText();
	code=JOptionPane.showInputDialog("Digite el codigo a eliminar");

	if(idProduc.getText().length() > 0){
		if(man.delete(code) != null){
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
	String code = idProduc.getText();
     code=JOptionPane.showInputDialog("Digite el codigo del dato que desea buscar");
	if(idProduc.getText().length() > 0){
		if(man.findDocument(code) != null){

			for (int i = 0; i < man.getGuntz().size(); i++) {
				if(man.getGuntz().get(i).getIdClient().equalsIgnoreCase(code)){
					JOptionPane.showMessageDialog(null, "Cliente encontrado Exitosamente", "Busqueda", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "descripcion: " + man.getGuntz().get(i).getName(), "Nombre", JOptionPane.INFORMATION_MESSAGE);
					idProduc.setText(String.valueOf(""));

					int option= JOptionPane.showConfirmDialog(null, "Desea modificar el Arma?", "Modificar", JOptionPane.YES_NO_OPTION);
					if (option== JOptionPane.YES_NO_OPTION) {
						man.getGuntz().remove(i);
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


}








