package net.sobiecki.konnio.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "videos")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String episodio;
	private Integer corte;
	private String titulo;
	private String descricao;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime tempoVideo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;

	private String linkYoutube;
	private String idFacebook;
	private Integer viewsYt25;
	private Integer viewsYt75;
	private Integer viewsFb25;
	private Integer viewsFb75;
	private Double custoYoutube;
	private Double custoFacebook;
	private Double custoPorViewYt25;
	private Double custoPorViewYt75;
	private Double custoPorViewFb25;
	private Double custoPorViewFb75;

	public Video() {
	}

	public Integer getId() {
		return id;
	}

	public String getEpisodio() {
		return episodio;
	}

	public void setEpisodio(String episodio) {
		this.episodio = episodio;
	}

	public Integer getCorte() {
		return corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public LocalTime getTempoVideo() {
		return tempoVideo;
	}

	public void setTempoVideo(LocalTime tempoVideo) {
		this.tempoVideo = tempoVideo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public Integer getViewsYt25() {
		return viewsYt25;
	}

	public void setViewsYt25(Integer viewsYt25) {
		this.viewsYt25 = viewsYt25;
	}

	public Integer getViewsYt75() {
		return viewsYt75;
	}

	public void setViewsYt75(Integer viewsYt75) {
		this.viewsYt75 = viewsYt75;
	}

	public Integer getViewsFb25() {
		return viewsFb25;
	}

	public void setViewsFb25(Integer viewsFb25) {
		this.viewsFb25 = viewsFb25;
	}

	public Integer getViewsFb75() {
		return viewsFb75;
	}

	public void setViewsFb75(Integer viewsFb75) {
		this.viewsFb75 = viewsFb75;
	}

	public Double getCustoYoutube() {
		return custoYoutube;
	}

	public void setCustoYoutube(Double custoYoutube) {
		this.custoYoutube = custoYoutube;
	}

	public Double getCustoFacebook() {
		return custoFacebook;
	}

	public void setCustoFacebook(Double custoFacebook) {
		this.custoFacebook = custoFacebook;
	}

	public Double getCustoPorViewYt25() {
		return custoPorViewYt25;
	}

	public void setCustoPorViewYt25(Double custoPorViewYt25) {
		this.custoPorViewYt25 = custoPorViewYt25;
	}

	public Double getCustoPorViewYt75() {
		return custoPorViewYt75;
	}

	public void setCustoPorViewYt75(Double custoPorViewYt75) {
		this.custoPorViewYt75 = custoPorViewYt75;
	}

	public Double getCustoPorViewFb25() {
		return custoPorViewFb25;
	}

	public void setCustoPorViewFb25(Double custoPorViewFb25) {
		this.custoPorViewFb25 = custoPorViewFb25;
	}

	public Double getCustoPorViewFb75() {
		return custoPorViewFb75;
	}

	public void setCustoPorViewFb75(Double custoPorViewFb75) {
		this.custoPorViewFb75 = custoPorViewFb75;
	}
	
	

}
