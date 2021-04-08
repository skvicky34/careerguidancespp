package com.careerguidance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.ExaminationBoard;
import com.careerguidance.repositories.ExaminationBoardRepository;
/**
 * This class contains method to retrieve Examination Board names.
 * @author Amarkant Gupta
 *
 */
@Service
public class ExaminationBoardServiceImpl implements IExaminationBoardService {
	
	@Autowired
	ExaminationBoardRepository repository;
	
	@Override
	public List<ExaminationBoard> getBoardsName()throws DataNotFoundException {
		return (List<ExaminationBoard>) repository.findAll();
		
	}

}
