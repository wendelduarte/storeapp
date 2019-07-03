package com.store.storeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.storeapp.Utils;
import com.store.storeapp.models.StatusOrder;
import com.store.storeapp.service.StatusOrderService;

@RestController
public class StatusOrderController {

	@Autowired
	private StatusOrderService statusOrderService;
	
	@Autowired
	private Utils utilM;
	
	@CrossOrigin
	@GetMapping("/status")
	public ResponseEntity<List<?>> getAllStatus(){
		List<StatusOrder> status = statusOrderService.getAllStatus();
		return utilM.getAll(status);
	}
	
	@CrossOrigin
	@GetMapping("/status/{id}")
	public ResponseEntity<Optional<?>> getOneStatus(@PathVariable Long id){
		Optional<StatusOrder> status = statusOrderService.getOneStatus(id);
		return utilM.getOne(status);
	}
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/status/post")
	public StatusOrder postStatus(@RequestBody StatusOrder newStatus) {
		return statusOrderService.setStatusOrder(newStatus);
	}
	
	@CrossOrigin
	@PutMapping("/status/{id}")
	public ResponseEntity<Optional<?>> updateStatus(@RequestBody StatusOrder update, @PathVariable Long id) {
		Optional<StatusOrder> status = statusOrderService.updateStatusOrder(update, id);
		return utilM.update(status);
	}
	
	@CrossOrigin
	@DeleteMapping("/status/{statusOrder}")
	public ResponseEntity<?> deleteStatus(@PathVariable StatusOrder statusOrder){
		boolean status = statusOrderService.deleteStatus(statusOrder);
		return utilM.delete(status);
	}
}
