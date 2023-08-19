package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByPremiredBefore(LocalDate date);

}



