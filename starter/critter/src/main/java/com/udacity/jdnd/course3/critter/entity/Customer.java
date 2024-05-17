package com.udacity.jdnd.course3.critter.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;
    private String notes;
}
