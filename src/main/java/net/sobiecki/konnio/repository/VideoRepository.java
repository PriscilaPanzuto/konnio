package net.sobiecki.konnio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sobiecki.konnio.model.Categoria;
import net.sobiecki.konnio.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

	List<Video> findByTituloContaining(String buscaTexto);

	List<Video> findByDescricaoContaining(String buscaTexto);

	List<Video> findByCategoriaContaining(String buscaTexto);

	List<Video> findByTitulo(String select);

	List<Video> findByCategoria(Categoria categoria);

}
