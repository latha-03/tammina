package com.sathya.sprinbootmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
		private String Name;
		private String brand;
		private String madeIn;
		private int quantity;
		private double price;
		private double discountrate;
		private double taxprice;
		private double discountprice;
		private double offerprice;
		private double finalprice;
		private double stockvalue;
		

}
