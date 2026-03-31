package com.example.Backend.DTO;

import java.util.List;

import com.example.Backend.Entity.Address;
import com.example.Backend.Entity.Product;

public class OrderDto {
        private Address address;
	    private int userId;
	    private int productId;
	    private Integer quantity;
	    private Double discount;
	    private Double tax;
	    private Long Price;
	    private String pname;
	    private String PaymentStatus;
	    private Double Deliverycharge;
	    private String Status;
	    private int id;
	    
	    private List<Integer> productIds;
	    
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Double getDiscount() {
			return discount;
		}
		public void setDiscount(Double discount) {
			this.discount = discount;
		}
		public String getPaymentStatus() {
			// TODO Auto-generated method stub
			return PaymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			PaymentStatus = paymentStatus;
		}
		public Double getTax() {
			// TODO Auto-generated method stub
			return tax;
		}
		public void setTax(Double tax) {
			this.tax = tax;
		}
		public Long getPrice() {
			return Price;
		}
		public void setPrice(Long price) {
			Price = price;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public Double getDeliverycharge() {
			// TODO Auto-generated method stub
			return Deliverycharge;
		}
		public void setDeliverycharge(Double deliverycharge) {
			Deliverycharge = deliverycharge;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}

	
}
