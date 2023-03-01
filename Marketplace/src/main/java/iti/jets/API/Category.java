package iti.jets.API;

import jakarta.ws.rs.Produces;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/category")
public class Category {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public iti.jets.DTO.Category getCategory(@PathParam("id") int id) {
        return new iti.jets.mappers.CategoryMapper().getCategory(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<iti.jets.DTO.Category> getCategorys() {
        return new iti.jets.mappers.CategoryMapper().getCategorys();
    }

}
