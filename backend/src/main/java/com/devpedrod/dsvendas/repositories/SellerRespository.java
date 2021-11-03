package com.devpedrod.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devpedrod.dsvendas.entities.Seller;

@Repository
public interface SellerRespository extends JpaRepository<Seller, Long>{
	
}	
