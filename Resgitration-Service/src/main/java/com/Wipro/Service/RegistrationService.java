package com.Wipro.Service;

import java.util.List;

import com.Wipro.Entity.RegistrationEntity;
import com.Wipro.Model.Registration;

public interface RegistrationService 
{
	RegistrationEntity register(RegistrationEntity registrationEntity);
	
	Registration getRegistrationDetailsById(int registrationId);
	
	List<Registration> findAllRegistrations();
	
	
}
