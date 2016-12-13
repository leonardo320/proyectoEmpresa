package uptc.edu.co;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import uptc.edu.persistencia.FactCli;

import com.toedter.calendar.JCalendar;



public class Facture  extends JPanel implements ActionListener{
	private MainWindow main;
	private JTextField number;
	private JTextField details;
	private JCalendar dateill;
	private JButton save;
	private JButton consult;
	private JButton delete;
	private JButton modifi;
	private ManFacCLient mana;
	private Client client;
	private JComboBox clients;
	private JComboBox<Typepay> tipepays;
	private JComboBox<Reserva>products;
    private MainWindow mainWindow;
	private JTable table;
	private JInternalFrame managamentUser;
	private JInternalFrame admin_facture;
	private JInternalFrame datos_facture;

	private DefaultTableModel model;
	
	public Facture(MainWindow mainWindow){
		setLayout(null);
		this.mainWindow = mainWindow;
	
	
	
	
		begin();
		addComponents();
	}


	public JCalendar getDateill() {
		return dateill;
	}


	public void setDateill(JCalendar dateill) {
		this.dateill = dateill;
	}


	private void begin() {
		// TODO Auto-generated method stub
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(80, 53, 179, 19);
		
		dateill = new JCalendar();
		dateill.setBounds(80, 85, 300, 190);
		

		details = new JTextField();
		details.setBounds(80, 121, 179, 19);
		
		clients = new JComboBox();
		
		clients.setBounds(80, 157, 179, 19);
	
	
	
//		
		
		
		
		tipepays = new JComboBox<Typepay>();
		tipepays.setBounds(80, 193, 179, 19);
		
		products = new JComboBox<Reserva>();
		products.setBounds(80, 226, 179, 19);
		
		save = new JButton("agregar tickete");
		save.setBounds(12, 46, 152, 25);
		save.addActionListener(this);
			
		consult = new JButton("Buscar");
		consult.setBounds(176, 46, 117, 25);
		
		modifi = new JButton("Modificar");
		modifi.setBounds(305, 46, 117, 25);
		
		delete = new JButton("Eliminar");
		delete.setBounds(434, 46, 117, 25);
		
		String[] titulos={" NUMERO","FECHA","DETALLE","CLIENTE","PAGO","TIPO DE RESERVA"};
		model = new DefaultTableModel(titulos,0);

		table= new JTable(model);
		
		managamentUser = new JInternalFrame("Geston TICKETE");
		managamentUser.setBounds(12, 12, 285, 316);
		managamentUser.setResizable(true);
		managamentUser.getContentPane().setLayout(null);
		
		admin_facture = new JInternalFrame("Acciones");
		admin_facture.setBounds(10, 338, 588, 300);

		admin_facture.getContentPane().setLayout(null);
		admin_facture.setResizable(true);

		datos_facture = new JInternalFrame("Datos TICKETE");
		datos_facture.setBounds(312, 12, 490, 316);
		
		datos_facture.getContentPane().setLayout(null);
		datos_facture.setResizable(true);
		
	}


	private void addComponents() {
		add(managamentUser);
		
		JLabel numfact = new JLabel("#TICKETE");
		numfact.setBounds(12, 55, 70, 15);
		managamentUser.getContentPane().add(numfact);

		managamentUser.getContentPane().add(number);

		JLabel lblGestfact = new JLabel("GESTION TICKETE");
		lblGestfact.setBounds(61, 12, 123, 15);
		managamentUser.getContentPane().add(lblGestfact);
		managamentUser.setMaximizable(true);
		managamentUser.setClosable(true);

		JLabel date = new JLabel("Fecha");
		date.setBounds(12, 87, 70, 15);
		admin_facture.getContentPane().add(date);

		admin_facture.getContentPane().add(dateill);
//		dateill.setColumns(10);

		JLabel lblId = new JLabel("Detallle");
		lblId.setBounds(12, 123, 70, 15);
		managamentUser.getContentPane().add(lblId);

		managamentUser.getContentPane().add(details);
		details.setColumns(10);

		JLabel lblTelefono = new JLabel("Clientes");
		lblTelefono.setBounds(12, 159, 70, 15);
		managamentUser.getContentPane().add(lblTelefono);

		managamentUser.getContentPane().add(clients);
//		clients.setColumns();

		JLabel lblEmail = new JLabel("Tipo de pago");
		lblEmail.setBounds(12, 195, 70, 15);
		managamentUser.getContentPane().add(lblEmail);

		JLabel lblCiudad = new JLabel("tipo reserva");
		lblCiudad.setBounds(12, 228, 70, 15);
		managamentUser.getContentPane().add(lblCiudad);


		managamentUser.getContentPane().add(tipepays);
//		tipepays.setColumns(10);

		managamentUser.getContentPane().add(products);
//		products.setColumns(10);

		add(admin_facture);
		
		JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione Una opcion o accion a realizar");
		lblSeleccioneUnaOpcion.setBounds(0, 0, 578, 15);
		admin_facture.getContentPane().add(lblSeleccioneUnaOpcion);

		
		admin_facture.getContentPane().add(save);

		admin_facture.getContentPane().add(consult);

		admin_facture.getContentPane().add(modifi);

		admin_facture.getContentPane().add(delete);
		
		

		add(datos_facture);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 457, 272);
		datos_facture.getContentPane().add(scrollPane);

		datos_facture.setVisible(true);
		admin_facture.setVisible(true);
		managamentUser.setVisible(true);
		
		

		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(save)) {
			
			
				
			}
	}
	
}
		
	
	
	
	
	

