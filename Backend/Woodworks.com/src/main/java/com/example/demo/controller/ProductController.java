package com.example.demo.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Value("${project.image}")
	private String path;

	@PostMapping("/uploadProduct")
	public Product save(@RequestParam("productImage1") MultipartFile productImage1, @RequestBody Product product) {
		Product p1=null;
		try {
			String fileName = this.productService.uploadProductImage(path, productImage1);
			product.setProductImage(fileName);
			 p1=productService.UploadProduct(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return p1;
	}
}
