package com.example.MainModel;

	import java.io.Serializable;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;

	@Entity
	@Table(name = "product")
	public class Product implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;

		@Column(name = "productid")
		private Integer productId;

		@Column(name = "productname")
		private String productName;

		@Column(name = "productdescription")
		private String ProductDescription;

		@Column(name = "totalquantity")
		private String Totalquantity;

		@Column(name = "amount")
		private String Amount;

		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductDescription() {
			return ProductDescription;
		}

		public void setProductDescription(String productDescription) {
			this.ProductDescription = productDescription;
		}

		public String getQuantity() {
			return Totalquantity;
		}

		public void setQuantity(String quantity) {
			this.Totalquantity = quantity;
		}

		public String getAmount() {
			return Amount;
		}

		public void setAmount(String amount) {
			this.Amount = amount;
		}


		@Override
		public String toString() {
			return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName
					+ ", productDescription=" + ProductDescription + ", quantity=" + Totalquantity + ", amount=" + Amount + "]";
		}

		@ManyToOne
		@JoinColumn(name="category_id")
		private Category category;
	}


