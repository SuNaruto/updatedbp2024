package controller;

import dto.BoekDTO;
import entity.Boek;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import repository.BoekDAO;
import service.BoekService;
import java.util.List;

@Path("/boek")
public class BoekController {

    private BoekService boekService;

    public BoekController() {
        // Aanmaken van EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat_persistence");
        this.boekService = new BoekService(new BoekDAO(emf));
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBoek(Boek boek) {
        boekService.addBoek(boek);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boek getBoek(@PathParam("id") int id) {
        return boekService.getBoek(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateBoek(Boek boek) {
        boekService.updateBoek(boek);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteBoek(@PathParam("id") int id) {
        boekService.deleteBoek(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BoekDTO> getAllBoeken() {
        return boekService.getAllBoeken();
    }
}
