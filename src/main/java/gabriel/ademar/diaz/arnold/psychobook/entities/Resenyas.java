package gabriel.ademar.diaz.arnold.psychobook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "resenyas")
public class Resenyas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puntuacion", nullable = false)
    private Integer puntuacion;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "centros_id")
    private Centros centro;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes cliente;

}
