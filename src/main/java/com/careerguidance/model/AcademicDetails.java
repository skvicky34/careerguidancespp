package com.careerguidance.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "academic_details")
public class AcademicDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5611291601005466224L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private Double totalMarks;
	private String boardName;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "academicDetails",fetch = FetchType.LAZY)
    private Set<UserAcademicSubject> userAcademicSubject;

	/**
	 * default constructor
	 */
	public AcademicDetails() {
	}

}
