package com.senai.tcc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.Professor;
import com.senai.tcc.repository.ProfessorRepository;

@RestController
@RequestMapping("/Professores")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProfessorResource {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping("/TodosProfessores")
	public List<Professor> findAll(){
		return professorRepository.findAll();
	}
	
	@GetMapping("/consultaProfessor/{nome_Professor}")
	public List<Professor> findProfessor(@PathVariable String nome_Professor) {
		return professorRepository.findByNomeProfessor(nome_Professor);
	}
}
