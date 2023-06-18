package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductsViewDTO;
import com.example.demo.entity.Products;
import com.example.demo.service.ProductsService;

@RestController
public class ProductsManagerController {

	@Autowired
	ProductsService productsService;
	
//	view All
	@GetMapping("/manager/products/view")
	public ResponseEntity<List<ProductsViewDTO>> getAllProduct(@RequestParam Optional<Integer> page) {
		try {
			List<ProductsViewDTO> list =  productsService.getListProducts(page.orElse(0));
			return new ResponseEntity<List<ProductsViewDTO>>(list, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ProductsViewDTO>>(HttpStatus.NOT_FOUND);
		}
	}
	
//	Create Products
	@PostMapping("/manager/products/create")
	public ResponseEntity<ProductsViewDTO> createProduct(@RequestBody Products products) {
		try {
			ProductsViewDTO products2 = productsService.createProduct(products);
			return new ResponseEntity<ProductsViewDTO>(products2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductsViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
//	update product
	@PutMapping("/manager/products/update")
	public ResponseEntity<ProductsViewDTO> updateProduct(@RequestBody Products products, @RequestParam Integer id) {
		try {
			ProductsViewDTO products2 = productsService.updateProducts(products, id);
			return new ResponseEntity<ProductsViewDTO>(products2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductsViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
//	find By Type
	@GetMapping("/manager/products/type")
	public ResponseEntity<List<ProductsViewDTO>> getProductsByType(@RequestParam Integer idType) {
		try {
			List<ProductsViewDTO> list = productsService.getProductsByType(idType);
			return new ResponseEntity<List<ProductsViewDTO>>(list, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ProductsViewDTO>>(HttpStatus.NOT_FOUND);
		}
	}
	
//	Detail
	@GetMapping("/manager/products/detail")
	public ResponseEntity<ProductsViewDTO> getProductsById(@RequestParam Integer id) {
		try {
			ProductsViewDTO products2 = productsService.getById(id);
			return new ResponseEntity<ProductsViewDTO>(products2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductsViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
//	search By name
	@GetMapping("/manager/products/search")
	public ResponseEntity<List<ProductsViewDTO>> searchByName(@RequestParam String name) {
		try {
			List<ProductsViewDTO> list = productsService.searchByName(name);
			return new ResponseEntity<List<ProductsViewDTO>>(list, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ProductsViewDTO>>(HttpStatus.NOT_FOUND);
		}
	}
	
//	lọc giá
	@GetMapping("/manager/products/filter/price")
	public ResponseEntity<List<ProductsViewDTO>> filterByPrice(@RequestParam double from, @RequestParam double to) {
		try {
			List<ProductsViewDTO> list = productsService.filterByPrice(from, to);
			return new ResponseEntity<List<ProductsViewDTO>>(list, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ProductsViewDTO>>(HttpStatus.NOT_FOUND);
		}
				
	}
	
//	lọc theo giá trị giảm giá
	@GetMapping("/manager/products/filter/discount")
	public ResponseEntity<List<ProductsViewDTO>> filterByDiscount(@RequestParam Integer discount) {
		try {
			List<ProductsViewDTO> list = productsService.filterByDiscount(discount);
			return new ResponseEntity<List<ProductsViewDTO>>(list, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ProductsViewDTO>>(HttpStatus.NOT_FOUND);
		}
	}
}
