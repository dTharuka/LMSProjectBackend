package com.bookcatalog.sprigboot.repo;

import com.bookcatalog.sprigboot.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,String> {
}
