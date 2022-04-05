package com.fis.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.system.entity.Detecvice;


public interface DetecviceRepo extends JpaRepository<Detecvice, Long> {
	
	boolean existsByBadgeNumber(String badgeNumber);

}
