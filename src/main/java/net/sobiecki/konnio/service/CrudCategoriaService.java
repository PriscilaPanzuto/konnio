package net.sobiecki.konnio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sobieck.sobieckmaven.dto.CategoriaDto;
import net.sobiecki.konnio.model.Categoria;
import net.sobiecki.konnio.repository.CategoriaRepository;

@Service
public class CrudCategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CrudCategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public void salvar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void atualizar(Integer idCategoria, String novaCategoria) {
		Categoria categoria = new Categoria();
		categoria.setId(idCategoria);
		categoria.setCategoria(novaCategoria);
		categoriaRepository.save(categoria);
	}

	public List<Categoria> listarCategorias() {
		Iterable<Categoria> categoriasIterable = categoriaRepository.findAll();
		List<Categoria> categorias = new ArrayList<Categoria>();
		categoriasIterable.forEach(c -> categorias.add(c));
		return categorias;
	}

	public Categoria buscarCategoriaPorId(Integer idCategoria) {
		Optional<Categoria> categoriaPorId = categoriaRepository.findById(idCategoria);
		return categoriaPorId.get();
	}

	public void alterar(Integer id, @Valid CategoriaDto categoriaDto) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoria.setCategoria(categoriaDto.getCategoria());
		categoriaRepository.save(categoria);
	}

	public void deletarCategoria(Integer id) {
		categoriaRepository.deleteById(id);
	}

}
