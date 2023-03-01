package iti.jets.API;

import jakarta.ws.rs.Produces;

import java.util.List;

import iti.jets.repo.daoImplementation.ProductDaoImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/prodcut")
public class Product {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public iti.jets.DTO.Product getProduct(@PathParam("id") String id) {
        return new iti.jets.mappers.ProductMapper().getProduct(Integer.parseInt(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<iti.jets.DTO.Product> getProducts() {
        return new iti.jets.mappers.ProductMapper().getProducts();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        new iti.jets.mappers.ProductMapper().delete(Integer.parseInt(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(iti.jets.DTO.Product p) {
        new iti.jets.mappers.ProductMapper().insert(p);
    }

}
