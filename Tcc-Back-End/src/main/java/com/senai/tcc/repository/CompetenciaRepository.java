package com.senai.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.tcc.entity.Competencias;


@Repository
public interface CompetenciaRepository extends JpaRepository<Competencias, Integer> {

    @Query("SELECT c FROM Competencias c WHERE c.id_competencia = id_competencia")
    Iterable<Competencias> findByNome( Integer id_competencia);
    
    @Query("Select c from Competencias c where c.id_curso = id_curso")
    Iterable<Competencias> findByCurso(Integer id_curso);

	@Query("SELECT c FROM Competencias c WHERE c.tipo = 'socioemocional'")
	Iterable<Competencias> findByTipoS();

	@Query("SELECT c FROM Competencias c WHERE c.tipo = 'basica'")
	Iterable<Competencias> findByTipoB();

	@Query("SELECT c FROM Competencias c WHERE c.tipo = 'tecnica'")
	Iterable<Competencias> findByTipoT();
	
}
