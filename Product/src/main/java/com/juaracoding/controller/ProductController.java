package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.entity.Product;
import com.juaracoding.entity.Response;
import com.juaracoding.service.ModelProduct;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ModelProduct modProduct;
	
	@GetMapping("/")
	public ResponseEntity<Response> getAll(){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil mendapatkan data");
		
		response.setData(this.modProduct.getAllProduct());
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Response> addData(@RequestBody Product product){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil memasukan data");
		
		response.setData(this.modProduct.addProduct(product));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateData(@RequestBody Product product, @PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil update data");
		
		product.setId(Long.parseLong(id));
		response.setData(this.modProduct.updateProduct(product));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteData(@PathVariable String id){
		
		Response response = new Response();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil delete data");
		
		response.setData(this.modProduct.deleteProduct(id));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@GetMapping("/{id}")
	public Product getDataById(@PathVariable String id) {
		return this.modProduct.getByIdProduct(id);
	}
	
	
}
