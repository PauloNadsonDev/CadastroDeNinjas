package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesID(Long id){
        Optional<MissoesModel> missoesPorID = missoesRepository.findById(id);
        return missoesPorID.map(missoesMapper::map).orElse(null);
}

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public void deletarMissaoPorID(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO alterarDadosDaMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if (missoesExistente.isPresent()){
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
            MissoesModel missoesSalvo = missoesRepository.save(missoesAtualizado);
            return missoesMapper.map(missoesSalvo);
        }
        return null;
    }
}
