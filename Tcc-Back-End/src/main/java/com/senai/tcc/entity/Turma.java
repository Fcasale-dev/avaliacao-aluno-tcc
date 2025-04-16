package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Turma {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id_Turma;
	private String nome_Turma;
	private String nome_Professor;
	
	public Turma() {
		super();
	}

	public Turma(Integer id_curso, String nome_Turma, String nome_Professor) {
		super();
		this.id_Turma = id_curso;
		this.nome_Turma = nome_Turma;
		this.nome_Professor = nome_Professor;
	}

	public Integer getId_curso() {
		return id_Turma;
	}

	public void setId_curso(Integer id_curso) {
		this.id_Turma = id_curso;
	}

	public String getNome_Turma() {
		return nome_Turma;
	}

	public void setNome_Turma(String nome_Turma) {
		this.nome_Turma = nome_Turma;
	}

	public String getNome_Professor() {
		return nome_Professor;
	}

	public void setNome_Professor(String nome_Professor) {
		this.nome_Professor = nome_Professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_Turma, nome_Professor, nome_Turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id_Turma, other.id_Turma) && Objects.equals(nome_Professor, other.nome_Professor)
				&& Objects.equals(nome_Turma, other.nome_Turma);
	}

	@Override
	public String toString() {
		return "Turma [id_Turma=" + id_Turma + ", nome_Turma=" + nome_Turma + ", nome_Professor=" + nome_Professor
				+ "]";
	}
	
	

}
