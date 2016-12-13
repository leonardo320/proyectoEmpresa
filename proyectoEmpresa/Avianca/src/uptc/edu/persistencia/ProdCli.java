package uptc.edu.persistencia;

import java.io.Serializable;import java.util.ArrayList;
import javax.swing.JTextField;





public class ProdCli implements Serializable {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
		private String idProduc;
		private String description;
		private String value;
		private String stock;
		private String iva;
	
		private ArrayList<ProdCli>prodcli;

		public ProdCli(String idProduc, String description, String value,
				String stock, String iva) {
			super();
			this.idProduc = idProduc;
			this.description = description;
			this.value = value;
			this.stock = stock;
			this.iva = iva;
			this.prodcli = new ArrayList<>();
		}

		public String getIdProduc() {
			return idProduc;
		}

		public void setIdProduc(String idProduc) {
			this.idProduc = idProduc;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getStock() {
			return stock;
		}

		public void setStock(String stock) {
			this.stock = stock;
		}

		public String getIva() {
			return iva;
		}

		public void setIva(String iva) {
			this.iva = iva;
		}

		public ArrayList<ProdCli> getProdcli() {
			return prodcli;
		}

		public void setProdcli(ArrayList<ProdCli> prodcli) {
			this.prodcli = prodcli;
		}
		
		public ProdCli() {
			idProduc=getIdProduc();
			description = getDescription();
			value= getValue();
			stock = getStock();
			iva=getIva();
		
			
		
		}

		@Override
		public String toString() {
			return "ProdCli [idProduc=" + idProduc + ", description="
					+ description + ", value=" + value + ", stock=" + stock
					+ ", iva=" + iva + ", prodcli=" + prodcli + "]";
		}
		


}
		
		