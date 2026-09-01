package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // GET -> Mostrar todas as missões
    @GetMapping("/listar")
    String listarMissoes() {
        return "Todas as missões";
    }

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