package netlife.devmasters.booking.service;

import netlife.devmasters.booking.domain.Resource;
import netlife.devmasters.booking.domain.TypeResource;
import netlife.devmasters.booking.domain.dto.TypeResourceCreate;
import netlife.devmasters.booking.exception.dominio.DataException;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    Resource save(Resource obj) throws DataException;

    List<Resource> getAll();

    Optional<Resource> getById(int id);

    Resource update(Resource objActualizado, Integer idResource) throws DataException;

    void delete(int id) throws Exception;
}
