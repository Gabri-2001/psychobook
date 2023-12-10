package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "psicologos")
public class Psicologos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "localidad", nullable = false)
    private String localidad;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "colegiado", nullable = false)
    private String colegiado;

    @Column(name = "validado", nullable = false)
    private Boolean validado;

    @Column(name = "presencial", nullable = false)
    private Boolean presencial;

    @Column(name = "linea", nullable = false)
    private Boolean linea;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Lob
    @Column(name = "imagen", columnDefinition="MEDIUMBLOB")
    private byte[] imagen;



    @OneToOne
    @JoinColumn(name="users_id")
    private Users user;

    @JsonIgnore
    @OneToMany(mappedBy = "psicologo")
    private List<PsicologosHasEspecialidades> psicologoHasEspecialidades;

    @ManyToMany
    @JoinTable(
            name = "psicologosHasEspecialidades",
            joinColumns = @JoinColumn(name = "psicologos_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidades_id")
    )
    private List<Especialidades> especialidades;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "psicologosHasEtiquetas",
            joinColumns = @JoinColumn(name = "psicologos_id"),
            inverseJoinColumns = @JoinColumn(name = "etiquetas_id")
    )
    private List<Etiquetas> etiquetas;

/*
    @ManyToMany
    @JoinTable(
            name = "psicologosHasServicios",
            joinColumns = @JoinColumn(name = "psicologos_id"),
            inverseJoinColumns = @JoinColumn(name = "servicios_id")
    )
    private List<Servicios> servicios;
*/
    @JsonIgnore
    @OneToMany(mappedBy = "psicologo")
    private List<PsicologosHasEtiquetas> psicologo_Etiqueta;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "psicologo")
    private List<PsicologosHasServicios> psicologo_Servicio;
*/
    @ManyToOne
    @JoinColumn(name ="centros_id")
    private Centros centro;

    @OneToMany(mappedBy="psicologo")
    private List<Atencion> atencion;

    @OneToMany(mappedBy = "psicologo")
    private List<Resenyas> rensenyas_id;

    @OneToMany(mappedBy = "psicologo")
    private List<Servicios> servicios_id;




}
