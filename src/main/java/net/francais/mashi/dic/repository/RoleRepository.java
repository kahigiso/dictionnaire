package net.francais.mashi.dic.repository;

import net.francais.mashi.dic.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String name);

}
