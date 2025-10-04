package pe.jsaire.apibuses.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusResponse {

    private Long idBus;
    private MarcaResponse marcaBus;
    private String placaBus;
    private String numeroBus;
    private String caracteristicaBus;
    private Boolean activoBus;
    private LocalDateTime fechaCreacionBus;
}
