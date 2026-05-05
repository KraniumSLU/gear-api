package com.kranium.project.gearapi.modules.users.application;

import com.kranium.project.gearapi.modules.identity.inheritanceClass.exceptions.IdNotFoundException;
import com.kranium.project.gearapi.modules.users.api.dtos.UserMapper;
import com.kranium.project.gearapi.modules.users.api.dtos.UserRequest;
import com.kranium.project.gearapi.modules.users.api.dtos.UserResponse;
import com.kranium.project.gearapi.modules.users.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class UserServiceImp implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Page<UserResponse> findUsers(Pageable pageable) {
            log.info("Listing users");
            return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Override
    public UserResponse findUserById(UUID uuid) {
        log.info("Searching user by id: {}", uuid);
        return repository.findById(uuid)
                .map(mapper::toResponse)
                .orElseThrow(()-> new IdNotFoundException("ID not found :",uuid));
    }
    @Transactional
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        validateEmail(userRequest.email());
        validateUsername(userRequest.username());
        var entity = mapper.toEntity(userRequest);
        entity.setPassword(passwordEncoder.encode(userRequest.password()));
        var create = repository.save(mapper.toEntity(userRequest));
        return mapper.toResponse(create);
    }
    @Transactional
    @Override
    public UserResponse updateUser(UUID uuid, UserRequest userRequest) {
        var findUserId = repository.findById(uuid).orElseThrow(()-> new IdNotFoundException("Id not found: ",uuid));
        findUserId.setUsername(userRequest.username());
        if (userRequest.password()!=null && !userRequest.password().isBlank()){
            findUserId.setPassword(passwordEncoder.encode(userRequest.password()));
        }
        findUserId.setEmail(userRequest.email());
        findUserId.setRole(userRequest.role());
        findUserId.setAtivo(userRequest.ativo());
        findUserId.setDataNasci(userRequest.dataNasci());
        log.info("User updated successfully: {}", uuid);
        return mapper.toResponse(findUserId);
    }

    @Override
    public void deleteUser(UUID uuid) {
        var findUserId = repository.findById(uuid).orElseThrow(()-> new IdNotFoundException("Id not found: ",uuid));
        repository.delete(findUserId);
        log.info("User deleted successfully. ID: {}", uuid);
    }

    @Override
    public void validateEmail(String email) {
      if (repository.existsByEmail(email)){
          throw new IllegalArgumentException("E-mail already exists");
      }

    }

    @Override
    public void validateUsername(String username) {
        if (repository.existsByUsername(username)){
            throw new IllegalArgumentException("Username already exists");
        }
    }
}
