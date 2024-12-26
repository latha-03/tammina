package com.sathya.sprinbootmvc.entity;

import jakarta.persistence.Entity;

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
	    private long id;
		private String Name;
		private String brand;

		private String madein;
		private int quatity;
		private double price;
		private double taxrate;
		private double offerprice;
		private double stockvalue;
		private double Discountprice;
		private double discountrate;
		private double finalrate;
}
