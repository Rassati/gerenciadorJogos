package br.senac.tads.dsw.gerenciadordejogos;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
 private final JogoRepository JogoRepository;

	public JogoService(JogoRepository jogoRepository) {
		JogoRepository = jogoRepository;
	}

	public List<JogoEntity> listarJogos() {
		return JogoRepository.findAll();
	}

	public JogoEntity cadastrarJogo(JogoDto jogoDto) {
		JogoEntity jogoEntity = new JogoEntity();

		jogoEntity.setTitulo(jogoDto.getTitulo());
		jogoEntity.setAnoLancamento(jogoDto.getAnoLancamento());
		jogoEntity.setPlataforma(jogoDto.getPlataforma());
		jogoEntity.setDisponivel(jogoDto.isDisponivel());
		jogoEntity.setObservacao(jogoDto.getObservacao());

		return JogoRepository.save(jogoEntity);
	}

	public JogoEntity alterarJogo(int id, JogoDto jogoDto) {
		JogoEntity jogo = JogoRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(
				HttpStatus.NOT_FOUND, "o jogo de " + id + " não existe"));

		jogo.setTitulo(jogoDto.getTitulo());
		jogo.setAnoLancamento(jogoDto.getAnoLancamento());
		jogo.setPlataforma(jogoDto.getPlataforma());
		jogo.setDisponivel(jogoDto.isDisponivel());
		jogo.setObservacao(jogoDto.getObservacao());

		return JogoRepository.save(jogo);
	}

	public void excluirJogo(int id) {
		JogoEntity jogo = JogoRepository.findById(id)
			.orElseThrow(() -> new ResponseStatusException(
				HttpStatus.NOT_FOUND, "o jogo de " + id + " não existe"));

		JogoRepository.delete(jogo);
	}
}
