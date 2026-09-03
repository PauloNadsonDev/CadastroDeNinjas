package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    // Listar todos os meus ninjas
    List<NinjaModel> listarNinjas(){
        return ninjasRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public NinjaModel listarNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorID = ninjasRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

}
