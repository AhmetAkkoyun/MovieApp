package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
