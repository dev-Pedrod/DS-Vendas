package com.devpedrod.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devpedrod.dsvendas.dto.SaleDTO;
import com.devpedrod.dsvendas.dto.SaleSuccessDTO;
import com.devpedrod.dsvendas.dto.SaleSumDTO;
import com.devpedrod.dsvendas.entities.Sale;
import com.devpedrod.dsvendas.repositories.SaleRespository;
import com.devpedrod.dsvendas.repositories.SellerRespository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRespository repository;
	@Autowired
	private SellerRespository sellerRespository;
	
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRespository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();	
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();	
	}
}
