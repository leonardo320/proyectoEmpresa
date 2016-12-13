package uptc.edu.co;


import java.awt.*;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;import java.awt.event.WindowListener;import java.io.File;import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;




import uptc.edu.persistencia.FactCli;
import uptc.edu.persistencia.ProdCli;
import uptc.edu.co.ManFacCLient;








public class MainWindow extends 	JFrame 
{

	private		JTabbedPane tabbedPane;
	
	private		Client		panel2;
	
	



	private		Welcome		panel1;
	private		Facture		panel3;
	private     Reserva      panel4;
	private     MainMenu    mainMenu;
	private     ManFacCLient       gestmManage;
	
	private HandlingEvents events;

	
	public Facture getPanel3() {
		return panel3;
	}



	public void setPanel3(Facture panel3) {
		this.panel3 = panel3;
	}



	public Reserva getPanel4() {
		return panel4;
	}



	public void setPanel4(Reserva panel4) {
		this.panel4 = panel4;
	}



	public Client getPanel2() {
		return panel2;
	}



	public void setPanel2(Client panel2) {
		this.panel2 = panel2;
	}

	public ManFacCLient getGestmManage() {
		return gestmManage;
	}



	public void setGestmManage(ManFacCLient gestmManage) {
		this.gestmManage = gestmManage;
	}



	public MainWindow()
	{
		
		setTitle( "AEROLINEA" );
	setExtendedState(MAXIMIZED_BOTH);
		setBackground( Color.GREEN );
         setResizable(true);
		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();
        createPage4(); 
        begin();
        cursor();
		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "GESTION AEROLINEA", panel1 );
		tabbedPane.addTab( "Cliente", panel2 );
		tabbedPane.addTab( "Factura", panel3 );
		tabbedPane.addTab( "Reserva", panel4 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}

	

	public MainMenu getMainMenu() {
		return mainMenu;
	}







	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}






	public HandlingEvents getEvents() {
		return events;
	}







	public void setEvents(HandlingEvents events) {
		this.events = events;
	}







	public void createPage1()
	{
		
		panel1 = new Welcome(this);
		panel1.setBackground(Color.BLACK);
//		Image image = new ImageIcon("Resource/icon/mouse.gif").getImage();
//		panel1.paint(image.getGraphics());
//		panel1.print(image.getGraphics());
		
		 
	}


	public void createPage2()
	{
		panel2 = new Client(this);
		panel2.setBounds(0, 0, 300, 300);
		panel2.setBackground(Color.BLUE);
				
		
	}

	public void createPage3()
	{
		panel3 = new Facture(this);
		panel3.setBackground(Color.BLUE);
		
	}

	private void createPage4() {
		// TODO Auto-generated method stub
		panel4 = new Reserva(this);
		panel4.setBackground(Color.BLUE);
	
		

		
	}
	private void cursor(){
		function func=new function();
		func.MousePointer(this);
		
	}
	
	private void begin() {

		beginComponents();
		addComponents();

	}

	private void beginComponents(){

		events = new HandlingEvents(this);
		mainMenu = new MainMenu(this);	
		gestmManage=new ManFacCLient();
		this.addWindowListener(events);
		

	}

	private void addComponents(){

		this.setJMenuBar(mainMenu);
		
		
		
	}

	
    // Main method to get things started
	public static void main()
	{
		// Create an instance of the test application
		MainWindow mainFrame	= new MainWindow();
	
		mainFrame.setVisible( true );
	}



	public void openFile() {
		System.out.println("Abrir");
		JFileChooser chooser = new JFileChooser("./Resource/file/");
		File file = null;
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
			String path = file.getParent() + "/";
			String name = file.getName();
			try{
			
				gestmManage=gestmManage.readClient(path, name);
				refreshTable();
				
			}catch(ClassNotFoundException | IOException e){
				e.printStackTrace();
			}
		}
	}

	public void openFileprod() {
		System.out.println("Abrir");
		JFileChooser chooser = new JFileChooser("./Resource/file/");
		File file = null;
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
			String path = file.getParent() + "/";
			String name = file.getName();
			try{
			
				gestmManage=gestmManage.readClient(path, name);
				refreshTableprod();
				
			}catch(ClassNotFoundException | IOException e){
				e.printStackTrace();
			}
		}
	}



	public void saveFile() {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser("./Resource/file/");
		File file = null;
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
			String path = file.getParent() + "/";
			String name = file.getName();
		
			try {
				System.out.println("Guardando");
				gestmManage.saveGun(path, name);
				
				
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Error de I/O","Error",JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}


	public void add() {
		// TODO Auto-generated method stub
		
	}
	public void refreshTable(){
		while(panel2.getTable().getModel().getRowCount()>0){
			((DefaultTableModel) panel2.getTable().getModel()).removeRow(0);
		}
		for(FactCli data:gestmManage.getGuntz()){

			String id=data.getIdClient();
			String nam=data.getName();
			String last=data.getLastName();
			String pho= data.getPhone();
			String add=data.getAddress();
			String cit=data.getCity();
		{
		
			Object[] rowData={id , nam, last,pho,add,cit};
			((DefaultTableModel) panel2.getTable().getModel()).addRow(rowData);
			
			
		}
	}
	}

	public void refreshTableprod(){
		while(panel4.getTable().getModel().getRowCount()>0){
			((DefaultTableModel) panel4.getTable().getModel()).removeRow(0);
		}
		for(ProdCli data:gestmManage.getProd()){

			String id=data.getIdProduc();
			String des=data.getDescription();
			String val=data.getValue();
			String st= data.getStock();
			String iv=data.getIva();
			
		{
		
			Object[] rowData={id , des, val,st,iv};
			((DefaultTableModel) panel4.getTable().getModel()).addRow(rowData);
			
			
		}
	}
	}
	
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Borrado");
		if(panel2.getTable().getSelectedRow()>=0){
			if(gestmManage.delete(gestmManage.getGuntz().get(panel2.getTable().getSelectedRow()).getIdClient()) != null){
					JOptionPane.showMessageDialog(null, "Arma Eliminada.....", "Delete", JOptionPane.INFORMATION_MESSAGE);
					refreshTable();
				}
				else{
					JOptionPane.showMessageDialog(null, "No Existe en el arma", "vacio", JOptionPane.WARNING_MESSAGE);
				}
		}
		else{
		
		}
		
	}



	public void findClient() {
		// TODO Auto-generated method stub
		
	}



	public void findFacture() {
		// TODO Auto-generated method stub
		
	}



	public void findProduct() {
		// TODO Auto-generated method stub
		
	}


	
	 
  
	
	

	


	
}