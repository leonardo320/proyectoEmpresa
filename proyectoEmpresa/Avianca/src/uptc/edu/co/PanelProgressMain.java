package uptc.edu.co;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class PanelProgressMain {

	PanelProgress screen; 

	// Methods------------------------------------------------------------------
	public PanelProgressMain() {
		inicioPantalla();
		screen.velocidadDeCarga();
		
	}

	private void inicioPantalla() {
		ImageIcon myImage = new ImageIcon("resources/images/persona.png");
		screen = new PanelProgress(myImage);
		screen.setLocationRelativeTo(null);
		screen.setProgresoMax(100);
		screen.setVisible(true);
	}

	// Run Program---------------------------------------------------------------
	public static void main(String[] args)
	{
		UserLogin window = new UserLogin();
		
		// Aca esta una forma de cambiar la apariencia de los bordes del JFrame.
		window.setDefaultLookAndFeelDecorated(true);

		new PanelProgressMain();
		window.main();
	}
}
