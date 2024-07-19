package com.Wipro.AuthService.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Wipro.AuthService.Entity.UserEntity;
import com.Wipro.AuthService.Repository.UserEntityRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserEntity> credential=userEntityRepository.findByUsername(username);
		
		if(credential.isEmpty())
		{
			throw new UsernameNotFoundException("user not found with name :"+username);
		}
		
		return new CustomUserDetails(credential.get());
		
	}

}
