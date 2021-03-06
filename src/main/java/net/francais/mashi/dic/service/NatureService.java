package net.francais.mashi.dic.service;

import net.francais.mashi.dic.entity.Nature;
import net.francais.mashi.dic.repository.NatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class NatureService {

	@Autowired
	private NatureRepository natureRepository;
	
	public void createOrUpdate(Nature nature) {
		 natureRepository.save(nature);
	}

	public Nature findByName(String name){
		return natureRepository.findByName(name);
	}

}
