package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.repository.enums.EUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


//    "SELECT u FROM User AS u WHERE u.email =? AND u.password =?"
    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByPasswordAndEmail(String password, String email);

    List<User> findAllByUserType(EUserType userType);

//    @Query // Spring metotları yetersiz kalırsa kendimiz metot oluşturup query yazabiliriz.
//    User yeniMetot();


}
