package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Product;

public interface ProductService {

	public String uploadProductImage(String path,MultipartFile file) throws IOException ;

	public Product UploadProduct(Product product);
}
