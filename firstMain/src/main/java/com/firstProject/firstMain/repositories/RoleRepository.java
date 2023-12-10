package com.firstProject.firstMain.repositories;


import com.firstProject.firstMain.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends CrudRepository<Role, Integer>{

    Optional<Role> findByName(String name);
}
