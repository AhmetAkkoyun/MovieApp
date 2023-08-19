package com.ahmetakkoyun.sevice;

import com.ahmetakkoyun.repository.IMovieRepository;
import com.ahmetakkoyun.repository.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<Movie> findAllByPremiredBefore(String date){
        LocalDate myDate = null;
        try {
            myDate = LocalDate.parse(date);   // string değeri date değere çevirmemiz lazım
        } catch (Exception e){
            throw new RuntimeException(e.toString());
        }
        return movieRepository.findAllByPremiredBefore(myDate);
    }

}
