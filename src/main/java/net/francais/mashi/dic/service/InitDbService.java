package net.francais.mashi.dic.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import net.francais.mashi.dic.entity.Role;
import net.francais.mashi.dic.entity.User;
import net.francais.mashi.dic.repository.ClassificationRepository;
import net.francais.mashi.dic.repository.DomaineRepository;
import net.francais.mashi.dic.repository.ExampleRepository;
import net.francais.mashi.dic.repository.LangueOrigineRepository;
import net.francais.mashi.dic.repository.MotFrancaisRepository;
import net.francais.mashi.dic.repository.MotMashiRepository;
import net.francais.mashi.dic.repository.NatureRepository;
import net.francais.mashi.dic.repository.RoleRepository;
import net.francais.mashi.dic.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NatureRepository natureRepository;
	@Autowired
	private MotFrancaisRepository motFrancaisRepository;
	@Autowired
	private MotMashiRepository motMashiRepository;
	@Autowired
	private LangueOrigineRepository langueOrigineRepository;
	@Autowired
	private ExampleRepository exampleRepository;
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private ClassificationRepository classificationRepository;
	
	
	@PostConstruct
	public void init(){
		System.out.println("Got here!");
		Map<String,Role> roles =  createRole();
		Map<String,User> users = createUser(roles);
		System.out.println("End here!");
	}
	
	private Map<String,User> createUser(Map<String,Role> roles){
		 
		 Map<String,User> users = new HashMap<String,User>();
		 
		 User admin = new User();
		 admin.setFirstName("f admin");
		 admin.setLastName("l admin");
		 admin.setConfirmed(true);
		 admin.setActive(true);
		 admin.setEmail("admin@gmail.com");
		 admin.setPassword("admin");
		 admin.addRole(roles.get("ADMIN_ROLE"));
		 userRepository.save(admin);
		 
		 User adminTwo = new User();
		 adminTwo.setFirstName("f adminTwo");
		 adminTwo.setLastName("l adminTwo");
		 adminTwo.setEmail("adminTwo@gmail.com");
		 adminTwo.setPassword("adminTwo");
		 adminTwo.addRole(roles.get("ADMIN_ROLE"));
		 userRepository.save(adminTwo);
		 
		 User managerOne = new User();
		 managerOne.setFirstName("f managerOne");
		 managerOne.setLastName("l managerOne");
		 managerOne.setConfirmed(true);
		 managerOne.setActive(true);
		 managerOne.setEmail("managerOne@gmail.com");
		 managerOne.setPassword("managerOne");
		 managerOne.addRole(roles.get("MANAGER_ROLE"));
		 userRepository.save(managerOne);
		 
		 User managerTwo = new User();
		 managerTwo.setFirstName("f managerTwo");
		 managerTwo.setLastName("l managerTwo");
		 managerTwo.setEmail("managerTwo@gmail.com");
		 managerTwo.setPassword("managerTwo");
		 managerTwo.addRole(roles.get("MANAGER_ROLE"));
		 userRepository.save(managerTwo);
		 
		 User contributorOne = new User();
		 contributorOne.setFirstName("f contributorOne");
		 contributorOne.setLastName("l contributorOne");
		 managerOne.setConfirmed(true);
		 managerOne.setActive(true);
		 contributorOne.setEmail("contributorOne@gmail.com");
		 contributorOne.setPassword("contributorOne");
		 contributorOne.addRole(roles.get("CONTRIBUTOR_ROLE"));
		 userRepository.save(contributorOne);
		 
		 User contributorTwo = new User();
		 contributorTwo.setFirstName("f contributorTwo");
		 contributorTwo.setLastName("l contributorTwo");
		 contributorTwo.setEmail("contributorTwo@gmail.com");
		 contributorTwo.setPassword("contributorTwo");
		 contributorTwo.addRole(roles.get("CONTRIBUTOR_ROLE"));
		 userRepository.save(contributorTwo);
		 
		 User combinedUser = new User();
		 combinedUser.setFirstName("f combinedUser");
		 combinedUser.setLastName("l combinedUser");
		 combinedUser.setEmail("combinedUser@gmail.com");
		 combinedUser.setPassword("combinedUser");
		 combinedUser.addRole(roles.get("ADMIN_ROLE"));
		 combinedUser.addRole(roles.get("MANAGER_ROLE"));
		 combinedUser.addRole(roles.get("CONTRIBUTOR_ROLE"));
		 userRepository.save(combinedUser);
		 
		 users.put(admin.getEmail(), admin);
		 users.put(adminTwo.getEmail(), adminTwo);
		 users.put(managerOne.getEmail(), managerOne);
		 users.put(managerTwo.getEmail(), managerTwo);
		 users.put(contributorOne.getEmail(), contributorOne);
		 users.put(contributorTwo.getEmail(), contributorTwo);
		 users.put(combinedUser.getEmail(), combinedUser);
		 
//		 for(User user: users.values())
//			 System.out.println("user: "+user.fullName()+" role: "+roles.get(0).getCode());
		 
		 return users;
	}
	
	private Map<String,Role> createRole(){
		 Map<String,Role> roles = new HashMap<String,Role>();
		 
		 Role adminRole = new Role();
		 adminRole.setCode("ADMIN_ROLE");
		 adminRole.setName("Administrator Role");
		 roleRepository.save(adminRole);
		 
		 Role managerRole = new Role();
		 managerRole.setCode("MANAGER_ROLE");
		 managerRole.setName("Manager Role");
		 roleRepository.save(managerRole);
		 
		 Role contributorRole = new Role();
		 contributorRole.setCode("CONTRIBUTOR_ROLE");
		 contributorRole.setName("Contributor Role");
		 roleRepository.save(contributorRole);
		 
		 roles.put(adminRole.getCode(), adminRole);
		 roles.put(managerRole.getCode(), managerRole);
		 roles.put(contributorRole.getCode(), contributorRole);
		 
		 return roles;
	}

}
