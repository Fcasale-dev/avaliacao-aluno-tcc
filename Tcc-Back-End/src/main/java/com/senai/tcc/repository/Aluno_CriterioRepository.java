package com.senai.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.tcc.entity.AlunoCriterioId;
import com.senai.tcc.entity.Aluno_Criterio;

public interface Aluno_CriterioRepository extends JpaRepository<Aluno_Criterio, AlunoCriterioId> {

    @Query("SELECT ac FROM Aluno_Criterio ac WHERE ac.id.id_aluno = :id_aluno")
    Iterable<Aluno_Criterio> findByIdAluno(@Param("id_aluno") Integer id_aluno);

    @Query("SELECT ac FROM Aluno_Criterio ac WHERE ac.id.id_criterio = :id_criterio")
    Iterable<Aluno_Criterio> findByIdCriterio(@Param("id_criterio") Integer id_criterio);
}
