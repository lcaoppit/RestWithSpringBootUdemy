package io.devsecops.api.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;
import io.devsecops.api.data.model.Person;
import io.devsecops.api.data.vo.v2.PersonVOv2;

@Service
public class PersonConverter {

	public PersonVOv2 convertEntitytoVO(Person person) {
		PersonVOv2 vo = new PersonVOv2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;		
	}
	
	public Person convertVOtoEntity(PersonVOv2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;		
	}	
}
