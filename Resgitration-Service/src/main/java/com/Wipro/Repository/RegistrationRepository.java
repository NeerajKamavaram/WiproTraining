package com.Wipro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.Entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer>
{

}
