package com.senai.tcc.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotaAluno {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_nota;
	
	private Integer nota;
	private Integer id_alunoNota;
	private Date data_avaliacao;
	private String nome_aluno; // Novo campo para armazenar o nome do aluno

	public NotaAluno() {
		super();
	}

	public NotaAluno(Integer id_nota, Integer nota, Integer id_alunoNota, Date data_avaliacao, String nome_aluno) {
		super();
		this.id_nota = id_nota;
		this.nota = nota;
		this.id_alunoNota = id_alunoNota;
		this.data_avaliacao = data_avaliacao;
		this.nome_aluno = nome_aluno; // Inicialização do novo campo
	}

	
	public Integer getId_nota() {
		return id_nota;
	}

	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Integer getId_alunoNota() {
		return id_alunoNota;
	}

	public void setId_alunoNota(Integer id_alunoNota) {
		this.id_alunoNota = id_alunoNota;
	}

	public Date getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public String getNomeAluno() {
		return nome_aluno;
	}

	public void setNomeAluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	@Override	
	public String toString() {
		return "NotaAluno [id_nota=" + id_nota + ", nota=" + nota + ", id_alunoNota=" + id_alunoNota
				+ ", data_avaliacao=" + data_avaliacao + ", nomeAluno=" + nome_aluno + "]"; // Inclui nomeAluno
	}
}
