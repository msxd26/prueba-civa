package pe.jsaire.apibuses.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.jsaire.apibuses.services.IBusService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bus")
public class BusController {

    private final IBusService service;


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@Valid @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }


    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) String field,
                                     @RequestParam(required = false) Boolean desc,
                                     @RequestParam(required = false) Integer page) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(field, desc, page));
    }

}

