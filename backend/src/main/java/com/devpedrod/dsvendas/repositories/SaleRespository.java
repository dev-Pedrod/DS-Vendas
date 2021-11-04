package com.devpedrod.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpedrod.dsvendas.entities.Sale;

@Repository
public interface SaleRespository extends JpaRepository<Sale, Long>{
	
}	
