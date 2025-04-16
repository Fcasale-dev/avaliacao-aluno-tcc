package com.senai.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.tcc.entity.Criterio;

@Repository
public interface CriteiroRepository extends JpaRepository<Criterio, Integer> {

	@Query("Select c from Criterio c where c.id_criterio = id_criterio")
	Iterable<Criterio> findByNum_matricula_aluno(Integer id_criterio);

}
