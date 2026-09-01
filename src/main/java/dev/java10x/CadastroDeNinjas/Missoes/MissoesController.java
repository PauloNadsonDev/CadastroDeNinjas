package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET -> MANDAR UMA REQUISIÇÃO PARA MOSTRAR AS MISSÕES
    @GetMapping("/listarMissões")
    String todasMissoes(){return "Todas as missões";}

    // POST -> MANDAR UMA REQUISIÇÃO PARA CRIAR AS MISSÕES
    @PostMapping("/criar")
    String criarMissao(){return "Missão criada";}

    // PUT -> MANDAR UMA REQUISIÇÃO PARA ALTERAR AS MISSÕES
    @PutMapping("/alterarMissao")
    String alterarMissao(){return "dados da missão alterada";}

    // DELETE -> MANDAR UMA REQUISIÇÃO PARA DELETAR AS MISSÕES
    @DeleteMapping("/deletarMissao")
    String missaoDeletada(){return "Missão deletada";}

}
