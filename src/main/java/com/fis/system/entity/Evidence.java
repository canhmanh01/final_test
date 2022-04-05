package com.fis.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Evidence extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "criminalCaseId", referencedColumnName = "id")
	@JsonIgnoreProperties("evidenceSet")
	private CriminalCase criminalCase;

	private String number;
	private String itemName;
	private String notes;
	private Boolean archived;
	
	public void setStorage(Storage s) {
		// TODO Auto-generated method stub
		
	}
	


}
