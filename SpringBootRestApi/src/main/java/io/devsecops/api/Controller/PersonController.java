//Class will do the web interface 
package io.devsecops.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.devsecops.api.data.vo.PersonVO;
import io.devsecops.api.data.vo.v2.PersonVOv2;
import io.devsecops.api.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;

	//list ALL account
	@GetMapping	
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	//List ONE account
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	//Create account
	@PostMapping
		public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}
	@PostMapping("/v2")
	public PersonVOv2 createV2(@RequestBody PersonVOv2 person) {
	return services.createV2(person);
}
	
	//Update an account
	@PutMapping	
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}
	
	//Delete an account
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}	
}