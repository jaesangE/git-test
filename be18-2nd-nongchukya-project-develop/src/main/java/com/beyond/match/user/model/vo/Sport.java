package com.beyond.match.user.model.vo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;       // PK

    @Column(nullable = false, unique = true, length = 100)
    private String name;      // 운동 이름
}