package br.senac.tads.dsw.gerenciadordejogos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_Jogos")
public class JogoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true, length = 100)
	private String titulo;

	@Column(nullable = false, name = "ano_lancamento")
	private int anoLancamento;

	@Column(nullable = false, length = 25)
	private String plataforma;

	@Column(nullable = false)
	private boolean disponivel;

	@Column(length = 255)
	private String observacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
