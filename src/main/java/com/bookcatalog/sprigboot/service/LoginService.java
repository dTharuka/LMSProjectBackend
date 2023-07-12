package com.bookcatalog.sprigboot.service;

import com.bookcatalog.sprigboot.dto.LoginDTO;


public interface LoginService{

    boolean checkLogin(LoginDTO loginDTO);
}
