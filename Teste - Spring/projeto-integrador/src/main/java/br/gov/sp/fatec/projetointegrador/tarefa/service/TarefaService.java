package br.gov.sp.fatec.projetointegrador.tarefa.service;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.tarefa.model.Tarefa;
import br.gov.sp.fatec.projetointegrador.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository repository;

    public Tarefa save(Tarefa tarefa){
        if(tarefa.getTitulo().isEmpty()){
            throw new RuntimeException("O titulo da tarefa não foi informado");
        }
        if(tarefa.getProjeto() == null){
            throw new RuntimeException("O projeto pertencente a esta tarefa não foi informado");
        }
        if(tarefa.getDesenvolvedor() == null){
            throw new RuntimeException(("O desenvolvedor não foi informado"));
        }
        if(tarefa.getDuracao() <= 0){
            throw new RuntimeException(("A duração da tarefa não foi informada"));
        }
        if(repository.countByTituloAndProjeto(tarefa.getTitulo(), tarefa.getProjeto().getId()) > 0L) {
            throw new RuntimeException("Título já usado");
        }
        return repository.save(tarefa);
    }
    public List<Tarefa> findByNome(String titulo) {
        if(titulo.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByTitulo(titulo);
    }
    public Tarefa findById(Long id) {
        Optional<Tarefa> optionalTarefa = repository.findById(id);
        if(optionalTarefa.isPresent()) {
            return optionalTarefa.get();
        } else  {
            return null;
        }
    }

    public Tarefa update(Long id, Tarefa tarefa) {
        if(tarefa.getTitulo().isEmpty()){
            throw new RuntimeException("O titulo da tarefa não foi informado");
        }
        if(tarefa.getProjeto() == null){
            throw new RuntimeException("O projeto pertencente a esta tarefa não foi informado");
        }
        if(tarefa.getDesenvolvedor() == null){
            throw new RuntimeException(("O desenvolvedor não foi informado"));
        }
        if(tarefa.getDuracao() <= 0){
            throw new RuntimeException(("A duração da tarefa não foi informada"));
        }
        if(repository.countByTituloAndProjeto(tarefa.getTitulo(), tarefa.getProjeto().getId()) > 0L) {
            throw new RuntimeException("Título já usado");
        }
        Tarefa savedTarefa = this.findById(id);
        if(tarefa == null) {
            throw new RuntimeException("Tarefa não encontrada.");
        }
        savedTarefa.setTitulo(tarefa.getTitulo());
        savedTarefa.setDuracao(tarefa.getDuracao());
        savedTarefa.setDesenvolvedor(tarefa.getDesenvolvedor());
        return repository.save(savedTarefa);
    }
}
