package com.shura_crud.shura_stack.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hero {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String HeroName;
    private String Department;
    private int rank;
}
