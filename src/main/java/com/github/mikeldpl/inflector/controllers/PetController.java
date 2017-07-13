package com.github.mikeldpl.inflector.controllers;

import com.github.mikeldpl.inflector.services.PetService;
import com.github.mikeldpl.model.Pet;
import io.swagger.inflector.models.RequestContext;
import io.swagger.inflector.models.ResponseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.Response;
import java.util.Set;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    public ResponseContext getPets(RequestContext requestContext, Integer size) {
        Set<Pet> pets = petService.getPets(size);
        return new ResponseContext().status(Response.Status.CREATED).entity(pets);
    }

    public ResponseContext createPet(RequestContext requestContext, Pet pet) {
        return new ResponseContext().status(200).entity(pet);
    }
}
