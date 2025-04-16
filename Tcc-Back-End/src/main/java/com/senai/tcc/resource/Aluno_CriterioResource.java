package com.senai.tcc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senai.tcc.entity.AlunoCriterioId;
import com.senai.tcc.entity.Aluno_Criterio;
import com.senai.tcc.repository.Aluno_CriterioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Aluno_Criterio")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class Aluno_CriterioResource {

    @Autowired
    private Aluno_CriterioRepository alunoCriterioRepository;

    // Busca todos os avaliados
    @GetMapping("/TodosAvaliados")
    public Iterable<Aluno_Criterio> findAll() {
        return alunoCriterioRepository.findAll();
    }

    @PostMapping("/criarAvaliados")
    public ResponseEntity<?> criarAvaliados(@RequestBody List<Aluno_Criterio> alunocriterios) {
        try {
            for (Aluno_Criterio alunoCriterio : alunocriterios) {
                if (alunoCriterio.getId() == null) {
                    return ResponseEntity.badRequest().body("O identificador composto (id) é obrigatório.");
                }

                alunoCriterioRepository.save(alunoCriterio);
            }
            return ResponseEntity.status(201).body("Avaliações criadas com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar avaliações: " + e.getMessage());
        }
    }


    @PutMapping("/atualizaAvaliado")
    public ResponseEntity<Aluno_Criterio> atualizaAvaliado(@RequestBody Aluno_Criterio alunocriterio) {
        try {
            AlunoCriterioId id = new AlunoCriterioId(alunocriterio.getId().getId_aluno(), alunocriterio.getId().getId_criterio());
            Optional<Aluno_Criterio> existingAvaliacao = alunoCriterioRepository.findById(id);

            if (existingAvaliacao.isPresent()) {
                Aluno_Criterio updatedAvaliacao = alunoCriterioRepository.save(alunocriterio);
                return ResponseEntity.ok(updatedAvaliacao);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/avaliacaoExistente/{id_aluno}/{id_criterio}")
    public ResponseEntity<Boolean> verificarExistencia(@PathVariable Integer id_aluno, @PathVariable Integer id_criterio) {
        AlunoCriterioId id = new AlunoCriterioId(id_aluno, id_criterio);
        Optional<Aluno_Criterio> avaliacaoExistente = alunoCriterioRepository.findById(id);
        return avaliacaoExistente.isPresent() ? ResponseEntity.ok(true) : ResponseEntity.ok(false);
    }

}
