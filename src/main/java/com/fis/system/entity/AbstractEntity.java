package com.fis.system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)

public abstract class AbstractEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int version;
	private LocalDateTime createAt;
	private LocalDateTime modifiedAt;
}
