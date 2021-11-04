package com.devpedrod.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpedrod.dsvendas.dto.SellerDTO;
import com.devpedrod.dsvendas.entities.Seller;
import com.devpedrod.dsvendas.repositories.SellerRespository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRespository repository;

	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
