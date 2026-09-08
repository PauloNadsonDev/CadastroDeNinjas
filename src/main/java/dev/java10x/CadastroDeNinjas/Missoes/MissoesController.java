package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -> Mostrar todas as missões
    @GetMapping("/listar")
    List<MissoesDTO> listarMissoes(){ return missoesService.listarMissoes(); }

    // Mostrar as missões por ID
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesId(@PathVariable Long id){
        return missoesService.listarMissoesID(id);
    }

    // POST -> Criar uma missão
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }

    // PUT -> Alterar uma missão pelo ID
    @PutMapping("/alterar/{id}")
    ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        if (missoesService.listarMissoesID(id) != null){
            missoesService.alterarDadosDaMissao(id, missaoAtualizada);
            return ResponseEntity.ok("Missão por ID: " + id + " Foi atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão: " + id + "Não foi encontrada ou não existe");
        }
    }

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (missoesService.listarMissoesID(id) != null) {
            missoesService.deletarMissaoPorID(id);
            return ResponseEntity.ok("Missão deletada: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão: " + id + " Não foi encontrada ou não existe");
        }

    }
}