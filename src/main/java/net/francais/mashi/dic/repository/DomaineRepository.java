package net.francais.mashi.dic.repository;

import net.francais.mashi.dic.entity.Domaine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DomaineRepository extends JpaRepository<Domaine,Integer>{

	Domaine findByName(String name);

}
