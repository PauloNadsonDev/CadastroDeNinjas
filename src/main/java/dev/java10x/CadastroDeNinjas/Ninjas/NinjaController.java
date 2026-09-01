package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    String boasVindas(){
        return "Essa é a minha primeira mensagem por rota :>";
    }

    @PostMapping("/criar")
    String criarNinja(){ return "Ninja criado";}

    @GetMapping("/todos")
    String mostrarNinjas(){ return "Todos os ninjas";}

    @GetMapping("/MostrarNinjaPorID")
    String ninjaID(){return "Ninja ID";}

    @PutMapping("AlterarNinjaID")
    String alterarNinja(){return "Ninja editado";}

    @DeleteMapping
    String deletarPorID(){return "Ninja deletado";}

}
