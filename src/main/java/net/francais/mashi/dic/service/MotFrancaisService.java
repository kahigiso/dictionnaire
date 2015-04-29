package net.francais.mashi.dic.service;

import net.francais.mashi.dic.entity.MotFrancais;
import net.francais.mashi.dic.repository.MotFrancaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MotFrancaisService {

	
	@Autowired
	private MotFrancaisRepository motFrancaisRepository;
	
	
	public MotFrancais createOrUpdate(MotFrancais motFrancais) {
		return motFrancaisRepository.save(motFrancais);
	}
	
	public MotFrancais findByMot(String mot){
		return motFrancaisRepository.findByMot(mot);
	}

}
