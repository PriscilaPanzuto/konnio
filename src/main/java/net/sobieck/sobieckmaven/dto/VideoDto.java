package net.sobieck.sobieckmaven.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import net.sobiecki.konnio.model.Categoria;
import net.sobiecki.konnio.model.Video;
import net.sobiecki.konnio.service.CrudCategoriaService;
import net.sobiecki.konnio.service.CrudVideoService;

public class VideoDto {
	
	private Integer id;
	@NotBlank
	private String episodio;
	@NotNull
	private Integer corte;
	@NotBlank
	private String titulo;
	
	@NotNull(message = "Categoria é obrigatória!")
	private Integer categoria;
	
	private String descricao;
	private LocalDate dataPublicacao;
	
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime tempoVideo;
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
	
	private static DateTimeFormatter formatter;
	
	public VideoDto() {
	}
	
	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
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
		dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.dataPublicacao = dataPublicacao;
	}

	public LocalTime getTempoVideo() {
		return tempoVideo;
	}

	public void setTempoVideo(LocalTime tempoVideo) {
		this.tempoVideo = tempoVideo;
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

	@Autowired
	public Video toVideo(CrudCategoriaService crudCategoriaService, CrudVideoService crudVideoService){

		Categoria categoriaPorId = crudCategoriaService.buscarCategoriaPorId(categoria);

		Video video = new Video();
		video.setEpisodio(episodio);
		video.setCorte(corte);
		video.setTitulo(titulo);
		video.setDescricao(descricao);
		video.setDataPublicacao(dataPublicacao);
		video.setTempoVideo(tempoVideo);
		video.setCategoria(categoriaPorId);
		video.setLinkYoutube(linkYoutube);
		video.setIdFacebook(idFacebook);
		
		if(getCustoFacebook() == null) {
			this.custoFacebook = 0.0;
		}
		
		if(getCustoYoutube() == null) {
			this.custoYoutube = 0.0;
		}
		
		if(getViewsFb25() == null) {
			this.viewsFb25 = 0;
		}
		
		if(getViewsFb75() == null) {
			this.viewsFb75 = 0;
		}
		
		if(getViewsYt25() == null) {
			this.viewsYt25 = 0;
		}
		
		if(getViewsYt75() == null) {
			this.viewsYt75 = 0;
		}
		
		video.setCustoFacebook(custoFacebook);
		video.setCustoYoutube(custoYoutube);
		video.setViewsFb25(viewsFb25);
		video.setViewsFb75(viewsFb75);
		video.setViewsYt25(viewsYt25);
		video.setViewsYt75(viewsYt75);
		if(this.custoFacebook == 0.0 || this.custoYoutube == 0.0) {
			video.setCustoPorViewFb25(0.0);
			video.setCustoPorViewFb75(0.0);
			video.setCustoPorViewYt25(0.0);
			video.setCustoPorViewYt75(0.0);
		} else {
			video.setCustoPorViewFb25(this.custoFacebook / this.viewsFb25);
			video.setCustoPorViewFb75(this.custoFacebook / this.viewsFb75);
			video.setCustoPorViewYt25(this.custoYoutube / this.viewsYt25);
			video.setCustoPorViewYt75(this.custoYoutube / this.viewsYt75);
		}

		return video;
	}

	public void toVideoDto(Video video) {
		this.id = video.getId();
		this.episodio = video.getEpisodio();
		this.corte = video.getCorte();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.dataPublicacao = video.getDataPublicacao();
		this.tempoVideo = video.getTempoVideo();
		this.categoria = video.getCategoria().getId();
		this.linkYoutube = video.getLinkYoutube();
		this.idFacebook = video.getIdFacebook();
		this.custoYoutube = video.getCustoYoutube();
        this.custoFacebook = video.getCustoFacebook();
		this.viewsFb25 = video.getViewsFb25();
		this.viewsFb75 = video.getViewsFb75();
		this.viewsYt25 = video.getViewsYt25();
		this.viewsYt75 = video.getViewsYt75();
		this.custoPorViewFb25 = video.getCustoPorViewFb25();
		this.custoPorViewFb75 = video.getCustoPorViewFb75();
		this.custoPorViewYt25 = video.getCustoPorViewYt25();
		this.custoPorViewYt75 = video.getCustoPorViewYt75();
		
	}
	
}
