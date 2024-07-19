package com.Wipro.AuthService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Wipro.AuthService.Entity.UserEntity;
import com.Wipro.AuthService.Model.PayLoad;
import com.Wipro.AuthService.Service.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController 
{
	@Autowired
	private AuthServiceImpl authServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserEntity userEntity)
	{
		authServiceImpl.saveUser(userEntity);
		return new ResponseEntity<>("registered",HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public String doLogin(@RequestBody PayLoad payload)
	{
        Authentication authenticate = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));
        if (authenticate.isAuthenticated()) 
        {
            return authServiceImpl.generateToken(payload.getUsername());
        } 
        else
        {
            throw new RuntimeException("invalid access");
        }
	}
	
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) 
    {
    	authServiceImpl.validateToken(token);
        return "Token is valid";
    }
	
	

}
