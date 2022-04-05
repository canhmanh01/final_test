package com.fis.system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode (callSuper = true)
public class CriminalCase extends AbstractEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="criminalCase", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("criminalCase")
	private List<Evidence> evidenceSet;
	
	
	private CascadeType type;
	private CaseStatus status;
	private String number;
	private String shortDescription;
	private String detailedDescription;
	private String notes;
	
}
