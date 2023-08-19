package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.repository.enums.EUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


//    "SELECT u FROM User AS u WHERE u.email =?1 AND u.password =?2"   // 1 -> email,  2 -> password
    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByPasswordAndEmail(String password, String email);

    List<User> findAllByUserType(EUserType userType);

//    @Query // Spring metotları yetersiz kalırsa kendimiz metot oluşturup query yazabiliriz.
//    User yeniMetot();

    List<User> findAllByOrderByName();

    List<User> findAllByOrderByNameDesc();

    List<User> findAllByNameContainingIgnoreCase(String value);

    List<User> findAllByEmailContainingIgnoreCase(String value);

    List<User> findAllByEmailEndingWith(String value);

    @Query(
            "SELECT u " +
            "FROM User AS u " +
            "WHERE length(u.password)>?1"     // ?1 değeri metottaki 1. parametre demek.
    )
    List<User> paswordLongerThan(int value);

    @Query(
            "SELECT u " +
            "FROM User AS u " +
            "WHERE length(u.password)>:x"     // x değeri aşağıda @Param ile value değerine eşitlenecek
    )
    List<User> paswordLongerThan2(@Param("x") int value);

    @Query(
            value = "SELECT * " +
            "FROM tbl_user AS u " +
            "WHERE length(u.password)>:?1"
    , nativeQuery = true)    // nativeQuery ile direk sql dilinde yazabiliriz.
    List<User> paswordLongerThan3(@Param("x") int value);















}
