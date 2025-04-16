package com.senai.tcc.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.Competencias;
import com.senai.tcc.repository.CompetenciaRepository;

@RestController
@RequestMapping("/Competencia")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CompetenciasResource {

	@Autowired
	private final CompetenciaRepository competenciaRepository;

	@Autowired
	public CompetenciasResource(CompetenciaRepository competenciaRepository) {
		this.competenciaRepository = competenciaRepository;
	}

	@GetMapping("/competencias")
	public List<Competencias> getAllCompetencia() {
		return competenciaRepository.findAll();
	}

	@GetMapping("/consulta_Competencia/{id_competencia}")
	public ResponseEntity<Competencias> findByIdCompetencia(@PathVariable Integer id_competencia) {
		Optional<Competencias> competencia = competenciaRepository.findById(id_competencia);
		return competencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/consulta_Competencia_Curso/{id_curso}")
	public ResponseEntity<Competencias> findByCurso(@PathVariable Integer id_curso) {
		Optional<Competencias> competencia = competenciaRepository.findById(id_curso);
		return competencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/CriarCompetencia")
	public Competencias createCompetencia(@RequestBody Competencias competencia) {
		System.out.println("Tipo: " + competencia);
		return competenciaRepository.save(competencia);
	}

}
