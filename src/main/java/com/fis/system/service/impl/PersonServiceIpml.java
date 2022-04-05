package com.fis.system.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fis.system.entity.Person;
import com.fis.system.repo.PersonRepo;
import com.fis.system.service.PersonService;

@Service
public class PersonServiceIpml implements PersonService  {
	
	@Autowired
	private PersonRepo personRepo;

	@Override
	public Person getPersonByID(Long id) {
		// TODO Auto-generated method stub
		return personRepo.getById(id);
	}

	@Override
	public void createPerson(Person person) {
		// TODO Auto-generated method stub
		personRepo.save(person);
		
	}

	@Override
	public boolean isPersonExistsByUsername(String username) {
		// TODO Auto-generated method stub
		return personRepo.existsByUsername(username);
	}

	@Override
	public Person getPersonByUsername(String username) {
		// TODO Auto-generated method stub
		return personRepo.findByname(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepo.findByname(username);

		if (person == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(person.getUsername(), person.getPassword(), Collections.emptyList());
	}
}


