package gabriel.ademar.diaz.arnold.psychobook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "especialidades")
public class Especialidades {
    @Id
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "centro", nullable = false)
    private String centro;

}