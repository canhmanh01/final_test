package com.fis.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.system.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long>  {
	
	boolean existsByUsername(String name);

	Person findByname(String name);
}
