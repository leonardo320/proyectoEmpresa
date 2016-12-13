package uptc.edu.co;



import java.io.IOException;import java.io.Serializable;import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import uptc.edu.persistencia.FactCli;
import uptc.edu.persistencia.FileFacture;
import uptc.edu.persistencia.ProdCli;






public class ManFacCLient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FactCli> guntz ;
	private ArrayList<ProdCli>prod;
	
	
	public ArrayList<ProdCli> getProd() {
		return prod;
	}


	public void setProd(ArrayList<ProdCli> prod) {
		this.prod = prod;
	}

	private FileFacture file;

	
	
	
	

//	public void setGuntz(ArrayList<FactCli> guntz) {
//		this.guntz = guntz;
//	}

	



	public ManFacCLient() {
		file = new FileFacture();
		guntz= new ArrayList<FactCli>();
		prod=new ArrayList<ProdCli>();
		
	}
	

	public void addGun(FactCli gun){
		
		guntz.add(gun);
		
	}
	
	/**
	 * constructor
	 *
	 */ 
public ManFacCLient(String name, String path) {
	guntz = new ArrayList<FactCli>();
	file = new FileFacture();
	prod=new ArrayList<ProdCli>();
	file.setName(name);
	file.setPath(path);
}

/**
 * agregar arma
 *phon,addres,cit
 */ 

		

	public boolean addCli(String id, String name,String last, String phon,String addres,String cit){
		System.out.println("AGregacioooooonnnnn");
		if(searchGuntz(id)==null){
			guntz.add(new FactCli(id, name, last, phon,addres,cit));
			return true;
			
		}else{
			return false;
		}		
	}
	
	
	
	
	public boolean addProd(String id, String name,String last, String phon,String addres){
		System.out.println("AGregacioooooonnnnn");
		if(searchGuntz(id)==null){
			prod.add(new ProdCli(id, name, last, phon,addres));
			return true;
			
		}else{
			return false;
		}		
	}

	/**
	 * Busqueda de arma por codigo
	 *
	 */ 
	public FactCli searchGuntz(String code) {
		
		for(FactCli gun: this.guntz){
			
			if(gun.getIdClient().equalsIgnoreCase(code)){
				return gun;
			}
		}
		
		return null;
	}
	
	/**
	 *borrado de arma por codigo
	 */ 
		public FactCli delete(String code){
			for(int i=0;i<=guntz.size();i++){				
				if(guntz.get(i).getIdClient().equals(code)){
					return guntz.remove(i);
				}
			}
			return null;
		}
		
		
	public ManFacCLient readClient(String path,String name)throws ClassNotFoundException, IOException{
System.out.println("Leer");
		file.setName(name);
		file.setPath(path);
		file.openFile();
		ManFacCLient serializable = file.reader();
		
		return serializable;
	}
	
	
	
	
	public void saveGun() throws IOException{
		file.writer(this);
	}

	public void saveGun(String path, String name) throws IOException {
		System.out.println("Guardado");
		file.setName(name);
		file.setPath(path);
		file.openFile();
		file.writer(this);
		
	}
	
	public ManFacCLient readGun() throws ClassNotFoundException,IOException{
		
		ManFacCLient serial=null;
		if(file.getFile().exists()){
			serial = file.reader();
		}
		return serial;		
	}
	
	public FactCli searchDescript(String descript){
		for(FactCli gun:this.guntz){
			if(gun.getName().equalsIgnoreCase(descript)){
				return gun;
			}
		}
		return null;
	}


	public FactCli searchValue(String value){
		for(FactCli gun:this.guntz){
			if(gun.getLastName().equalsIgnoreCase(value)){
				return gun;
			}
		}
		return null;
	}

	
	public FactCli findDocument(String code){
		for(FactCli gun:this.guntz){
			if(gun.getIdClient().equalsIgnoreCase(code)){
				return gun;
			}
		}
		return null;
	}
//se crea un switch case para los tipos de ordenamiento que vamos a usar en el programa
//	aqui se ordena por descripcion codigo y valor tambien se creo otro para descienda que es el sortcodtwo
//	 porque como el sortcod ya asciende no habia nececidad de implementar otro
//	se creo el metodo descend para solucionar esta funcion de ordenamiento
////	
//	public void sort(String sort){
//
//		
//		
//		switch(sort){
//
//		case HandlingEvents.SORT_DESCRIPT : Collections.sort(guntz, new Comparator<Gun>() {
//
//			@Override
//			public int compare(Gun o1, Gun o2) {
//				// TODO Auto-generated method stub
//				return o1.getDescrip().compareToIgnoreCase(o2.getDescrip());
//			}
//		});
//		break;
//
//		case HandlingEvents.SORT_VALUE : Collections.sort(guntz, new Comparator<Gun>() {
//
//			@Override
//			public int compare(Gun o1, Gun o2) {
//				// TODO Auto-generated method stub
//				return o1.getValue().compareToIgnoreCase(o2.getValue());
//			}
//
//		});
//		break;
//
//		case HandlingEvents.SORT_COD: Collections.sort(guntz, new Comparator<Gun>() {
//			
//			@Override
//			public int compare(Gun o1, Gun o2) {
//				// TODO Auto-generated method stub
//				return o1.getCode().compareTo(o2.getCode());
//			}
//			
//			
//		});
//		break;
//		case HandlingEvents.SORT_CODTWO: 
//			descendent();
//		break;
//		}
//	}
//	public void descendent(){
//		System.out.println("probar");
//		for (int i = 0; i < guntz.size(); i++) {
//			int p=i-1;
//			Gun gun= guntz.get(i);
//			while(p>=0 && gun.getCode().compareTo(guntz.get(p).getCode())>0){
//				guntz.set(p+1, guntz.get(p));
//				p--;
////			}
////			guntz.set(p+1, gun);
////		}
//	}
	public ManFacCLient readGun1()throws ClassNotFoundException, IOException{
		
		ManFacCLient fileSerializable = null;
		if(file.getFile().exists()){
			fileSerializable = file.reader();
		}
		return fileSerializable;
	}

	public ManFacCLient readGun1(String path, String name) throws ClassNotFoundException, IOException{
		file.setName(name);
		file.setPath(path);
		file.openFile();
		ManFacCLient personaSerializable = file.reader();

		return personaSerializable;
	}

	public void saveGunner()throws IOException{
		file.writer(this);
	}

	public void saveGunner(String path, String name) throws IOException{
		file.setName(name);
		file.setPath(path);
		file.openFile();
		file.writer(this);
	}
	
	public ArrayList<FactCli> getGuntz() {
	return guntz;
}


	
}
