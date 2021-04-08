package com.careerguidance.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * This class contains examination board subject details.
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "exam_board")
@Getter
@Setter
public class ExaminationBoard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6620186495551024980L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "examinationBoard",fetch = FetchType.LAZY)
    private Set<Subject> subjects;

}
