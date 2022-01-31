package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.persistence.entity.RoleEntity;
import com.example.busticketsservice.persistence.entity.UserEntity;
import com.example.busticketsservice.persistence.repository.RoleRepository;
import com.example.busticketsservice.persistence.repository.UserRepository;
import com.example.busticketsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserEntity register(UserEntity user) {
        RoleEntity roleUser = roleRepository.findByRoleName("ROLE_USER");
        List<RoleEntity> userRole = new ArrayList<>();
        userRole.add(roleUser);

        user.setPassword(user.getPassword());
        user.setRoles(userRole);

        log.info("user {} registered",user);

        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUser() {
        log.info("From DataBase find Users");
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByEmail(String email) throws RuntimeException {

        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
           throw new UsernameNotFoundException("User with "+ email + "not found");
        }
        log.info("User :{} ,found by email:{}",user,email);
        return user;
    }

    @Override
    public UserEntity findById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new RuntimeException("User with "+ id + "not found");
        }
        log.info("User :{} ,found by id:{}",user,id);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("User with id:{} successfully delete",id);
    }
}
