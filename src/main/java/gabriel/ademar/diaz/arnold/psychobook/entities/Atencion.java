package gabriel.ademar.diaz.arnold.psychobook.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "atencion")
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana", nullable = false)
    private String dia_semana;

    @Column(name = "horario_inicio", nullable = false)
    private Time horario_inicio;

    @Column(name = "hora_fin", nullable = false)
    private Time horario_fin;

    @JsonIgnore
    @OneToOne(mappedBy = "atencion")
    private Centros centro;
}
