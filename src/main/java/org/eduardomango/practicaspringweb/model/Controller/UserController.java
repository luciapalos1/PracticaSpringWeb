package org.eduardomango.practicaspringweb.model.Controller;

import lombok.RequiredArgsConstructor;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService user;

    @GetMapping("/all")
    public ResponseEntity <List<UserEntity>> getAll() {
        return ResponseEntity.ok(user.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserEntity> getById (@PathVariable Long id){
            return ResponseEntity.ok(user.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser (@RequestBody UserEntity newUser){
        if(user.findAll().contains(newUser)){
           return ResponseEntity.badRequest().build();
        }
        else{
            user.save(newUser);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,@RequestBody UserEntity userUp){
       if (user.findById(id) != null) {
           user.update(userUp);
           return ResponseEntity.ok().build();
       }else {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id){
        user.delete(user.findById(id));
        return ResponseEntity.ok().build();
    }







}
