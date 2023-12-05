package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CentrosHasServicios")
public class CentrosHasServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "centros_id")
    private Centros centro;

    @ManyToOne
    @JoinColumn(name = "servicios_id")
    private Servicios servicio;
}
