package com.merca.mercantil.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class productos implements Serializable { //el serializar ealobjeto lo convierte en bytes, para los ser recuperado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nombre;
    @Column(name = "des_corta")
    private String descripcion_corta;
    @Column(name = "des_larga")
    private String descripcion_larga;
    @Column(name = "pre_uni")
    private String precio_unitario;

}
