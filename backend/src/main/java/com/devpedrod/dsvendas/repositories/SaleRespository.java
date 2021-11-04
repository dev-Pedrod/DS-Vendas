package com.devpedrod.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devpedrod.dsvendas.dto.SaleSuccessDTO;
import com.devpedrod.dsvendas.dto.SaleSumDTO;
import com.devpedrod.dsvendas.entities.Sale;

@Repository
public interface SaleRespository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.devpedrod.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devpedrod.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSuccessDTO> successGroupedBySeller();
}	
