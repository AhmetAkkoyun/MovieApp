package com.ahmetakkoyun.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection // movie ve genrelerden bir ara tablo oluşturacak. çünkü tek hücrede liste tutulamaz
    private Set<Long> genres;

    private String language;

    private String image;

    private String name;

    private String country;

    private Double rating;

    @Lob
    private String summary;

    private LocalDate premired;

    private String url;

    @ElementCollection
    private Set<Long> comments;


}
