package service;

import entity.BoekDetails;
import repository.BoekDetailsDAO;
import java.util.List;

public class BoekDetailsService {
    private BoekDetailsDAO boekDetailsDAO;

    public BoekDetailsService(BoekDetailsDAO boekDetailsDAO) {
        this.boekDetailsDAO = boekDetailsDAO;
    }

    public void addBoekDetails(BoekDetails boekDetails) {
        boekDetailsDAO.saveBoekDetails(boekDetails);
    }

    public BoekDetails getBoekDetails(int id) {
        return boekDetailsDAO.getBoekDetails(id);
    }

    public void updateBoekDetails(BoekDetails boekDetails) {
        boekDetailsDAO.updateBoekDetails(boekDetails);
    }

    public void deleteBoekDetails(int id) {
        boekDetailsDAO.deleteBoekDetails(id);
    }

}
