package com.senai.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.tcc.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
	@Query("select p from Professor p where p.nome_Professor = :nome_professor")
	List<Professor> findByNomeProfessor(String nome_professor);
	

}
