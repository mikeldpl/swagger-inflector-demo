package com.github.mikeldpl.inflector.jaxrs.resources;

import com.github.mikeldpl.model.Pet;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/test")
public class TestResource {

    @POST
    public Pet createPet(Pet pet) {
        return pet;
    }
}
