package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "pedidos_detalles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class pedidos_detalles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto hago referencia
    //que este id ↓ , es el id de la tabla personas.
    private Long id;

    //ForeignKey pedido_cabezera_id; aprender a insertar FK
    //ForeignKey pedido_cabezera_id;
 @Column(name = "cant")
    private int cantidad;
 @Column(name = "pre_unitario")
    private float precio_unitario;


}
