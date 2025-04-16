package com.senai.tcc.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tcc.entity.NotaAluno;
import com.senai.tcc.repository.NotaAlunoRepository;

@RestController
@RequestMapping("/NotaAluno")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class NotaAlunoResource {
    
    @Autowired
    private final NotaAlunoRepository notaAlunoRepository;

    public NotaAlunoResource(NotaAlunoRepository notaAlunoRepository) {
        this.notaAlunoRepository = notaAlunoRepository;
    }

    @GetMapping("/Notas")
    public List<NotaAluno> getAllNotas(){
        return notaAlunoRepository.findAll();
    }

    @GetMapping("/consultarAlunos/{id_aluno}")
    public ResponseEntity<NotaAluno> findByIdCompetencia(@PathVariable Integer id_nota) {
        Optional<NotaAluno> competencia = notaAlunoRepository.findById(id_nota);
        return competencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/lancarNotas")
    public List<NotaAluno> createNotasAluno(@RequestBody List<NotaAluno> notasAluno) {
        return notaAlunoRepository.saveAll(notasAluno);
    }

    // Novo endpoint para gerar o PDF
    @GetMapping("/gerarPdf")
    public ResponseEntity<byte[]> gerarPdf() throws IOException {

        // Obter todas as notas do banco de dados
        List<NotaAluno> notas = notaAlunoRepository.findAll();

        // Criar um ByteArrayOutputStream para gerar o PDF em memória
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Criar o documento PDF
        try (PDDocument document = new PDDocument()) {

            // Criar uma página no PDF
            PDPage page = new PDPage();
            document.addPage(page);

            // Criar o fluxo de conteúdo da página
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(50, 750); // Posição inicial do texto

                // Adicionar título
                contentStream.showText("Notas dos Alunos");
                contentStream.newLineAtOffset(0, -20); // Espaçamento abaixo do título

                // Adicionar dados dos alunos e suas notas
                for (NotaAluno nota : notas) {
                    // Validar valores nulos para evitar erros
                    String nomeAluno = nota.getNomeAluno() != null ? nota.getNomeAluno() : "Nome não informado";
                    String notaAluno = nota.getNota() != null ? String.valueOf(nota.getNota()) : "Nota não informada";
                    String data = nota.getData_avaliacao() != null ? String.valueOf(nota.getData_avaliacao()) : "Data não informada";

                    contentStream.showText("Aluno: " + nomeAluno);
                    contentStream.newLineAtOffset(0, -15); // Espaçamento entre linhas
                    contentStream.showText("Nota: " + notaAluno);
                    contentStream.newLineAtOffset(0, -15); // Espaçamento adicional entre alunos
                    contentStream.showText("Data Avaliação: " + data);
                    contentStream.newLineAtOffset(0, -30);
                }

                contentStream.endText();
            }

            // Salvar o documento no ByteArrayOutputStream
            document.save(byteArrayOutputStream);
        }

        // Configurar o cabeçalho para o arquivo PDF
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=notas_alunos.pdf");

        // Retornar o PDF gerado
        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }


}
