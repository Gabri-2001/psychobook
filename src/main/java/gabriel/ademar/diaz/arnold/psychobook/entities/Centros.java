package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "centros")
public class Centros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "web")
    private String web;

    @OneToOne
    @JoinColumn(name="atencion_id")
    private Atencion atencion;

    @OneToMany(mappedBy = "centro")
    private List<Resenyas> rensenyas_id;

    @ManyToMany
    @JoinTable(
            name = "centrosHasEtiquetas",
            joinColumns = @JoinColumn(name = "centro_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiquetas> etiquetas;

    @ManyToMany
    @JoinTable(
            name = "centrosHasServicios",
            joinColumns = @JoinColumn(name = "centro_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<Servicios> servicios;

    @OneToMany(mappedBy = "centro")
    private List<CentrosHasEtiquetas> centro_Etiqueta;

    @OneToMany(mappedBy = "centro")
    private List<CentrosHasServicios> centro_Servicio;


}
