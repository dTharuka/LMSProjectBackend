package com.bookcatalog.sprigboot.service;

import com.bookcatalog.sprigboot.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String code);

    UserDTO searchUser(String id);

    List<UserDTO> getAllUsers();

    void uploadImages(String image, String userID);
}
