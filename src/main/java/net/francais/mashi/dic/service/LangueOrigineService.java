package net.francais.mashi.dic.service;

import net.francais.mashi.dic.entity.LangueOrigine;
import net.francais.mashi.dic.repository.LangueOrigineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class LangueOrigineService {

	
	@Autowired
	private LangueOrigineRepository langueOrigineRepository;
	
	public LangueOrigine createOrUpdate(LangueOrigine lOrigine) {
		return langueOrigineRepository.save(lOrigine);
	}
	
	public LangueOrigine findByName(String name){
		return langueOrigineRepository.findByName(name);
	}

}
