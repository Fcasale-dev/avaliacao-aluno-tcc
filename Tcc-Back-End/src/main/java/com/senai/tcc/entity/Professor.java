package com.senai.tcc.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {

	private static final long serialVersionUID = 1L;

	@Id
	private String nome_Professor;
	private String senha_Professor;

	public Professor() {
		super();
	}

	public Professor(String nome_Professor, String senha_Professor) {
		super();
		this.nome_Professor = nome_Professor;
		this.senha_Professor = senha_Professor;
	}

	public String getNome_Professor() {
		return nome_Professor;
	}

	public void setNome_Professor(String nome_Professor) {
		this.nome_Professor = nome_Professor;
	}

	public String getSenha_Professor() {
		return senha_Professor;
	}

	public void setSenha_Professor(String senha_Professor) {
		this.senha_Professor = senha_Professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome_Professor, senha_Professor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(nome_Professor, other.nome_Professor)
				&& Objects.equals(senha_Professor, other.senha_Professor);
	}

	@Override
	public String toString() {
		return "professor [nome_Professor=" + nome_Professor + ", senha_Professor=" + senha_Professor + "]";
	}
	
	
	
	

}
