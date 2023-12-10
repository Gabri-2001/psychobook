package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "psicologosHasServicios")
public class PsicologosHasServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "psicologos_id")
    private Psicologos psicologo;

    @ManyToOne
    @JoinColumn(name = "servicios_id")
    private Servicios servicio;
}
