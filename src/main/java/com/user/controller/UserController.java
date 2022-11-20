package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.payloadssignin.UserDto;
import com.user.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/us")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
	{
		UserDto updateUser =this.userservice.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);
		
	}
	
	// @DeleteMapping("/{userId}")
	
	//	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid)
	//	{
		 
	//	 this.deleteUser(uid);
	//		return null;
		
	
		}
	
	
//}
