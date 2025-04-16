package com.senai.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.tcc.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	@Query("select a from Aluno a where a.id_aluno = id_aluno")
	Iterable<Aluno> finByIdAluno(Integer id_aluno);
}
