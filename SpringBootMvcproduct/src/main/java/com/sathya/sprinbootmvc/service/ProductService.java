package com.sathya.sprinbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.sprinbootmvc.Model.ProductModel;
import com.sathya.sprinbootmvc.entity.ProductEntity;
import com.sathya.sprinbootmvc.repostory.ProductRepository;

@Service
public class ProductService {
  @Autowired
    ProductRepository productRepository;
    public void saveProductModelDetails(ProductModel productModel){
	  double discountprice;
	  discountprice=productModel.getPrice()*productModel.getDiscountrate()/100;
	  
	  double offerprice;
	  offerprice=productModel.getPrice()-discountprice;
	  
	  
	  double finalprice;
	  finalprice=offerprice+productModel.getTaxprice()/100;
	  
	  
	  double stockValue;
	  stockValue= productModel.getQuantity()*offerprice +productModel.getTaxprice()/100 ;
	  
	  ProductEntity productEntity=new ProductEntity();
	  
	  productEntity.setName(productModel.getName());
	  productEntity.setBrand(productModel.getBrand());
	  productEntity.setMadeIn(productModel.getMadeIn());
	  productEntity.setPrice(productModel.getPrice());
	  productEntity.setQuantity(productModel.getQuantity());
	  productEntity.setDiscountrate(productModel.getDiscountrate());
	  productEntity.setTaxprice(productModel.getTaxprice());
	  productEntity.setDiscountprice(discountprice);
	  productEntity.setOfferprice(offerprice);
	  productEntity.setFinalprice(finalprice);
	  productEntity.setStockvalue(stockValue);
	  
	  productRepository.save(productEntity);
	  
    }
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products= productRepository.findAll();
	
		return products;
	}
	

	public ProductEntity searchById(Long id)
	{
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
	}
	
	
	
		public void deleteproductById(Long id)
		{
			productRepository.deleteById(id);
		}
		   
		
		
		public void editProductsave(ProductModel productModel) 
		{
			ProductEntity entity=new ProductEntity();
			
			entity.setName(productModel.getName());
			entity.setBrand(productModel.getBrand());
			entity.setMadeIn(productModel.getMadeIn());
			entity.setPrice(productModel.getPrice());
			entity.setQuantity(productModel.getQuantity());
			entity.setDiscountrate(productModel.getDiscountrate());
			entity.setTaxprice(productModel.getTaxprice());

			
		}
}
		
	
	
   
		
	