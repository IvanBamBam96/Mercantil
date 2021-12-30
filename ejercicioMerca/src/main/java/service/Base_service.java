package service;

import javax.persistence.Entity;
import java.util.List;
//se hace una interface para que pueda ser usada en todos los services que se pueda incluir.
//aqui se hace los 4 servicios, buscar lista completa, por id, eliminar ,actualizar.
public interface Base_service<E> { // con <E> la hago de tipo generic OBJETC, puedo pasarle cualquier cosa.


     public List<E> findAll()throws Exception; //obtengo una lista de todas las entidades que quiera obtener, por eso es lista
     public E findById(Long  id ) throws     Exception;//busca LA ENTIDADES por Id, y acepta un E generico.
     public E save (E Entity)throws Exception;// CREA  la entidad  que reciva y la envia al repositorio, y acepta un E generico..
     public E update (Long id, E Entity) throws Exception;//actualiza buscando con los parametros de su  Id, y E la entidad actualizada, y acepta un E generico..
     public boolean delete(Long id) throws Exception;//borra yb registro de la base de datos. se hace buleano porque devuelve un true si se borra
}
