package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProductsViewDTO;
import com.example.demo.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

	@Query("SELECT new ProductsViewDTO(p.id, p.productType.name, p.nameProduct, p.price, "
			+ "p.avartarImageProduct, p.title, p.discount) FROM Products p WHERE p.productType.id = :id")
	public List<ProductsViewDTO> getByType(@Param("id") Integer id);
	
	@Query("SELECT new ProductsViewDTO(p.id, p.productType.name, p.nameProduct, p.price, "
			+ "p.avartarImageProduct, p.title, p.discount) FROM Products p WHERE p.nameProduct LIKE %:name%")
	public List<ProductsViewDTO> searchByName(@Param("name") String name);
	
	@Query("SELECT new ProductsViewDTO(p.id, p.productType.name, p.nameProduct, p.price, "
			+ "p.avartarImageProduct, p.title, p.discount) FROM Products p WHERE p.price BETWEEN :from AND :to")
	public List<ProductsViewDTO> filterByPrice(@Param("from") double from, @Param("to") double to);
	
	@Query("SELECT new ProductsViewDTO(p.id, p.productType.name, p.nameProduct, p.price, "
			+ "p.avartarImageProduct, p.title, p.discount) FROM Products p WHERE p.discount = :discount")
	public List<ProductsViewDTO> filterByDiscount(@Param("discount") Integer discount);
	
	@Query("SELECT new ProductsViewDTO(p.id, p.productType.name, p.nameProduct, p.price, "
			+ "p.avartarImageProduct, p.title, p.discount) FROM Products p WHERE p.id = :id")
	public ProductsViewDTO getProductById(@Param("id") Integer id);
}
