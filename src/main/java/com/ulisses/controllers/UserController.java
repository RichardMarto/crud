package com.ulisses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ulisses.repo.UserRepository;
import com.ulisses.users.User;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
//        User existingUser = userRepository.findOne(id);
//        if (existingUser != null) {
//            // Copiar os valores dos campos do newUser para o existingUser
//            existingUser.setName(newUser.getName());
//            existingUser.setEmail(newUser.getEmail());
//            // Se houver outros campos, copie-os da mesma forma
//    
//            // Salvar o usuário atualizado
//            User updatedUser = userRepository.save(existingUser);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User existingUser = userRepository.findOne(id);
//        if (existingUser != null) {
//            user.setId(id);
//            User updatedUser = userRepository.save(user);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User userToDelete = userRepository.findOne(id);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
