package com.store.storeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.storeapp.models.StatusOrder;
import com.store.storeapp.repository.StatusOrderRepository;

@Service
public class StatusOrderService {

	@Autowired
	private StatusOrderRepository statusOrderRepository;
	
	public List<StatusOrder> getAllStatus(){
		return statusOrderRepository.findAll();
	}
	
	public Optional<StatusOrder> getOneStatus(Long id) {
		return statusOrderRepository.findById(id);
	}	
	
	public StatusOrder setStatusOrder(StatusOrder status) {
		return statusOrderRepository.save(status);
	}
	
	public Optional<StatusOrder> updateStatusOrder(StatusOrder updateStatus, Long id) {
		Optional<StatusOrder> status = getOneStatus(id);
		if(status.isPresent()) {
			return status = Optional.of(statusOrderRepository.save(updateStatus));
		}
		return null;
	}
	
	public boolean deleteStatus(StatusOrder statusOrder) {
		List<StatusOrder> status = getAllStatus();
		if(status.contains(statusOrder)) {
			statusOrderRepository.delete(statusOrder);
			return true;
		}
		return false;
	}
}