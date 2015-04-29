package net.francais.mashi.dic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.francais.mashi.dic.entity.User;
import net.francais.mashi.dic.repository.UserRepository;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	
	public List<User > findAll(){
		return userRepository.findAll();
	}
	
	public void createOrUpdate(User user){
		userRepository.save(user);
	}
		
	public void delete(Long id){
		userRepository.delete(id);
	}
	
	public User find(Long id){
		return userRepository.findOne(id);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
