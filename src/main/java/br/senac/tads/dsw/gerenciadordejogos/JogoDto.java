package br.senac.tads.dsw.gerenciadordejogos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class JogoDto {

	@NotBlank(message = "Titulo é OBRIGATORIO")
	@Size(max = 100)
	private String titulo;

	@NotNull(message = "Ano OBRIGATORIO")
	@Min(value = 1950, message = "O ano nao pode ser menor que 1950")
	private int anoLancamento;

	@NotBlank(message = "Plataforma é OBRIGATORIO")
	@Size(max = 25)
	private String plataforma;

	@NotNull(message = "OBRIGATORIO informar disponibilidade")
	private boolean disponivel;

	private String observacao;

	public JogoDto(int anoLancamento, String titulo, String plataforma, boolean disponivel, String observacao) {
		this.anoLancamento = anoLancamento;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.disponivel = disponivel;
		this.observacao = observacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
