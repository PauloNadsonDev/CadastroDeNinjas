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
    List<MissoesModel> listarMissoes(){ return missoesService.listarMissoes(); }

    // POST -> Criar uma missão
    @PostMapping("/criar")
    String criarMissao() {
        return "Missão criada";
    }

    // PUT -> Alterar uma missão pelo ID
    @PutMapping("/alterarID")
    String alterarMissao() {
        return "Dados da missão alterados";
    }

    // DELETE -> Deletar uma missão pelo ID
    @DeleteMapping("/deletarID")
    String deletarMissao() {
        return "Missão deletada";
    }
}