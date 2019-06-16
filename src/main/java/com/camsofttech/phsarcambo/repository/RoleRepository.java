package com.camsofttech.phsarcambo.repository;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}
