package com.merca.mercantil.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "pedidos_cabecera")//creo mi tabla y le doy nombre
@NoArgsConstructor//utiliza los genter y seter del  plugin lombok
@AllArgsConstructor//utiliza los genter y seter del  plugin lombok
@Getter//utiliza los genter y seter del  plugin lombok
@Setter //utiliza los genter y seter del  plugin lombok


public class pedidos_cabecera implements Serializable {//el serializar el objeto lo convierte en bytes, para los ser recuperado
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto hago referencia
  //que este id ↓ es el id de la tabla persona.
  private long id;

  @Column(name = "direccion") //le pongo los nombres de las columnas
   private String direccion;
   @Column(name = "imail")
   private String imail;
   @Column(name = "horario")
   private int horario;
   @Column(name = "fecha_alta")
   private int fecha_alta;
   @Column(name = "monto_total")
   private int monto_total;
   @Column(name = "aplico_descuento")
   private int aplico_descuento;
   @Column(name = "direestadoestadoccion")
   private String estado;

}
