package controller;

import dto.LidDTO;
import entity.Lid;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import repository.LidDAO;
import service.LidService;

import java.util.List;

@Path("/lid")
public class LidController {

    private LidService lidService;

    public LidController() {
        // Aanmaken van EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat_persistence");
        this.lidService = new LidService(new LidDAO(emf)); // Geef de LidDAO met de EntityManagerFactory aan de LidService
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLid(Lid lid) {
        lidService.addLid(lid);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lid getLid(@PathParam("id") int id) {
        return lidService.getLid(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateLid(Lid lid) {
        lidService.updateLid(lid);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteLid(@PathParam("id") int id) {
        lidService.deleteLid(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LidDTO> getAllLeden() {
        return lidService.getAllLeden();
    }
}
