package com.camsofttech.phsarcambo.service;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.User;
import com.camsofttech.phsarcambo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IAbstractService<User> {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findAll(int page, int limit) {
        return userRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional  = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        return null;
    }

    @Override
    public User onSave(User entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public User onUpdate(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User onDelete(Long id) {
        User user = findById(id);
        if(user != null){
            userRepository.deleteById(id);
            return user;
        }
        return null;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
