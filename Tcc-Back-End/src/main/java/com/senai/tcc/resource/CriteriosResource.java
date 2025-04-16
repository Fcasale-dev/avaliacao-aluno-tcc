package com.senai.tcc.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.Criterio;
import com.senai.tcc.repository.CriteiroRepository;

@RestController
@RequestMapping("/Criterios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CriteriosResource {
	
	// Mapeamentos e escopos
		private final CriteiroRepository criterioRepository;

		@Autowired
		public CriteriosResource(CriteiroRepository criterioRepository) {
			this.criterioRepository = criterioRepository;
		}

		@GetMapping("/BuscarCriterios")
		public List<Criterio> getAll() {
			return criterioRepository.findAll();
		}

		@GetMapping("/BuscarCriterio/{id_Criterio}")
		public ResponseEntity<Criterio> findById(@PathVariable Integer id_Criterio) {
		    Optional<Criterio> criterio = criterioRepository.findById(id_Criterio);
		    return criterio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		}

		@PostMapping("/CriarCriterio")
		public ResponseEntity<Criterio> createCriterio(@RequestBody Criterio criterio) {
		    System.out.println("Tipo: "+criterio);
		    Criterio novoCriterio = criterioRepository.save(criterio);
		    return ResponseEntity.created(URI.create("/Criterios/BuscarCriterio/" + novoCriterio.getId_criterio())).body(novoCriterio);
		}
		
		@DeleteMapping("/DeleteCriteiro/{id_Criterio}")
		public void deletaCriterio(@PathVariable Integer id_Criterio) {
			criterioRepository.deleteById(id_Criterio);
		}

}
