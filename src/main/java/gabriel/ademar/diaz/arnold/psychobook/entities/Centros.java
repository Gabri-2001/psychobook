package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "centrosHasEtiquetas",
            joinColumns = @JoinColumn(name = "centros_id"),
            inverseJoinColumns = @JoinColumn(name = "etiquetas_id")
    )
    private List<Etiquetas> etiquetas;


    @ManyToMany
    @JoinTable(
            name = "centrosHasServicios",
            joinColumns = @JoinColumn(name = "centros_id"),
            inverseJoinColumns = @JoinColumn(name = "servicios_id")
    )
    private List<Servicios> servicios;

    @JsonIgnore
    @OneToMany(mappedBy = "centro")
    private List<CentrosHasEtiquetas> centro_Etiqueta;

    @JsonIgnore
    @OneToMany(mappedBy = "centro")
    private List<CentrosHasServicios> centro_Servicio;


    @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL)
    private List<Psicologos> psicologos;


}
