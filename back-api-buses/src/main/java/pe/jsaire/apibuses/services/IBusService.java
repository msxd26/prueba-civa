package pe.jsaire.apibuses.services;

import org.springframework.data.domain.Page;
import pe.jsaire.apibuses.models.dtos.response.BusResponse;

public interface IBusService {


    Page<BusResponse> findAll(String field, Boolean desc, Integer page);

    BusResponse findById(Long id);
}
