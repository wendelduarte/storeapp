package com.store.storeapp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public ResponseEntity<List<?>> getAll(List<?> a){
		if(a.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<?>>(a, HttpStatus.OK);
		}
	
	public ResponseEntity<Optional<?>> getOne(Optional<?> a){
		if(a.isPresent()) {
			return new ResponseEntity<Optional<?>>(a, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Optional<?>> update (Optional<?> a){
		if(a != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> delete (boolean a){
		if(a) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
}

