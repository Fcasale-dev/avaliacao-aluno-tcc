package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_aluno;
	private String nome;
	private String email;
	private Integer id_turma;

	public Aluno() {
		super();
	}

	public Aluno(Integer id_aluno, String nome, String email, Integer id_turma) {
		super();
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.email = email;
		this.id_turma = id_turma;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id_aluno, id_turma, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(email, other.email) && Objects.equals(id_aluno, other.id_aluno)
				&& Objects.equals(id_turma, other.id_turma) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Aluno [id_aluno=" + id_aluno + ", nome=" + nome + ", email=" + email + ", id_turma=" + id_turma + "]";
	}

}
