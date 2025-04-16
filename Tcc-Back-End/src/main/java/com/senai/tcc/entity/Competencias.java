package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Competencias {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_competencia;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String nome;
	private String descricao;
	private Integer id_curso;

	public Competencias() {
		super();
	}

	public Competencias(Integer id_competencia, Tipo tipo, String nome, String descricao, Integer id_curso) {
		super();
		this.id_competencia = id_competencia;
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.id_curso = id_curso;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id_competencia, id_curso, nome, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competencias other = (Competencias) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id_competencia, other.id_competencia)
				&& Objects.equals(id_curso, other.id_curso) && Objects.equals(nome, other.nome) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Competencias [id_competencia=" + id_competencia + ", tipo=" + tipo + ", nome=" + nome + ", descricao="
				+ descricao + ", id_curso=" + id_curso + "]";
	}

	enum Tipo {

		tecnica("Tecnico"), basica("Basico"), socioemocional("SocioEmocional");

		private String descricao;

		Tipo(String descricao) {

			this.descricao = descricao;

		}

		public String getDescricao() {

			return descricao;

		}
	}

}
