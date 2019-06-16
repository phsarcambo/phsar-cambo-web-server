package com.camsofttech.phsarcambo.service;

/*
 * @author : chhai chivon on 2/26/2019.
 * Software Engineer
 */

import com.camsofttech.phsarcambo.model.Role;
import com.camsofttech.phsarcambo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IAbstractService<Role> {

    private RoleRepository  roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Page<Role> findAll(int page, int limit) {
        return roleRepository.findAll(new PageRequest(page,limit));
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> roleOptional  = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            return roleOptional.get();
        }
        return null;
    }

    @Override
    public Role onSave(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role onUpdate(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role onDelete(Long id) {
        Role role = findById(id);
        if(role  != null){
            roleRepository.deleteById(id);
            return role;
        }
        return null;
    }

    public Role findByRoleName(String roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
