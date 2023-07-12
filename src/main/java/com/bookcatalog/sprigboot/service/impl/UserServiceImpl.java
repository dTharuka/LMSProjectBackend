package com.bookcatalog.sprigboot.service.impl;

import com.bookcatalog.sprigboot.dto.UserDTO;
import com.bookcatalog.sprigboot.entity.User;
import com.bookcatalog.sprigboot.repo.UserRepo;
import com.bookcatalog.sprigboot.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserID())) {
            throw new RuntimeException("User Already Exists!");
        } else {
            userRepo.save(modelMapper.map(userDTO, User.class));
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserID())) {
            userRepo.save(modelMapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException("cannot find this kind of id");
        }
    }

    @Override
    public void deleteUser(String code) {
        if (userRepo.existsById(code)) {
            userRepo.deleteById(code);
        } else {
            throw new RuntimeException("No Such a user");
        }
    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new RuntimeException("No such user with this id: " + id);
        }

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepo.findAll(), new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public void uploadImages(String image, String userID) {
        userRepo.updateFilePaths(image, userID);
    }
}
