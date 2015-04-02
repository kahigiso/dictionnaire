package net.francais.mashi.dic.repository;

import net.francais.mashi.dic.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

}
