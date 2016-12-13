package uptc.edu.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;



/**
 * @author leonardo
 *
 */
public class LogicProperties {
//aqui se encuentra la logica de properties
//	validando la clave
//	
//	
//	
	Scanner sc = new Scanner(System.in);


    public boolean pro(String usuarioS, String claveS){
    	boolean isIngres=false;
    	String usuario="";
		String clave="";

		clave = claveS;
		usuario = usuarioS;

		Properties propiedades = new Properties();
		InputStream entrada = null;

		try {

			entrada = new FileInputStream("./Resource/file/Usuarios.properties/");

			propiedades.load(entrada);
			
			if(clave.equals(propiedades.getProperty(usuario))){
				isIngres=true;
			}else{
				JOptionPane.showMessageDialog(null, "Password incorrecto o Usuario Incorrecto");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return isIngres;
    }
}
