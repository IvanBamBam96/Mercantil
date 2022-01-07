package com.merca.mercantil.controllers;

import com.merca.mercantil.entity.productos;
import com.merca.mercantil.service.Prod_service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") //esto permite lograr o permitir el acceso el acceso o no a nuestra api desde distintos origenes.(desde distintos clientes)
//"*" denota que desde cualquier origen podemos acceder a los datos de nuestra API.
@RequestMapping(path = "api/v1/producto") //declaro el path / URI  que necesitamos para accder  a nuestros recursos.
//a traves de esta uri podemos acceder a los metodos de personas.
public class ProdController { //declaramos los service dentro de los controler
    private Prod_service prod_service;//declaramos el recurso

    //creamos el constructor de controller
    public ProdController(Prod_service prod_service) {
        this.prod_service = prod_service; //con esto dejamos hecha la injeccion de dependencia.
    }

    //aqui hacemos los metodos
    //colocamos el tipo de request que se realice con el getALL.
    @GetMapping("")//indicamos la uri especifica de este metodo.
    //metodo get : que se corresponde a  (findAll) .

    public ResponseEntity<?> getAll() {//este metodo los brinda las respuesta en Json , para nuestra aplicacion web.
        try {
            return ResponseEntity.status(HttpStatus.OK).body(prod_service.findAll()); //contiene el status de la respuesta, que se hace con codigo Http status
            //si en el status se encuentra la lista de prod, se devuelve la lista encontrada.
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"erro\":\"Error. Por favor intente mas tarde.\"}");//en caso de que no , se muestra por http status que no lo encontro.
            //en el body generamos un mensaje en formato Json. es el formato que se envian las respuestas a la aplicacion a nuestro cliente.
        }
    }

    @GetMapping("/{id}")
    // creo este request  porque en la uri al recibir el id, se va a recibir el id en formato @PathVariable(uri)
    //metodo getONE: que se corresponde con FindId.
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        //es el id con el que busco en la base de datos. es una variable que esta dentro del Path o  de la url. con la cual accedemos al recurso.
        try {
            return ResponseEntity.status(HttpStatus.OK).body(prod_service.findById(id)); //se cambia esto respecto al primer metodo, ya que busco por id.
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"erro\":\"Error.no se encontro un id igual.\"}");//en caso de que no , se muestra por http status que no lo encontro.
            //en el body generamos un mensaje en formato Json. es el formato que se envian las respuestas a la aplicacion a nuestro cliente.
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save (@RequestBody productos entity) {//declaramos productos entity como que esta dentro del body del request, utilizamos @Requestmapping
        //por eso para resibir esta entity ,tengo q declararla en el body de @PostMapping
        try {
            return ResponseEntity.status(HttpStatus.OK).body(prod_service.save(entity)); //guardo la entity
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"erro\":\"Error.no se puede guardar la entidad.\"}");//en caso de que no , se muestra por http status que no lo encontro.
            //en el body generamos un mensaje en formato Json. es el formato que se envian las respuestas a la aplicacion a nuestro cliente.
        }

    }
    @PutMapping("/{id}")//se usa PutMapping , tambien recibe el id por url.
    public ResponseEntity<?> update (@PathVariable  Long id,  @RequestBody  productos entity ){//ponemos lo que recibe en el service id y producto. @@PathVariable porque la var esta dentro de la url
        //RequestBody porque esta dentro del body de la request
        try {
            return ResponseEntity.status(HttpStatus.OK).body(prod_service.update(id, entity)); // actualizamos la producto con ese id
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"erro\":\"Error.no se puede actualizar.\"}");//en caso de que no , se muestra por http status que no lo encontro.
            //en el body generamos un mensaje en formato Json. es el formato que se envian las respuestas a la aplicacion a nuestro cliente.
        }

    }
    @DeleteMapping ("/{id}")//@DeleteMapping - para el controller  Delete
    public ResponseEntity <?> delete(@PathVariable Long id){//TAMBIEn lo declaro como path variable porque viene el id en el url.
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(prod_service.delete(id)); // esto borra a lo que lo envie ese id. Not_Content para aclara que se borro
            //el contenido guardado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"erro\":\"Error.no se encuentra en la base de datos.\"}");//
        }

    }
    }



