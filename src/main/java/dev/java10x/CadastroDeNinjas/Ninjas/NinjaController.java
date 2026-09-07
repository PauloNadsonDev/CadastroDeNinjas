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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // GET -> Listar todos os ninjas
    @GetMapping("/listar")
    List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // GET -> Buscar ninja pelo ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
    }

    // PUT -> Alterar ninja pelo ID
    @PutMapping("/alterar/{id}")
    NinjaDTO alterarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // DELETE -> Deletar ninja pelo ID
    @DeleteMapping("/deletar/{id}")
    String deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletarNinjaPorID(id);
        return "Ninja deletado";
    }
}