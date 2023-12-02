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
@Table(name = "servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "tarifas", nullable = false)
    private String tarifas;

    @ManyToMany(mappedBy = "servicios")
    private List<Centros> centros;

    @OneToMany(mappedBy = "servicio")
    private List<CentrosHasServicios> servicio_Centro;
}
