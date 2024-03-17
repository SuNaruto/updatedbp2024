package service;

import entity.Categorie;
import repository.CategorieDAO;
import java.util.List;

public class CategorieService {
    private CategorieDAO categorieDAO;

    public CategorieService(CategorieDAO categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    public void addCategorie(Categorie categorie) {
        categorieDAO.saveCategorie(categorie);
    }

    public Categorie getCategorie(int id) {
        return categorieDAO.getCategorie(id);
    }

    public void updateCategorie(Categorie categorie) {
        categorieDAO.updateCategorie(categorie);
    }

    public void deleteCategorie(int id) {
        categorieDAO.deleteCategorie(id);
    }

    public List<Categorie> getAllCategorieen() {
        return categorieDAO.getAllCategorieen();
    }
}
