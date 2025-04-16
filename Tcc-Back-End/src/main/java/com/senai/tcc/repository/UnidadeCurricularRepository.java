package com.senai.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senai.tcc.entity.UnidadeCurricular;



public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular, Integer> {
	@Query("select uc from UnidadeCurricular uc where uc.id_curso = id_curso")
	Iterable<UnidadeCurricular> finfbyIdUnidadeCurricular(Integer id_curso);

}
