package com.bookcatalog.sprigboot.controller;

import com.bookcatalog.sprigboot.dto.LoginDTO;
import com.bookcatalog.sprigboot.service.LoginService;
import com.bookcatalog.sprigboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login/")
public class LoginController {
    @Autowired
    private LoginService loginService;

    // http://localhost:8080/api/v1/login/check-login
    @PostMapping(value = "check-login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkLogin(@RequestBody LoginDTO loginDTO) {
        String token="9cfd6bf5b3d09bcc3fa918fcacf5e56405e1eac40d6fe4479775d80eb5ae8e2fc2b300081e038903ef6c677f04bf954c0a189e6cafdf2a013277851ea5c4e2b0";

        loginService.checkLogin(loginDTO);
        return new ResponseUtil("OK", "Successfully Login!!", token);
    }
}
