package uptc.edu.co;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;








/**
 * @author leonardo
 *
 */
public class MainMenu extends JMenuBar {
//en esta clase se utiliza para crear los menus extendiendolo a jmenu bar
//aca se llaman las opciones que estan en el handlingevents
//	utilizamos jmenuitem para los items que van en los menus como el de abrir guardar entre otros
//en cada menu llamamos los iconos respectivos a cada funcion de el programa de armamento	
	private JMenu file;
	private JMenu consult;
	private JMenu help;
	private JMenu sorter;
	private JMenu finder;
	private JMenuItem open;
	private JMenuItem openprod;
	private JMenuItem save;
	private JMenuItem exit;
	private JMenuItem addObject;
	private JMenuItem deleteObject;
	
	
	private JMenuItem about;
	private JMenuItem helpp;
	
	private JMenuItem findDescription;
	private JMenuItem findValue;
	private JMenuItem findCode;
	
	private JMenuItem sortCode;
	private JMenuItem sortDescription;
	private JMenuItem sortValue;

	private MainWindow tabbedPane;

	public MainMenu(MainWindow tabbedPane){

		this.tabbedPane = tabbedPane;
		beginComponents();
		addComponents();

	}

	
	public void addComponents(){

		file.add(open);
		file.add(openprod);
		file.add(save);
		file.addSeparator();
		file.add(addObject);
		file.add(deleteObject);
		file.add(sorter);
		file.add(findDescription);
		file.add(findValue);
		file.add(findCode);
		file.addSeparator();
		file.add(exit);

		
		consult.add(finder);
		
		sorter.add(sortCode);
		sorter.add(sortDescription);
		sorter.add(sortValue);
		
		finder.add(findCode);
		finder.add(findDescription);
		finder.add(findValue);
		
		
	
		
		help.add(helpp);
		help.add(about);
		
		add(file);
		add(consult);
		add(help);
	}

	private void beginComponents() {


		file = new JMenu("Archivo");
		file.setMnemonic('A');

		consult = new JMenu("Consulta");
		consult.setMnemonic('O');

		help = new JMenu("Ayuda");
		help.setMnemonic('Y');

		
		open = new JMenuItem("Abrir cliente");
		open.setMnemonic('R');
		open.setIcon(new ImageIcon("Resources/Icons/open.jpg"));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		open.setActionCommand(HandlingEvents.OPEN);
		open.addActionListener(tabbedPane.getEvents());
		
		
		openprod = new JMenuItem("Abrir reservas");
		openprod.setMnemonic('R');
		openprod.setIcon(new ImageIcon("Resources/Icons/open.jpg"));
		openprod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		openprod.setActionCommand(HandlingEvents.OPENPROD);
		openprod.addActionListener(tabbedPane.getEvents());
		

		
		save = new JMenuItem("Guardar");
		save.setMnemonic('G');
		save.setIcon(new ImageIcon("Resources/Icons/save.jpg"));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		save.setActionCommand(HandlingEvents.SAVE);
		save.addActionListener(tabbedPane.getEvents());
		
		addObject = new JMenuItem("Agregar");
		addObject.setMnemonic('A');
		addObject.setIcon(new ImageIcon("Resources/Icons/adding.png"));
		addObject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		addObject.setActionCommand(HandlingEvents.ADD);
		addObject.addActionListener(tabbedPane.getEvents());
		
		deleteObject = new JMenuItem("Borrar ");
		deleteObject.setMnemonic('B');
		deleteObject.setIcon(new ImageIcon("Resources/Icons/delete.png"));
		deleteObject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		deleteObject.setActionCommand(HandlingEvents.DELETE);
		deleteObject.addActionListener(tabbedPane.getEvents());
		
		
		
		exit = new JMenuItem("Salir");
		exit.setMnemonic('S');
		exit.setIcon(new ImageIcon("Resources/Icons/exit.png"));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		exit.setActionCommand(HandlingEvents.EXIT);
		exit.addActionListener(tabbedPane.getEvents());
		
		finder = new JMenu("Buscar");
		finder.setMnemonic('U');
		finder.setIcon(new ImageIcon("Resources/Icons/search.jpg"));		
		
		sortCode = new JMenuItem("Codigo");
		sortCode.setMnemonic('C');
		sortCode.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		sortCode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		sortDescription = new JMenuItem("Descripcion");
		sortDescription.setMnemonic('D');
		sortDescription.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		sortDescription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		
		sortValue = new JMenuItem("Valor");
		sortValue.setMnemonic('V');
		sortValue.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		sortValue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		sorter = new JMenu("Ordenar");
		sorter.setMnemonic('R');
		sorter.setIcon(new ImageIcon("Resources/Icons/ordenar.png"));
		
	
		findCode = new JMenuItem("Codigo");
		findCode.setMnemonic('C');
		findCode.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		findCode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
//		---------------------------------------------------------------------------------------------
		findDescription = new JMenuItem("Descripcion");
		findDescription.setMnemonic('D');
		findDescription.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		findDescription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		
//		--------------------------------------------------------------------------------------------
		findValue = new JMenuItem("Valor");
		findValue.setMnemonic('V');
		findValue.setIcon(new ImageIcon("Resources/Icons/gun.png"));
		findValue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		
		helpp = new JMenuItem("Ayuda");
		helpp.setMnemonic('A');
		helpp.setIcon(new ImageIcon("Resources/Icons/help.png"));
		helpp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		helpp.setActionCommand(HandlingEvents.HELP);
		helpp.addActionListener(tabbedPane.getEvents());
		
		
		about = new JMenuItem("Acerca de......");
		about.setMnemonic('A');
		about.setIcon(new ImageIcon("Resources/Icons/arma.png"));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		about.setActionCommand(HandlingEvents.ABOUT);
		about.addActionListener(tabbedPane.getEvents());

		

	}

}
