package org.eduardomango.practicaspringweb.model.Mapper;

import org.eduardomango.practicaspringweb.model.entities.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.modelmapper.ModelMapper;

public class UserMapper implements Mapper <UserDTO, UserEntity> {
    private ModelMapper modelMapper;


    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO,UserEntity.class);
    }

    @Override
    public UserDTO toDTO(UserEntity user) {
        return modelMapper.map(user,UserDTO.class);
    }
}
