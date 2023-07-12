package com.bookcatalog.sprigboot.service;

import com.bookcatalog.sprigboot.dto.RegisterDTO;
import com.bookcatalog.sprigboot.dto.UserDTO;

import java.util.List;

public interface RegisterService {
    void saveRegister(RegisterDTO registerDTO);

    void updateRegister(RegisterDTO registerDTO);

    void deleteRegister(String code);

    RegisterDTO searchRegister(String id);

    List<RegisterDTO> getAllRegister();
}
