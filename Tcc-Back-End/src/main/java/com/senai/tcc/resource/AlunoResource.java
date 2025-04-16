package com.senai.tcc.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.Aluno;
import com.senai.tcc.repository.AlunoRepository;

@RestController
@RequestMapping("/Aluno")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AlunoResource {
	
	@Autowired
	private final AlunoRepository alunoRepository;
	
	public AlunoResource(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/consultarAlunos/{id_aluno}")
	public ResponseEntity<Aluno> findByIdCompetencia(@PathVariable Integer id_aluno) {
		Optional<Aluno> competencia = alunoRepository.findById(id_aluno);
		return competencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
