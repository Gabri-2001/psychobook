package gabriel.ademar.diaz.arnold.psychobook.entities;

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
@Table(name = "especialidades")
public class Especialidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "centro", nullable = false)
    private String centro;

    @OneToMany(mappedBy = "especialidad")
    private List<EspecialidadesHasPsicologos> especialidadesHasPsicologos;

    @ManyToMany(mappedBy = "especialidades")
    private List<Psicologos> psicologos;

}