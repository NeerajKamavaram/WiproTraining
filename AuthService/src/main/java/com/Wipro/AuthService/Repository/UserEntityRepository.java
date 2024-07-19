package com.Wipro.AuthService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.AuthService.Entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>
{
	Optional<UserEntity> findByUsername(String userName);
}
