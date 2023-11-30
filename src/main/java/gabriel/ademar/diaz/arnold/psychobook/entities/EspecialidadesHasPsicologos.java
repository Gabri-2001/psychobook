package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "EspecialidadesHasPsicologos")
public class EspecialidadesHasPsicologos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidades especialidad;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologos psicologo;

}
