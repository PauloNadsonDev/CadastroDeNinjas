package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todos as minhas missões
    List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // Listar todas as minhas missões por ID
    public MissoesModel listarMissoesID(Long id){
        Optional<MissoesModel> missoesPorID = missoesRepository.findById(id);
        return missoesPorID.orElse(null);
}

    // Criar uma nova missão
    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }
}
