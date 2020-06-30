package br.gov.sp.fatec.projetointegrador.desenvolvedor.service;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.desenvolvedor.repository.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedorService {

    @Autowired
    private DesenvolvedorRepository repository;

    public Desenvolvedor save(Desenvolvedor desenvolvedor){
        if(desenvolvedor.getNome().isEmpty()){
            throw new RuntimeException("O nome não foi informado");
        }

        if(desenvolvedor.getCargaHoraria() <= 0d){
            throw new RuntimeException("A carga horária não foi informada");
        }

        if(repository.countByNome(desenvolvedor.getNome(), 0l) > 0L) {
            throw new RuntimeException("Desenvolvedor já cadastrado.");
        }
        return repository.save(desenvolvedor);
    }

    public List<Desenvolvedor> findByNome(String nome) {
        if(nome.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByNome(nome);
    }

    public Desenvolvedor findById(Long id) {
        Optional<Desenvolvedor> optionalDesenvolvedor = repository.findById(id);
        if(optionalDesenvolvedor.isPresent()) {
            return optionalDesenvolvedor.get();
        } else  {
            return null;
        }
    }

    public Desenvolvedor update(Long id, Desenvolvedor desenvolvedor) {
        if(desenvolvedor.getNome().isEmpty()){
            throw new RuntimeException("O nome não foi informado");
        }

        if(desenvolvedor.getCargaHoraria() <= 0d){
            throw new RuntimeException("A carga horária não foi informada");
        }

        if(repository.countByNome(desenvolvedor.getNome(), id) > 0L) {
            throw new RuntimeException("Desenvolvedor já cadastrado.");
        }
        Desenvolvedor savedDesenvolvedor = this.findById(id);
        if(desenvolvedor == null) {
            throw new RuntimeException("Desenvolvedor não encontrado.");
        }
        savedDesenvolvedor.setNome(desenvolvedor.getNome());
        savedDesenvolvedor.setCargaHoraria(desenvolvedor.getCargaHoraria());
        return repository.save(savedDesenvolvedor);
    }
}
