package com.bookcatalog.sprigboot.service.impl;

import com.bookcatalog.sprigboot.dto.RegisterDTO;
import com.bookcatalog.sprigboot.dto.UserDTO;
import com.bookcatalog.sprigboot.entity.Register;
import com.bookcatalog.sprigboot.entity.User;
import com.bookcatalog.sprigboot.repo.RegisterRepo;
import com.bookcatalog.sprigboot.service.RegisterService;
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
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRegister(RegisterDTO registerDTO) {
        if (registerRepo.existsById(registerDTO.getRegisterID())) {
            throw new RuntimeException("Registration ID is Already Exists!");
        } else {
            registerRepo.save(modelMapper.map(registerDTO, Register.class));
        }

    }

    @Override
    public void updateRegister(RegisterDTO registerDTO) {
        if (registerRepo.existsById(registerDTO.getRegisterID())) {
            registerRepo.save(modelMapper.map(registerDTO, Register.class));
        } else {
            throw new RuntimeException("cannot find this kind of id");
        }
    }

    @Override
    public void deleteRegister(String code) {
        if (registerRepo.existsById(code)) {
            registerRepo.deleteById(code);
        } else {
            throw new RuntimeException("No Such a registration");
        }
    }

    @Override
    public RegisterDTO searchRegister(String id) {

        Optional<Register> registerOptional = registerRepo.findById(id);
        if (registerOptional.isPresent()) {
            Register register = registerOptional.get();
            return modelMapper.map(register, RegisterDTO.class);
        } else {
            throw new RuntimeException("No such user with this id: " + id);
        }
    }

    @Override
    public List<RegisterDTO> getAllRegister() {
        return modelMapper.map(registerRepo.findAll(), new TypeToken<ArrayList<RegisterDTO>>() {
        }.getType());
    }
}
