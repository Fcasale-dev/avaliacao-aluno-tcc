package com.senai.tcc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.UnidadeCurricular;
import com.senai.tcc.repository.UnidadeCurricularRepository;

@RestController
@RequestMapping("/UnidadeCurricular")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UnidadeCurricularResource {

	@Autowired
	private UnidadeCurricularRepository unidadeCurricularRepository;

	@GetMapping("/TodasUnidadesCurriculares")
	public Iterable<UnidadeCurricular> findAll() {
		return unidadeCurricularRepository.findAll();
	}
	
	@GetMapping("/colsultarUnidadeCurricular/{id_curso}")
	public Iterable<UnidadeCurricular> findUnidadeCurricular(@PathVariable Integer id_Curso){
		return unidadeCurricularRepository.finfbyIdUnidadeCurricular(id_Curso);
	}

}
