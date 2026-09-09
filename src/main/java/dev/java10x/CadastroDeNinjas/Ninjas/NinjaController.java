package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getID());
    }

    @GetMapping("/listar")
    ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjaDTOS = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOS);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjas = ninjaService.listarNinjasPorID(id);

        if (ninjas != null){
            return ResponseEntity.ok(ninjas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja do id: " + id + " não existe");
        }

    }

    @PutMapping("/alterar/{id}")
    ResponseEntity<String> alterarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorID(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja por ID :" + id + " foi atualizado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja: " + id + " não foi encontrado ou não existe");
        }
    }

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja deletado: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja : " + id + " não foi encontrado");
        }
    }
}