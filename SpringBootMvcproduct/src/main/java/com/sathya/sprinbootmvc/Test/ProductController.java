package com.sathya.sprinbootmvc.Test;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.sprinbootmvc.Model.ProductModel;
import com.sathya.sprinbootmvc.entity.ProductEntity;
import com.sathya.sprinbootmvc.service.ProductService;

import jakarta.validation.Valid;


@Controller
public class ProductController {

	@Autowired
    ProductService productService;
	
	
	
    @GetMapping("/productform")
	  	public String getProductForm(Model model)
	  	{
	  		ProductModel productModel=new ProductModel();
	  	    productModel.setMadeIn("INDIA");
	  	    productModel.setQuantity(2);
	  	    productModel.setDiscountrate(10.5);
	  	    model.addAttribute("productModel",productModel);
	  	
	  		return "add-product";
	  	}
	      
	      @PostMapping("/saveproduct")
	  	public String SaveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model model)
	  	{
	  		HashMap<String, String> validationErrors=new HashMap<String,String>();
	  		if(bindingResult.hasErrors())
	  		{
	  			for(FieldError fieldError:bindingResult.getFieldErrors())
	  			{
	  				validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
	  			}
	  			model.addAttribute("validationErrors",validationErrors);
	  			return "add-product";
	  		}
	  		
	  		productService.saveProductModelDetails(productModel);
	  		
	  		return "redirect:/getallproducts";
	  	}

	@GetMapping("/getallproduts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("products", products);
		return "product-list";
	}
	
	@GetMapping("/searchform")
	public String getsearchById()
	{
		return "search-product";
	}
	
	@PostMapping("/searchbyid")
	public String getProductById(@RequestAttribute Long id,Model model)
	{
		ProductEntity product=productService.searchById(id);
		model.addAttribute("product",product);
		return "search-product";
	}
	
	
		//delete operations
		@GetMapping("/delete/{id}")
		public String deleteproductById(@PathVariable("id")Long id)
		{
			productService.deleteproductById(id);
			return "redirect:/getallproducts";
		}
		
		@GetMapping("/edit/{id}")
	      public String editProductForm(@PathVariable("id") Long id, Model model) 
	      {
	          ProductEntity product = productService.searchById(id); 
	          model.addAttribute("product", product); 
	          return "edit-product"; 
	      }

	      // POST method to save the edited product
	      @PostMapping("/editproductsave")
	      public String editProductsave(@RequestParam ProductModel productModel) {
	          productService.editProductsave(productModel);
	          return "redirect:/getallproducts"; 
	      }
	      
	  
	  		
	  		
	  	}
	      
	      
	      
	      
	      
	      
	     
	
		
	
