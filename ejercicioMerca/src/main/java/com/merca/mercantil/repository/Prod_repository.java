package com.merca.mercantil.repository;

import com.merca.mercantil.entity.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Prod_repository extends JpaRepository<productos, Long > {

}
