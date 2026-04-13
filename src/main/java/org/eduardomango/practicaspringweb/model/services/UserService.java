package org.eduardomango.practicaspringweb.model.services;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.eduardomango.practicaspringweb.model.Mapper.UserMapper;
import org.eduardomango.practicaspringweb.model.entities.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IRepository<UserEntity> userRepository;

    public UserService(IRepository<UserEntity> userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public UserDTO findById(long id) {
        UserEntity userEntity = userRepository.findAll()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
        UserMapper userMapper= new UserMapper();
        return userMapper.toDTO(userEntity);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public UserEntity findByEmail(String email){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public void save(UserEntity user) {
        userRepository.save(user);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    public void update(UserEntity user) {
        userRepository.update(user);
    }
}
