package net.sobiecki.konnio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.sobieck.sobieckmaven.dto.VideoDto;
import net.sobiecki.konnio.model.Busca;
import net.sobiecki.konnio.model.Categoria;
import net.sobiecki.konnio.model.Video;
import net.sobiecki.konnio.repository.CategoriaRepository;
import net.sobiecki.konnio.repository.VideoRepository;

@Service
public class CrudVideoService {
	
	private final CategoriaRepository categoriaRepository;
	private final VideoRepository videoRepository;
	private List<Video> listaBusca = new ArrayList<Video>();
	
	public CrudVideoService(CategoriaRepository categoriaRepository, VideoRepository videoRepository) {
		this.categoriaRepository = categoriaRepository;
		this.videoRepository = videoRepository;
	}
	
	public void salvar(Video video) {
		videoRepository.save(video);
	}
	
	public void alterar(Integer id, VideoDto videoDto) {
		Video video = buscarVideoPorId(id);
		video.setEpisodio(videoDto.getEpisodio());
		video.setCorte(videoDto.getCorte());
		video.setTitulo(videoDto.getTitulo());
		video.setDescricao(videoDto.getDescricao());
		video.setDataPublicacao(videoDto.getDataPublicacao());
		video.setTempoVideo(videoDto.getTempoVideo());
		Categoria categoria = categoriaRepository.findById(videoDto.getCategoria()).get();
		video.setCategoria(categoria);
		video.setLinkYoutube(videoDto.getLinkYoutube());
		video.setIdFacebook(videoDto.getIdFacebook());
		video.setCustoYoutube(videoDto.getCustoFacebook());
		video.setCustoFacebook(videoDto.getCustoFacebook());
		video.setViewsFb25(videoDto.getViewsFb25());
		video.setViewsFb75(videoDto.getViewsFb75());
		video.setViewsYt25(videoDto.getViewsYt25());
		video.setViewsYt75(videoDto.getViewsYt75());
		
		videoRepository.save(video);
		
	}

	public List<Video> listarVideos() {
		Sort sort = Sort.by("titulo").ascending();
		Iterable<Video> videosIterable = videoRepository.findAll(sort);
		List<Video> videos = new ArrayList<Video>();
		videosIterable.forEach(v -> videos.add(v));
		return videos;
	}

	public Video buscarVideoPorId(Integer id) {
		Optional<Video> videoPorId = videoRepository.findById(id);
		return videoPorId.get();
	}

	public void deletarVideo(Integer id) {
		videoRepository.deleteById(id);
	}

	public List<Video> buscarPor(Busca busca) {
		
		if (busca.getSelect().equals("titulo")) {
			listaBusca = videoRepository.findByTituloContaining(busca.getBuscaTexto());
		}
		if (busca.getSelect().equals("descricao")) {
			listaBusca = videoRepository.findByDescricaoContaining(busca.getBuscaTexto());
		}
		if (busca.getSelect().equals("categoria")) {
			listaBusca.clear();
			List<Categoria> listaCategoriasBusca = categoriaRepository.findByCategoriaContaining(busca.getBuscaTexto());
			listaCategoriasBusca.forEach(c -> listaBusca.addAll(videoRepository.findByCategoria(c)));
		}
		return listaBusca;
	}
}
