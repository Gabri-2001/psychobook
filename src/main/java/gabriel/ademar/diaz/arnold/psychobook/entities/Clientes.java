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
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fecha_registro", nullable = false)
    private Timestamp fecha_registro;

    @OneToOne
    @JoinColumn(name="users_id")
    private Users user;

    @OneToMany(mappedBy = "cliente")
    private List<Resenyas> resenyas;


}
