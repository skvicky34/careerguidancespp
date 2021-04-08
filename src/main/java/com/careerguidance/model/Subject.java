package com.careerguidance.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This class contains examination board details.
 * 
 * @author Amarkant Gupta
 *
 */
@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5246250578871420803L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_board_id")
	ExaminationBoard examinationBoard;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "subject")
    private UserAcademicSubject userAcademicSubject;

}
