package com.sathya.sprinbootmvc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private String name;
	private String brand;
	private  String madein;
	private String quatity;
	private double price;
	private double discount;
	

}
