package com.bookcatalog.sprigboot.service.impl;

import com.bookcatalog.sprigboot.dto.LoginDTO;
import com.bookcatalog.sprigboot.dto.UserDTO;
import com.bookcatalog.sprigboot.entity.Login;
import com.bookcatalog.sprigboot.entity.Register;
import com.bookcatalog.sprigboot.entity.User;
import com.bookcatalog.sprigboot.repo.LoginRepo;
import com.bookcatalog.sprigboot.repo.UserRepo;
import com.bookcatalog.sprigboot.service.LoginService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepo loginRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;




    @Override
    public boolean checkLogin(LoginDTO loginDTO) {
        String password=loginDTO.getLoginPsd();
        String email=loginDTO.getLoginEmail();
        boolean b = userRepo.existsByPasswordAndEmail(password,email);


        if (b) {
            System.out.println("wada wada..");

            return true;
        } else {
            throw new RuntimeException("Enter Correct Details..!");
        }
    }
}