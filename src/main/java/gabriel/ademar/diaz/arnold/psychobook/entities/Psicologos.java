package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "psicologos")
public class Psicologos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "colegiado", nullable = false)
    private String colegiado;

    @Column(name = "validado", nullable = false)
    private Boolean validado;

    @OneToOne
    @JoinColumn(name="users_id")
    private Users user;

    @OneToMany(mappedBy = "psicologo")
    private List<EspecialidadesHasPsicologos> especialidadesHasPsicologos;

    @ManyToMany
    @JoinTable(
            name = "EspecialidadesHasPsicologos",
            joinColumns = @JoinColumn(name = "psicologo_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<Especialidades> especialidades;


}
