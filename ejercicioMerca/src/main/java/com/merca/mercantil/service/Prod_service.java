package com.merca.mercantil.service;

import com.merca.mercantil.entity.productos;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.merca.mercantil.repository.Prod_repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Service
public class Prod_service implements Base_service <productos> {
    @Autowired
    //  spring se encarga de obtener las dependencias
    private Prod_repository prod_repository; //creo una implementacion de dependencia, y spring se encarga de obtener las dependencias

    @Transactional
    @Override
    public List<productos> findAll() throws Exception { // dentro de cada metodo hago un try catch para capturar las excepciones
        try {
            List<productos> entities = prod_repository.findAll();//obtengo de la base de datos todas las personas registradas
            return entities;
        } catch (Exception e) { //capturo la excepcion
             throw new Exception(e.getMessage()); // esto lo leera cuando se haga el controlador
        }
    }

        @Transactional
        @Override
        public productos save (productos entity ) throws Exception {//utiliza el metodo save del repositorio
            try {
                entity =prod_repository.save(entity);//
                return entity;
            } catch (Exception e) { //capturo la excepcion
                throw new Exception(e.getMessage()); // esto lo leera cuando se haga el controlador
            }
        }
        @Transactional
        @Override
        public productos update (Long id, productos entity) throws Exception {
            try {
            Optional<productos> entityOpcional = prod_repository.findById(id);//tambien se utiliza un findById para obtener la persona que queremos actualizar
                productos Productos = entityOpcional.get();//si tenemos un Producto, lo asigna a productos
                Productos= prod_repository.save(entity);//guardo la nueva entity
                return Productos;
            } catch (Exception e) { //capturo la excepcion
                throw new Exception(e.getMessage()); // esto lo leera cuando no obtengamos ninguna producto y hace rollback de la base de datos
            }
        }
        @Transactional
        @Override
        public boolean delete (Long id) throws Exception {//al retorar un true tiene que ser boolean
            try {
               if ( prod_repository.existsById(id)){ //se utiliza para saber si hay algun producto con el id que indicamos
                   prod_repository.deleteById(id);//si existe lo borra por su ID.
                   return true ;
               }else {
                   throw new Exception();
               }
            } catch (Exception e) { //capturo la excepcion
                throw new Exception(e.getMessage()); // esto lo leera cuando se haga el controlador
            }

        }


    @Override
    public productos findById(Long id) throws Exception {
        try {
            Optional<productos>  entityOpcional = prod_repository.findById(id); //Opcional porque no sabemos si en la base de datos se encuntra en la base de datos una identidad o un registro
       return entityOpcional.get(); //este metodo obtiene una entidad si es que la encuentra
        } catch (Exception e) { //capturo la excepcion
            throw new Exception(e.getMessage()); // esto lo leera cuando se haga el controlador

        }
    }
}