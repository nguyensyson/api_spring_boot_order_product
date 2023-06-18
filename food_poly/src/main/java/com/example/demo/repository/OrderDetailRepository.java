package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.OrderDetailViewDTO;
import com.example.demo.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	@Query("SELECT new OrderDetailViewDTO(o.id, o.products.nameProduct, o.products.price, "
			+ "o.products.avartarImageProduct, o.products.discount, o.priceTotal, o.quantity) "
			+ "FROM OrderDetail o WHERE o.orders.id = :id")
	public List<OrderDetailViewDTO> getByOrder(@Param("id") Integer id);
}
