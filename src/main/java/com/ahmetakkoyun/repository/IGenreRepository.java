package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
