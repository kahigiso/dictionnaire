package net.francais.mashi.dic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.francais.mashi.dic.entity.User;
import net.francais.mashi.dic.repository.UserRepository;

@Transactional
@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	public List<User > findAll(){
		
		return userRepository.findAll();
	}
	
	public User createUser(User user){
		return userRepository.save(user);
	}
	
	public boolean doesUserWithIdExist(Integer id){
		return userRepository.exists(id);
	}
	
	public void deleteUser(User user){
		userRepository.delete(user);
	}
	public void deleteUserById(Integer id){
		userRepository.delete(id);
	}
	
	public User getUserById(Integer id){
		return userRepository.findOne(id);
	}
	
}
