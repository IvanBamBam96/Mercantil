package repository;

import entity.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Prod_repository extends JpaRepository<productos, Long > {

}
