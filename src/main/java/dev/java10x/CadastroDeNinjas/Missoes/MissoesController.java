package dev.java10x.CadastroDeNinjas.Missoes;

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
    MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.alterarDadosDaMissao(id, missaoAtualizada);
    }

    // DELETE -> Deletar uma missão pelo ID
    @DeleteMapping("/deletar/{id}")
    String deletarNinjaPorID(@PathVariable Long id){
        missoesService.deletarMissaoPorID(id);
        return "Missão deletada";
    }
}