package com.senai.tcc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.tcc.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	@Query("select t from Turma t where t.id_Turma = id_Turma")
	Iterable<Turma> findById_Turma(Integer id_Turma);
	

}
