package com.bookcatalog.sprigboot.repo;

import com.bookcatalog.sprigboot.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    boolean existsByPasswordAndEmail(String password, String email);


   //==============================================================================
   @Modifying
   @Transactional
    @Query(value = "UPDATE user SET image=:image WHERE userID=:userID", nativeQuery = true)
    void updateFilePaths(@Param("image") String image, @Param("userID") String userID);
}
