package Mapper;

import dto.BoekDTO;
import entity.Boek;

import java.util.List;
import java.util.stream.Collectors;

public class BoekMapper implements EntityMapper<Boek, BoekDTO> {

    @Override
    public BoekDTO toDTO(Boek boek) {
        BoekDTO boekDTO = new BoekDTO();
        boekDTO.setBoek_id(boek.getBoek_id());
        boekDTO.setTitel(boek.getTitel());
        boekDTO.setAuteur(boek.getAuteur());
        boekDTO.setAantal(boek.getAantal());
        return boekDTO;
    }

    @Override
    public List<BoekDTO> toDTOList(List<Boek> boeken) {
        return boeken.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
