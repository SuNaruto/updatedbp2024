package Mapper;

import java.util.List;

public interface EntityMapper<E, D> {
    D toDTO(E entity);

    List<D> toDTOList(List<E> entities);
}
