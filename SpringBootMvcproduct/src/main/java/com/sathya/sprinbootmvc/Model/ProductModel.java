package com.sathya.sprinbootmvc.Model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@NotBlank(message="product name cannot be blank")
	private String name;
	
	@NotBlank(message="product brand cannot be blank")
	private String brand;
	
	
	@NotBlank(message="Made-In field cannot be blank")
	private  String madeIn;
	
	@Min(value=1, message="quantitymust be atleast 1")
    private int quantity;
	
	
	@Positive(message="price must be greaterthan zero")
	private double price;
	
	@DecimalMax(value="100.0", message="Discount rate cannot exceed 100")
	private double discountrate;
	
	@DecimalMax(value="40.0", message="taxprice cannot exceed 100")
	private double taxprice;
	

}
