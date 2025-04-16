package com.senai.tcc.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlunoCriterioId implements Serializable {

	@Column(name = "id_aluno", nullable = false)
	private Integer id_aluno;
	@Column(name = "id_criterio", nullable = false)
	private Integer id_criterio;

	// Construtor padrão
	public AlunoCriterioId() {
	}

	// Construtor com argumentos
	public AlunoCriterioId(Integer id_aluno, Integer id_criterio) {
		this.id_aluno = id_aluno;
		this.id_criterio = id_criterio;
	}

	// Getters e setters
	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public Integer getId_criterio() {
		return id_criterio;
	}

	public void setId_criterio(Integer id_criteiro) {
		this.id_criterio = id_criteiro;
	}

	// hashCode e equals
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AlunoCriterioId that = (AlunoCriterioId) o;
		return Objects.equals(id_aluno, that.id_aluno) && Objects.equals(id_criterio, that.id_criterio);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_aluno, id_criterio);
	}
}
