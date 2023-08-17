package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieCommentRepository extends JpaRepository<MovieComment, Long> {
}
