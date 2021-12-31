package com.merca.mercantil.repository;

import com.merca.mercantil.entity.pedidos_detalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ped_Det_repository extends JpaRepository <pedidos_detalles,Long>{

}
