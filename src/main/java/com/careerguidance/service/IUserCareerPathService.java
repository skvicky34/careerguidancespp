package com.careerguidance.service;

import com.careerguidance.dto.UserCareerPathDto;
import com.careerguidance.model.User;
import com.careerguidance.model.UserCareerPath;

public interface IUserCareerPathService {

	UserCareerPath saveUserCareerPath(UserCareerPathDto userCareerPath, User user);

}
