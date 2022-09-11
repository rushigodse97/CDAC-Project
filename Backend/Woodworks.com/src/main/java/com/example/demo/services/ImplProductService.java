package com.example.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepositoy;

@Service
public class ImplProductService implements ProductService{

	@Autowired
	ProductRepositoy productRepository;
	
	@Override
	public String uploadProductImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		//File name
		String name=file.getOriginalFilename();
		
		//Random name generate file
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));
		//Full path
		String filePath=path+File.separator+fileName1;
		
		//create folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	@Override
	public Product UploadProduct(Product product) {
		
		return productRepository.save(product);
	}

	

}
