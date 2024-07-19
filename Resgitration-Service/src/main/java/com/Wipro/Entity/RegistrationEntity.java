package com.Wipro.Entity;

import java.time.LocalDate;

import com.Wipro.Model.Course;
import com.Wipro.Model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="registration_tbl")
@Setter
@Getter
public class RegistrationEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="registration_id")
	private int registrationId;
	
	@Column(name="data_of_registration")
	private LocalDate dataOfRegistration;
	
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="amount_paid")
	private double amountPaid;
	
	@Column(name="amount_due")
	private double amountDue;

}
