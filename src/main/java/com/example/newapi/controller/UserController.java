package com.example.newapi.controller;

import com.example.newapi.domain.model.User;
import com.example.newapi.domain.service.IUserService;
import com.example.newapi.resource.SaveUserResource;
import com.example.newapi.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IUserService userService;
    //Conversiones
    private User convertToEntity(SaveUserResource resource){
        return mapper.map(resource, User.class);
    }
    private UserResource convertToResource(User entity){
        return mapper.map(entity,UserResource.class);
    }

    @GetMapping("/users")
    @Operation(summary = "Get all users", tags = {"users"})
    public List<UserResource> getAllUsers(){
        List<UserResource> resources = userService.getAllUsers()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return resources;
    }

    @PostMapping("/users")
    @Operation(summary = "create a user", tags = {"users"})
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

}
