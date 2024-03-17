package Mapper;

import dto.LidDTO;
import entity.Lid;

import java.util.List;
import java.util.stream.Collectors;

public class LidMapper implements EntityMapper<Lid, LidDTO> {

    @Override
    public LidDTO toDTO(Lid lid) {
        LidDTO lidDTO = new LidDTO();
        lidDTO.setLid_id(lid.getLid_id());
        lidDTO.setNaam(lid.getNaam());
        lidDTO.setAdres(lid.getAdres());
        lidDTO.setTelefoonnummer(lid.getTelefoonnummer());
        return lidDTO;
    }

    @Override
    public List<LidDTO> toDTOList(List<Lid> leden) {
        return leden.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
