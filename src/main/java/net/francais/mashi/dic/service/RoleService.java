package net.francais.mashi.dic.service;



import java.util.List;

import net.francais.mashi.dic.entity.Role;
import net.francais.mashi.dic.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	public void createOrUpdate(Role role) {
		roleRepository.save(role);
	}
	
	public void delete(Long id) {
		roleRepository.delete(id);
	}

	public Role find(Long id) {
		return roleRepository.findOne(id);
	}
	public List<Role > findAll(){
		return roleRepository.findAll();
	}

	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}
