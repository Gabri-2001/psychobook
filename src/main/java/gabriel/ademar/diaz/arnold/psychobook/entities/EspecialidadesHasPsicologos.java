package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "PsicologosHasEspecialidades")
public class EspecialidadesHasPsicologos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "especialidades_id")
    private Especialidades especialidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "psicologos_id")
    private Psicologos psicologo;

}
