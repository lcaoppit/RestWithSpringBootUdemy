package io.devsecops.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.devsecops.api.converter.DozerConverter;
import io.devsecops.api.converter.custom.PersonConverter;
import io.devsecops.api.data.model.Person;
import io.devsecops.api.data.vo.v1.PersonVO;
import io.devsecops.api.data.vo.v2.PersonVOv2;
import io.devsecops.api.exception.ResouceNotFoundException;
import io.devsecops.api.repository.PersonRepository;

// Use "SERVICE" annotation to SpringBoot work himself the dependences
@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOv2 createV2(PersonVOv2 person) {
		var entity = converter.convertVOtoEntity(person);
		var vo = converter.convertEntitytoVO(repository.save(entity));
		return vo;
	}
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo =  DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
	
		Person entity = repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
