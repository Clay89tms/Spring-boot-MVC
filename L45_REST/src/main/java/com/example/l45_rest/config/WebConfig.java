package com.example.l45_rest.config;

import com.example.l45_rest.component.UserEntity;
import com.example.l45_rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class WebConfig {

    private final UserRepository repository;

    @GetMapping
    public List<UserEntity> getAll(){
        List<UserEntity> all = repository.findAll();
        return all;
    }

    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        UserEntity userSaved = repository.save(user);
        return ResponseEntity.ok(userSaved);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id){
        Optional<UserEntity> userById = repository.findById(id);

        if(userById.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }
}
