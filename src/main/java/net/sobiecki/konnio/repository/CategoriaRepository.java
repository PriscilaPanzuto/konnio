package net.sobiecki.konnio.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sobiecki.konnio.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

	ArrayList<Categoria> findByCategoriaContaining(String buscaTexto);

}
