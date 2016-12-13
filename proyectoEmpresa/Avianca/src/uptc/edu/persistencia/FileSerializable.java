package uptc.edu.persistencia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




/**
 * @author leonardo
 *
 */
public class FileSerializable implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final long serialVersionVID = 4843023962527132889L;

	private File file;
	private String path;
	private String name;

	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void openFile(){
		
		file = new File(path+name);
		
	}
	
	public FileSerializable() {
		
	}
	public void writerSerializable(Object object) throws IOException{
		
		FileOutputStream fos = new FileOutputStream(file); 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(object);
		
		fos.close();
		oos.close();
		
	}	
	
	public Object readerSerializable() throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		
		fis.close();
		ois.close();
	
		return object;
		
	}
	
	
	
}
