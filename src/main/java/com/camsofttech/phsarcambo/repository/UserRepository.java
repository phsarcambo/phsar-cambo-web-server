package com.camsofttech.phsarcambo.repository;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
