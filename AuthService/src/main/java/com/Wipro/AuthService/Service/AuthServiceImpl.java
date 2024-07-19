package com.Wipro.AuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Wipro.AuthService.Entity.UserEntity;
import com.Wipro.AuthService.Repository.UserEntityRepository;

@Service
public class AuthServiceImpl 
{
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//saving user
	public String saveUser(UserEntity userEntity)
	{
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		
		userEntityRepository.save(userEntity);
		
		return "user added";
	}
	
	public String generateToken(String username)
	{
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token)
	{
		jwtService.validateToken(token);
	}
	
	
}
