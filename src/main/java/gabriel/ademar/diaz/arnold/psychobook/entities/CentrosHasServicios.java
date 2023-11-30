package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CentrosHasServicios")
public class CentrosHasServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "centro_id")
    private Centros centro;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicios servicio;
}
