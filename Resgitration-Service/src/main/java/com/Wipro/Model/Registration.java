package com.Wipro.Model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Registration
{
	
	private int registrationId;
	
	private LocalDate dataOfRegistration;
	
	private Student student;
	
	private Course course;
	
	private double amountPaid;
	
	private double amountDue;

}
