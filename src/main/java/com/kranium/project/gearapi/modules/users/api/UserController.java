package com.kranium.project.gearapi.modules.users.api;

import com.kranium.project.gearapi.modules.users.api.dtos.UserRequest;
import com.kranium.project.gearapi.modules.users.api.dtos.UserResponse;
import com.kranium.project.gearapi.modules.users.application.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Page<UserResponse>>findAllUsers(@PageableDefault(size = 10,sort = "username") Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsers(pageable));
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse>findUserById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse>createUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse>updateUser(@PathVariable UUID id,@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,userRequest));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
