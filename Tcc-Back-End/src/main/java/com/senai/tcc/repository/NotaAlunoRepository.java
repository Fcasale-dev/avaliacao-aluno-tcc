package com.senai.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senai.tcc.entity.NotaAluno;

public interface NotaAlunoRepository extends JpaRepository<NotaAluno,Integer> {

	@Query("select na from NotaAluno na where na.id_nota = id_nota")
	Iterable<NotaAluno> findByIdNota(Integer id_nota);
	
}
