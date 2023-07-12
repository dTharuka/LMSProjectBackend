package com.bookcatalog.sprigboot.controller;

import com.bookcatalog.sprigboot.dto.RegisterDTO;
import com.bookcatalog.sprigboot.dto.UserDTO;
import com.bookcatalog.sprigboot.service.RegisterService;
import com.bookcatalog.sprigboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/register/")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    // http://localhost:8080/api/v1/register/get-all-registers
    @GetMapping("get-all-registers")
    public ResponseUtil getAllRegister() {
        return new ResponseUtil("OK", "Success!", registerService.getAllRegister());
    }

    // http://localhost:8080/api/v1/register/save-register
    @PostMapping(value = "save-register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil createRegister(@RequestBody RegisterDTO registerDTO) {
        registerService.saveRegister(registerDTO);
        return new ResponseUtil("OK", "Successfully Registered!", registerDTO);
    }

    // http://localhost:8080/api/v1/register/update-register
    @PutMapping("update-register")
    public ResponseUtil updateRegister(@RequestBody RegisterDTO registerDTO) {
        registerService.updateRegister(registerDTO);
        return new ResponseUtil("OK", "Update Success!", registerDTO);
    }

    // http://localhost:8080/api/v1/register/delete-register/2
    @DeleteMapping("delete-register/{id}")
    public ResponseUtil deleteRegister(@PathVariable String id) {
        registerService.deleteRegister(id);
        return new ResponseUtil("OK", "Deleted!", id);
    }

    // http://localhost:8080/api/v1/register/search/{id}
    @GetMapping(value = "search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRegisterById(@PathVariable String id) {
        RegisterDTO registerDTO = registerService.searchRegister(id);
        return new ResponseUtil("OK", "Found", registerDTO);
    }
}
