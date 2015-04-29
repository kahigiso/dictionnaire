package net.francais.mashi.dic.repository;

import net.francais.mashi.dic.entity.MotMashi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotMashiRepository extends JpaRepository<MotMashi, Integer>{

	MotMashi findByMot(String mot);

}
