package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // GET -> Mensagem de boas-vindas
    @GetMapping("/boasVindas")
    String boasVindas() {
        return "Essa é a minha primeira mensagem por rota :>";
    }

    // POST -> Criar um ninja
    @PostMapping("/criar")
    String criarNinja() {
        return "Ninja criado";
    }

    // GET -> Listar todos os ninjas
    @GetMapping("/listar")
    String listarNinjas() {
        return "Todos os ninjas";
    }

    // GET -> Buscar ninja pelo ID
    @GetMapping("/listarID")
    String listarNinjaPorID() {
        return "Ninja ID";
    }

    // PUT -> Alterar ninja pelo ID
    @PutMapping("/alterarID")
    String alterarNinja() {
        return "Ninja editado";
    }

    // DELETE -> Deletar ninja pelo ID
    @DeleteMapping("/deletarID")
    String deletarNinjaPorID() {
        return "Ninja deletado";
    }
}