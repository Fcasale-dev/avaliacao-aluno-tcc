package com.senai.tcc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.Turma;
import com.senai.tcc.repository.TurmaRepository;

@RestController
@RequestMapping("/Turmas")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TurmaResource {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/TodasTurmas")
	public Iterable<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	@GetMapping("/consultaTurma/{id_Turma}")
	public Iterable<Turma> findTurma(@PathVariable Integer id_Turma){
		return turmaRepository.findById_Turma(id_Turma);
	}
	
}
