package com.udacity.jdnd.course3.critter.service.Impl;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Pet savePet(Pet pet) {
        Pet createdPet = petRepository.save(pet);
        Customer owner = createdPet.getOwner();
        List<Pet> ownerPets = owner.getPets();
        if(ownerPets == null)
            ownerPets = new ArrayList<>();
        ownerPets.add(createdPet);
        owner.setPets(ownerPets);
        customerRepository.save(owner);
        return createdPet;
    }

    @Override
    public Pet getPet(long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getPetsByOwner(long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    public List<Pet> mapIdsToPets(List<Long> petIds){
        if(petIds == null)
            return null;
        return petRepository.findAllById(petIds);
    }

    public List<Long> mapPetsToIds(List<Pet> pets){
        if(pets == null)
            return null;
        return pets.stream().map(Pet::getId).collect(Collectors.toList());
    }
}
