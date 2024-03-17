package controller;

import entity.Categorie;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import repository.CategorieDAO;
import service.CategorieService;
import java.util.List;

@Path("/categorie")
public class CategorieController {

    private CategorieService categorieService;

    public CategorieController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat_persistence");
        this.categorieService = new CategorieService(new CategorieDAO(emf));
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategorie(Categorie categorie) {
        categorieService.addCategorie(categorie);
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie getCategorie(@PathParam("id") int id) {
        return categorieService.getCategorie(id);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCategorie(Categorie categorie) {
        categorieService.updateCategorie(categorie);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteCategorie(@PathParam("id") int id) {
        categorieService.deleteCategorie(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getAllCategorieen() {
        return categorieService.getAllCategorieen();
    }
}
