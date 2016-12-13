package uptc.edu.persistencia;

import java.io.Serializable;import java.util.ArrayList;
import javax.swing.JTextField;





public class FactCli implements Serializable {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String idClient;
		private String name;
		private String lastName;
		private String phone;
		private String address;
		private String city;
		private ArrayList<FactCli>factcli;
		
		


public FactCli(String idClient, String name, String lastname, String phone,String addres,String city) {
super();
this.idClient = idClient;
this.name = name;
this.lastName = lastname;
this.phone=phone;
this.address=addres;
this.city=city;
this.factcli= new ArrayList<>();
}
		
		
		


		public String getIdClient() {
			return idClient;
		}

		public void setIdClient(String idClient) {
			this.idClient = idClient;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public ArrayList<FactCli> getFactcli() {
			return factcli;
		}

		public void setFactcli(ArrayList<FactCli> factcli) {
			this.factcli = factcli;
		}

		
		public FactCli() {
			idClient=getIdClient();
			name = getName();
			lastName= getLastName();
			phone = getPhone();
			address=getPhone();
			city=getCity();
			
		
		}
			@Override
			public String toString() {
				return "FactCli [idClient=" + idClient + ", name=" + name
						+ ", lastName=" + lastName + ", phone=" + phone
						+ ", address=" + address + ", city=" + city
						+ ", factcli=" + factcli + "]";
			}

			

			

			
			

			
		
		
		
		
		
	}

