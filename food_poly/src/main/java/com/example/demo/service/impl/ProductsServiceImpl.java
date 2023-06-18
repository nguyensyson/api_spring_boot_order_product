package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductsViewDTO;
import com.example.demo.entity.Products;
import com.example.demo.repository.ProductTypeRepository;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductTypeRepository typeRepository;

	@Override
	public List<ProductsViewDTO> getListProducts(Integer page) {
		Pageable pageable = PageRequest.of(page, 16);
		Page<Products> products = productsRepository.findAll(pageable);
		List<ProductsViewDTO> productsViewDTOs = new ArrayList<>();
		for (Products i : products.getContent()) {
			ProductsViewDTO dto = productsRepository.getProductById(i.getId());
			productsViewDTOs.add(dto);
		}
		return productsViewDTOs;
	}

	@Override
	public ProductsViewDTO createProduct(Products product) {
		Products p = productsRepository.save(product);
		return productsRepository.getProductById(p.getId());
	}

	@Override
	public ProductsViewDTO updateProducts(Products products, Integer id) {
		Optional<Products> p = productsRepository.findById(id);
		if(p.isEmpty()) {
			return null;
		}
		p.get().setProductType(products.getProductType());
		p.get().setNameProduct(products.getNameProduct());
		p.get().setPrice(products.getPrice());
		p.get().setAvartarImageProduct(products.getAvartarImageProduct());
		p.get().setTitle(products.getTitle());
		p.get().setDiscount(products.getDiscount());
		p.get().setStatus(products.getStatus());
		p.get().setUpdateAt(LocalDate.now());
		
		Products sanPham = productsRepository.save(p.get());
		return productsRepository.getProductById(sanPham.getId());
	}

	@Override
	public List<ProductsViewDTO> getProductsByType(Integer idType) {
		return productsRepository.getByType(idType);
	}

	@Override
	public ProductsViewDTO getById(Integer id) {
		Optional<Products> product = productsRepository.findById(id);
		if(product.isEmpty()) {
			return null;
		}
		
		ProductsViewDTO dto = productsRepository.getProductById(product.get().getId());
		return dto;
	}

	@Override
	public List<ProductsViewDTO> searchByName(String name) {
		return productsRepository.searchByName(name);
	}

	@Override
	public List<ProductsViewDTO> filterByPrice(double fromPrice, double toPrice) {
		return productsRepository.filterByPrice(fromPrice, toPrice);
	}

	@Override
	public List<ProductsViewDTO> filterByDiscount(Integer discount) {
		return productsRepository.filterByDiscount(discount);
	}

}
