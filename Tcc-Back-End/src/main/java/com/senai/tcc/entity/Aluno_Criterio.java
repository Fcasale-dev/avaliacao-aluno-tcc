package com.senai.tcc.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Aluno_Criterio {

	@EmbeddedId
	private AlunoCriterioId id;
	@Enumerated(EnumType.STRING)
	private Avaliacao avaliacao;
	private boolean avaliado;

	private Date data_avaliacao;

	private String observacoes;

	// Construtor padrão
	public Aluno_Criterio() {
	}

	// Construtor com parâmetros
	public Aluno_Criterio(AlunoCriterioId id, Avaliacao avaliacao, boolean avaliado, Date data_avaliacao, String observacoes) {
		this.id = id;
		this.avaliacao = avaliacao;
		this.avaliado = avaliado;
		this.data_avaliacao = data_avaliacao;
		this.observacoes = observacoes;
	}

	// Getters e Setters
	public AlunoCriterioId getId() {
		return id;
	}

	public void setId(AlunoCriterioId id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public boolean isAvaliado() {
		return avaliado;
	}

	public void setAvaliado(boolean avaliado) {
		this.avaliado = avaliado;
	}

	public Date getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	// Enum Avaliacao
	public enum Avaliacao {
		Atingiu, Nao_atingiu
	}
}
