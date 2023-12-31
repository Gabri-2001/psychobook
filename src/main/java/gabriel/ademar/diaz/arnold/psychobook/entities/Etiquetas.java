package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "etiquetas")
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
    private List<Psicologos> psicologos;

    @JsonIgnore
    @OneToMany(mappedBy = "etiqueta")
    private List<PsicologosHasEtiquetas> etiqueta_Psicologo;


}
