package net.sobieck.sobieckmaven.dto;

import javax.validation.constraints.NotBlank;

import net.sobiecki.konnio.model.Categoria;

public class CategoriaDto {
	
	
	private Integer id;
	@NotBlank
	private String categoria;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Categoria toCategoria() {
		Categoria novacategoria = new Categoria();
		novacategoria.setId(id);
		novacategoria.setCategoria(categoria);
		return novacategoria;
	}

	public void toCategoriadto(Categoria categoria) {
		this.id = categoria.getId();
		this.categoria = categoria.getCategoria();
		
	}

}
