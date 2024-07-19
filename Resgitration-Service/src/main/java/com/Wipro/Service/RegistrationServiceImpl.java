package com.Wipro.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.Entity.RegistrationEntity;
import com.Wipro.Exception.ResourseNotFoundException;
import com.Wipro.Model.Course;
import com.Wipro.Model.Registration;
import com.Wipro.Model.Student;
import com.Wipro.Repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService
{
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private StudentApiClient studentApiClient;
	
	@Autowired
	private CourseApiClient courseApiClient;
	
	@Autowired
	private KafkaConsumerStudent kafkaConsumerStudent;

	@Override
	public RegistrationEntity register(RegistrationEntity registrationEntity)
	{
		registrationEntity.setDataOfRegistration(LocalDate.now());
		
		//fetching course object by courseId
		Course course = courseApiClient.getCourseDetails(registrationEntity.getCourseId());

		registrationEntity.setAmountDue(course.getFees() - registrationEntity.getAmountPaid());

		registrationRepository.save(registrationEntity);
		return registrationEntity;
	}

	@Override
	public Registration getRegistrationDetailsById(int registrationId) throws ResourseNotFoundException
	{
		Optional<RegistrationEntity> optionalRegistration=registrationRepository.findById(registrationId);
		if(optionalRegistration.isEmpty())
		{
			throw new ResourseNotFoundException("No registration done with this id: "+registrationId);
		}
		
		RegistrationEntity registrationEntity=optionalRegistration.get();
		
		//Using Feign Client 
		
		//fetching student object by studentId
		Student student=studentApiClient.getStudentDetails(registrationEntity.getStudentId());
		
		//fetching course object by courseId
		Course course = courseApiClient.getCourseDetails(registrationEntity.getCourseId());
		
		//Using kafka fetching student object
//		kafkaConsumerStudent.consume()
		
		
		Registration re=new Registration();
		
		re.setRegistrationId(registrationId);
		re.setDataOfRegistration(registrationEntity.getDataOfRegistration());
		re.setAmountDue(registrationEntity.getAmountDue());
		re.setAmountPaid(registrationEntity.getAmountPaid());
		re.setStudent(student);
		re.setCourse(course);
		
		return re;
	}

	@Override
	public List<Registration> findAllRegistrations() 
	{
		List<RegistrationEntity> registrationEntityList=registrationRepository.findAll();
		
		List<Registration> allRestaurants=new ArrayList<>();
		
		for(RegistrationEntity registrationEntity:registrationEntityList)
		{
			//fetching student object by courseId
			Student student=studentApiClient.getStudentDetails(registrationEntity.getStudentId());
			
			//fetching course object by courseId
			Course course = courseApiClient.getCourseDetails(registrationEntity.getCourseId());
			
			Registration registration=new Registration();
			
			registration.setRegistrationId(registrationEntity.getRegistrationId());
			registration.setAmountDue(registrationEntity.getAmountDue());
			registration.setAmountPaid(registrationEntity.getAmountPaid());
			registration.setCourse(course);
			registration.setStudent(student);
			registration.setDataOfRegistration(registrationEntity.getDataOfRegistration());
			
			allRestaurants.add(registration);
			
		}
		return allRestaurants;
			
	}
	

}
