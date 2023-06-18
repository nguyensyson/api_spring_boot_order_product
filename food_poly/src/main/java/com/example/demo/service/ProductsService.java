package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.ProductsViewDTO;
import com.example.demo.entity.Products;

public interface ProductsService {

	List<ProductsViewDTO> getListProducts(Integer page);
	ProductsViewDTO createProduct(Products product);
	ProductsViewDTO updateProducts(Products products, Integer id);
	List<ProductsViewDTO> getProductsByType(Integer idType);
	ProductsViewDTO getById(Integer id);
	List<ProductsViewDTO> searchByName(String name);
	List<ProductsViewDTO> filterByPrice(double fromPrice, double toPrice);
	List<ProductsViewDTO> filterByDiscount(Integer discount);
 }
