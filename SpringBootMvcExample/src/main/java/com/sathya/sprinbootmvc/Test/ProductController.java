package com.sathya.sprinbootmvc.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.sprinbootmvc.Model.ProductModel;
import com.sathya.sprinbootmvc.service.ProductService;

@Controller
public class ProductController {

	@Autowired
    ProductService productService;
	
	
	
	@GetMapping("/productform")
	public String getproductform()
	{
		return "add-product";
	}
	
	@PostMapping("/saveproduct")
	public String saveproduct(ProductModel productModel)
	{
		System.out.println(productModel);
		return "success";
	}

}
