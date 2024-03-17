package Mapper;
import dto.UitleningDTO;
import entity.Uitlening;

import java.util.List;
import java.util.stream.Collectors;

public class UitleningMapper implements EntityMapper<Uitlening, UitleningDTO> {

    private final LidMapper lidMapper;
    private final BoekMapper boekMapper;

    public UitleningMapper(LidMapper lidMapper, BoekMapper boekMapper) {
        this.lidMapper = lidMapper;
        this.boekMapper = boekMapper;
    }

    @Override
    public UitleningDTO toDTO(Uitlening uitlening) {
        UitleningDTO uitleningDTO = new UitleningDTO();
        uitleningDTO.setUitlening_id(uitlening.getUitlening_id());
        uitleningDTO.setUitgeleendOp(uitlening.getUitgeleendOp());
        uitleningDTO.setTeruggebrachtOp(uitlening.getTeruggebrachtOp());
        uitleningDTO.setLid(lidMapper.toDTO(uitlening.getLid()));
        uitleningDTO.setBoek(boekMapper.toDTO(uitlening.getBoek()));
        return uitleningDTO;
    }

    @Override
    public List<UitleningDTO> toDTOList(List<Uitlening> uitleningen) {
        return uitleningen.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

