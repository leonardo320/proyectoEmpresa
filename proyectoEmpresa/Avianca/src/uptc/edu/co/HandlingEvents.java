package uptc.edu.co;


 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author leonardo
 *
 */
public class HandlingEvents implements ActionListener, WindowListener, ListSelectionListener, KeyListener {
//en esta clase emparentamos todaslas clases principales para su correcto funcionamiento
//y utilizamos los escuchadores los llamadores de ventanas  llamadores de listas de seleccion y los listener de las teclas
//tambien en esta clase agregue los datos de el autor y la ayuda mostrando mi correo por si el usuario nececita saber algo sobre el programa de armamento
	public MainWindow mainWindow;
//	public Manage manageGun;


	public static final String EXIT = "salir";
	public static final String OPEN = "abrir";
	public static final String OPENPROD = "producto";
	public static final String SAVE = "salvar";
	public static final String ADD = "agregar";
	public static final String DELETE = "borrar";
	public static final String TEST = "prueba";
	public static final String ABOUT = "Acerca de";
	public static final String HELP = "ayuda";
	public static final String SORT_COD = "codigo";
	public static final String SORT_CODTWO = "descend";
	public static final String SORT_DESCRIPT = "descripcion";
	public static final String SORT_VALUE = "valor";
	public static final String CONSULTS = "consultas";
	public static final String DESCRIPTION = "Marca";
	public static final String VALUE = "Deporte";
	public static final String FIND_COD = "Referencia";

	public HandlingEvents(MainWindow mainWindow){

		this.mainWindow = mainWindow;
	}

	// Metodos De los ActionListener
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {

		
		int opcion = JOptionPane.showConfirmDialog(null, "Desea salir oprima si o en su defecto no", "Salir", JOptionPane.YES_NO_OPTION);
		if(opcion == JOptionPane.YES_OPTION){
			System.exit(0);
		}

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case EXIT: windowClosing(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
		break;

		case OPEN:

			mainWindow.openFile();
		
			break;

		case SAVE:

			mainWindow.saveFile();
	
			break;
			
		case OPENPROD:

			mainWindow.openFileprod();
	
			break;

		case ADD: 
			mainWindow.add();
			break;

		case DELETE:
			mainWindow.delete();
		
			break;
		
		

		case TEST: JOptionPane.showMessageDialog(null, "menu ejecutado");
		break;

		case ABOUT:
			JOptionPane.showMessageDialog(null," Taller  programacion 2 \n"
					+ "     Presentado por leonardo suarez  \n"
					+ "           a : ING Jairo  Riaño     \n"
					+ "               Ingenieria de sistemas    \n"
					+ "                   2015         ");
			break;

		case HELP:	 JOptionPane.showMessageDialog(null, 
			  "AUTOR:JORGE LEONARDO SUAREZ\n" +"EL ENTORNO ES MUY SENCILLO DE MANEJAR \n" +
				"LOS BOTONES DE BORRAR,AGREGAR,BUSCAR,TIENEN SUS RESPECTIVAS FUNCIONES \n" +
				"ES MUY AMIGABLE EL ENTORNO PARA UN USUARIO \n" +
				"SI TIENE ALGUNA DUDA DE EL PROGRAMA CONSULTE CON EL AUTOR EN ESTE CORREO \n" +
				"jorge.suarez02@uptc.edu.co \n" +
				"PROGRAMA HECHO EN JAVA ECLIPSE 3.8 \n");
		break;

	

		case DESCRIPTION:
			mainWindow.findClient();
			break;

		case VALUE:
			mainWindow.findFacture();
			break;

		case FIND_COD:
			mainWindow.findProduct();;
			break;


		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char n = e.getKeyChar();

		if(n < '0' || n > '9'){
			e.consume();
		}


	}
}
