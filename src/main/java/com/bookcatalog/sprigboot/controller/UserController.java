package com.bookcatalog.sprigboot.controller;

import com.bookcatalog.sprigboot.dto.UserDTO;
import com.bookcatalog.sprigboot.service.UserService;
import com.bookcatalog.sprigboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/v1/user/get-all-users
    @GetMapping("get-all-users")
    public ResponseUtil getAllUsers() {
        return new ResponseUtil("OK", "Success!", userService.getAllUsers());
    }

    // http://localhost:8080/api/v1/user/save-user
    @PostMapping(value = "save-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil createUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseUtil("OK", "Successfully Registered!", userDTO);
    }

    // http://localhost:8080/api/v1/user/update-user
    @PutMapping("update-user")
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseUtil("OK", "Update Success!", userDTO);
    }

    // http://localhost:8080/api/v1/user/delete-user/2
    @DeleteMapping("delete-user/{id}")
    public ResponseUtil deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseUtil("OK", "Deleted!", id);
    }

    // http://localhost:8080/api/v1/user/search/{id}
    @GetMapping(value = "search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserById(@PathVariable String id) {
        UserDTO userDTO = userService.searchUser(id);
        return new ResponseUtil("OK", "Found", userDTO);
    }

    //===================================================================================
    // http://localhost:8080/api/v1/user//uploadImg/{id}
    @PutMapping(path = "/uploadImg/{userID}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImage(@RequestPart("image") MultipartFile image, @PathVariable String userID) {
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            image.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + image.getOriginalFilename()));

            String imageLocation = image.getOriginalFilename();
            userService.uploadImages(imageLocation, userID);

            System.out.println(imageLocation);
            return new ResponseUtil("200", "Uploaded", null);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("500",e.getMessage(),null);
        }
    }
    //===================================================================================

}
