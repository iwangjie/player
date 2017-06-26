package com.onblur7.repository;


import com.onblur7.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ronger on 2017/6/25.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
