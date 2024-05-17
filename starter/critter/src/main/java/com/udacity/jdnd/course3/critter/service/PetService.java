package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Pet;

import javax.transaction.Transactional;
import java.util.List;

public interface PetService {
    Pet savePet(Pet pet);

    Pet getPet(long petId);

    List<Pet> getPets();

    List<Pet> getPetsByOwner(long ownerId);

}
