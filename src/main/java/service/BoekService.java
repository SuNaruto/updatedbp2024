package service;

import Mapper.BoekMapper;
import dto.BoekDTO;
import entity.Boek;
import repository.BoekDAO;
import java.util.List;

public class BoekService {
    private BoekDAO boekDAO;

    public BoekService(BoekDAO boekDAO) {
        this.boekDAO = boekDAO;
    }

    public void addBoek(Boek boek) {
        boekDAO.saveBoek(boek);
    }

    public Boek getBoek(int id) {
        return boekDAO.getBoek(id);
    }

    public void updateBoek(Boek boek) {
        boekDAO.updateBoek(boek);
    }

    public void deleteBoek(int id) {
        boekDAO.deleteBoek(id);
    }

    public List<BoekDTO> getAllBoeken() {
        return new BoekMapper().toDTOList(boekDAO.getAllBoeken()) ;
    }
    public boolean isBoekBeschikbaar(int boekId) {
        return boekDAO.isBoekBeschikbaar(boekId);
    }
}
