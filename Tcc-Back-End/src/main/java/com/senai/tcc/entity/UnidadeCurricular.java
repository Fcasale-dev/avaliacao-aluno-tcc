package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UnidadeCurricular {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id_curso;
	private String nome_Curso;
	private Integer id_Turma;
	
	public UnidadeCurricular() {
		super();
	}

	public UnidadeCurricular(Integer id_curso, String nome_Curso, Integer id_Turma) {
		super();
		this.id_curso = id_curso;
		this.nome_Curso = nome_Curso;
		this.id_Turma = id_Turma;
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome_Curso() {
		return nome_Curso;
	}

	public void setNome_Curso(String nome_Curso) {
		this.nome_Curso = nome_Curso;
	}

	public Integer getId_Turma() {
		return id_Turma;
	}

	public void setId_Turma(Integer id_Turma) {
		this.id_Turma = id_Turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_Turma, id_curso, nome_Curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeCurricular other = (UnidadeCurricular) obj;
		return Objects.equals(id_Turma, other.id_Turma) && Objects.equals(id_curso, other.id_curso)
				&& Objects.equals(nome_Curso, other.nome_Curso);
	}

	@Override
	public String toString() {
		return "Unidade_Curricular [id_curso=" + id_curso + ", nome_Curso=" + nome_Curso + ", id_Turma=" + id_Turma
				+ "]";
	}
	
	

}
