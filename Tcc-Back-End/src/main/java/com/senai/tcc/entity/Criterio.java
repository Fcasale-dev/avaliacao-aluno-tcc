package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Criterio {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_criterio;
	private Integer id_competencia;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String nome;
	private Integer id_curso;

	public Criterio() {
		super();
	}

	public Criterio(Integer id_criterio, Integer id_competencia, Tipo tipo, String nome, Integer id_curso) {
		super();
		this.id_criterio = id_criterio;
		this.id_competencia = id_competencia;
		this.tipo = tipo;
		this.nome = nome;
		this.id_curso = id_curso;
	}

	public Integer getId_criterio() {
		return id_criterio;
	}

	public void setId_criterio(Integer id_criterio) {
		this.id_criterio = id_criterio;
	}

	public Integer getId_competencia() {
		return id_competencia;
	}

	public void setId_competencia(Integer id_competencia) {
		this.id_competencia = id_competencia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_competencia, id_criterio, id_curso, nome, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criterio other = (Criterio) obj;
		return Objects.equals(id_competencia, other.id_competencia) && Objects.equals(id_criterio, other.id_criterio)
				&& Objects.equals(id_curso, other.id_curso) && Objects.equals(nome, other.nome) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Criterio [id_criterio=" + id_criterio + ", id_competencia=" + id_competencia + ", tipo=" + tipo
				+ ", nome=" + nome + ", id_curso=" + id_curso + "]";
	}

	public enum Tipo {
		Critica, Desejada;
	}
}
