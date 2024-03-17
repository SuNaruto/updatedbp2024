package controller;

import dto.UitleningDTO;
import entity.Uitlening;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import repository.UitleningDAO;
import service.UitleningService;
import java.util.List;

@Path("/uitlening")
public class UitleningController {

    private UitleningService uitleningService;

    public UitleningController() {
        // Aanmaken van EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat_persistence");
        this.uitleningService = new UitleningService(new UitleningDAO(emf));
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUitlening(Uitlening uitlening) {
        uitleningService.addUitlening(uitlening);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uitlening getUitlening(@PathParam("id") int id) {
        return uitleningService.getUitlening(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUitlening(Uitlening uitlening) {
        uitleningService.updateUitlening(uitlening);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteUitlening(@PathParam("id") int id) {
        uitleningService.deleteUitlening(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UitleningDTO> getAllUitleningen() {
        return uitleningService.getAllUitleningen();
    }
}
