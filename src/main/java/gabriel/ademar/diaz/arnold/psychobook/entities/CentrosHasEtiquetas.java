package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CentrosHasEtiquetas")
public class CentrosHasEtiquetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "centro_id")
    private Centros centro;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id")
    private Etiquetas etiqueta;
}