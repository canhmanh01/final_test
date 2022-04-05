package com.fis.system.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fis.system.entity.Person;

public interface PersonService extends UserDetailsService {
	
	Person getPersonByID(Long id);

	void createPerson(Person person);

	boolean isPersonExistsByUsername(String username);

	Person getPersonByUsername(String username);

}
