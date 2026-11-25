package br.senac.tads.dsw.gerenciadordejogos;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@GetMapping
	public List<JogoEntity> listarJogos() {
		return jogoService.listarJogos();
	}


	@PostMapping
	public ResponseEntity<Void> cadastrarJogo(@Valid @RequestBody JogoDto jogoDto) {
		JogoEntity jogoSalvo = jogoService.cadastrarJogo(jogoDto);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/jogos/{id}")
			.buildAndExpand(jogoSalvo.getId())
			.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<JogoEntity> alterarJogo(
		@PathVariable("id") int id,
		@Valid @RequestBody JogoDto jogoDto) {
		return ResponseEntity.ok(jogoService.alterarJogo(id, jogoDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirJogo(@PathVariable("id") int id) {
		jogoService.excluirJogo(id);
		return ResponseEntity.noContent().build();
	}

}
