package pe.jsaire.apibuses.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.jsaire.apibuses.exceptions.BusNotFoundException;
import pe.jsaire.apibuses.models.dtos.response.BusResponse;
import pe.jsaire.apibuses.models.entities.Bus;
import pe.jsaire.apibuses.models.repositories.BusRepository;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements IBusService {


    private final BusRepository busRepository;
    private final ModelMapper modelMapper;

    private static final Integer PAGE_SIZE = 10;

    @Override
    @Transactional(readOnly = true)
    public Page<BusResponse> findAll(String field, Boolean desc, Integer page) {


        int pageNumber = (page != null && page >= 0) ? page : 0;
        Pageable pageable;

        if (field != null && !field.isBlank()) {
            Sort sort = Sort.by(field);
            if (Boolean.TRUE.equals(desc)) {
                sort = sort.descending();
            }
            pageable = PageRequest.of(pageNumber, PAGE_SIZE, sort);
        } else {
            pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        }

        Page<Bus> buses = busRepository.findAll(pageable);

        return buses.map(this::convertToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public BusResponse findById(Long id) {
        return busRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() -> new BusNotFoundException("No se encontró el bus con el ID: " + id));
    }


    private BusResponse convertToResponse(Bus bus) {
        return modelMapper.map(bus, BusResponse.class);
    }


}
