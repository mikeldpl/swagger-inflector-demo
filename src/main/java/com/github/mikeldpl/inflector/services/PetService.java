package com.github.mikeldpl.inflector.services;

import com.github.mikeldpl.inflector.exceptions.DemoException;
import com.github.mikeldpl.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PetService {

    public Set<Pet> getPets(Integer size) {

        if (Math.random() > 0.5) {
            throw new DemoException("test");
        }

        return IntStream.range(0, size).mapToObj(value -> {
            Pet pet = new Pet();
            pet.setName("Pet" + value);
            pet.setSize(ThreadLocalRandom.current().nextLong());
            return pet;
        }).collect(Collectors.toSet());
    }
}
