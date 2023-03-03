package iti.jets.api;

import jakarta.ws.rs.Produces;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/category")
public class CategoryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public iti.jets.dto.CategoryDTO getCategory(@PathParam("id") int id) {
        return new iti.jets.mappers.CategoryMapper().getCategory(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<iti.jets.dto.CategoryDTO> getCategorys() {
        return new iti.jets.mappers.CategoryMapper().getCategorys();
    }

}
