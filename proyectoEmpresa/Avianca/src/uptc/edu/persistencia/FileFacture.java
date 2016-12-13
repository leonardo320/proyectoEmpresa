
  
 
package uptc.edu.persistencia;

import java.io.IOException;





/**
 * @author leonardo
 *
 */
import uptc.edu.co.ManFacCLient;

public class FileFacture extends FileSerializable {

/**
	 * 
	 */


	//	
//	
//	
	public void  writer(ManFacCLient mb) throws IOException{
		
		writerSerializable(mb);
		
		
	}
	
	public ManFacCLient reader () throws ClassNotFoundException, IOException {
		
		ManFacCLient mc = (ManFacCLient)readerSerializable();
		
		return mc; 
	}
	


}
