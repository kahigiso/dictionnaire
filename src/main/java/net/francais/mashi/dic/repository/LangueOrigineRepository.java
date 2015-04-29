package net.francais.mashi.dic.repository;

import net.francais.mashi.dic.entity.LangueOrigine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LangueOrigineRepository extends JpaRepository<LangueOrigine, Integer>{

	LangueOrigine findByName(String name);

}
