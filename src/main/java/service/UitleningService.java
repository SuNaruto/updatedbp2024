package service;

import Mapper.BoekMapper;
import Mapper.LidMapper;
import Mapper.UitleningMapper;
import dto.UitleningDTO;
import entity.Uitlening;
import repository.UitleningDAO;
import java.util.List;

public class UitleningService {
    private UitleningDAO uitleningDAO;

    public UitleningService(UitleningDAO uitleningDAO) {
        this.uitleningDAO = uitleningDAO;
    }

    public void addUitlening(Uitlening uitlening) {
        uitleningDAO.saveUitlening(uitlening);
    }

    public Uitlening getUitlening(int id) {
        return uitleningDAO.getUitlening(id);
    }

    public void updateUitlening(Uitlening uitlening) {
        uitleningDAO.updateUitlening(uitlening);
    }

    public void deleteUitlening(int id) {
        uitleningDAO.deleteUitlening(id);
    }

    public List<UitleningDTO> getAllUitleningen() {
        return new UitleningMapper(new LidMapper(), new BoekMapper()).toDTOList(uitleningDAO.getAllUitleningen()) ;
    }
}
