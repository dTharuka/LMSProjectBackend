package com.bookcatalog.sprigboot.repo;

import com.bookcatalog.sprigboot.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register,String> {
}
