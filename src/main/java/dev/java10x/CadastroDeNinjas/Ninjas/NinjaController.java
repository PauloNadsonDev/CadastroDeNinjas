package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // POST -> Criar um ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }


    // GET -> Listar todos os ninjas
    @GetMapping("/listar")
    List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // GET -> Buscar ninja pelo ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorID(id);
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