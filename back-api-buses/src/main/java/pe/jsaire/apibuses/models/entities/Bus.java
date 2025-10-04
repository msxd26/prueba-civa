package pe.jsaire.apibuses.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBus;
    
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    private String placa;

    private String caracteristica;

    private LocalDateTime fechaCreacion;

    private boolean activo;

    @PrePersist
    public void creatAt() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
