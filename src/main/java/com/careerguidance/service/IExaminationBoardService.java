package com.careerguidance.service;

import java.util.List;

import com.careerguidance.exception.DataNotFoundException;
import com.careerguidance.model.ExaminationBoard;

public interface IExaminationBoardService {

	List<ExaminationBoard> getBoardsName() throws DataNotFoundException;

}
