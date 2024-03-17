package controller;

import entity.BoekDetails;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.BoekDetailsService;
import repository.BoekDetailsDAO;
import java.util.List;

@Path("/boekdetails")
public class BoekDetailsController {

    private BoekDetailsService boekDetailsService;

    public BoekDetailsController() {
        // Creation of EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat_persistence");
        this.boekDetailsService = new BoekDetailsService(new BoekDetailsDAO(emf));
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBoekDetails(BoekDetails boekDetails) {
        boekDetailsService.addBoekDetails(boekDetails);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BoekDetails getBoekDetails(@PathParam("id") int id) {
        return boekDetailsService.getBoekDetails(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBoekDetails(BoekDetails boekDetails) {
        boekDetailsService.updateBoekDetails(boekDetails);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteBoekDetails(@PathParam("id") int id) {
        boekDetailsService.deleteBoekDetails(id);
    }

}
