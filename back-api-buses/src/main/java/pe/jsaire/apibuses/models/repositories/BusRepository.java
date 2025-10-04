package pe.jsaire.apibuses.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.jsaire.apibuses.models.entities.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {


    Page<Bus> findAll(Pageable pageable);

}
