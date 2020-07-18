package br.gov.sp.fatec.projetointegrador.projeto.service;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.projeto.model.Projeto;
import br.gov.sp.fatec.projetointegrador.projeto.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public Projeto save(Projeto projeto){
        if(projeto.getNome().isEmpty()){
            throw new RuntimeException("O mês não foi informado");
        }
        if(projeto.getDataInicio() == null){
            throw new RuntimeException("A data de início não foi informada.");
        }
        if(projeto.getDataEntrega() == null){
            throw new RuntimeException("A data de entrega não foi informada.");
        }
        if(projeto.getDataEntrega().isBefore(projeto.getDataInicio())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data de início.");
        }
        if(projeto.getDataEntrega().isBefore(LocalDate.now())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data atual.");
        }
        if(projeto.getCliente() == null){
            throw new RuntimeException(("O cliente não foi informado"));
        }
        if(repository.countByNome(projeto.getNome(), projeto.getCliente()) > 0L) {
            throw new RuntimeException("Projeto já cadastrado");
        }
        return repository.save(projeto);
    }

    public List<Projeto> findByNome(String nome) {
        if(nome.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByNome(nome);
    }
    public Projeto findById(Long id) {
        Optional<Projeto> optionalProjeto = repository.findById(id);
        if(optionalProjeto.isPresent()) {
            return optionalProjeto.get();
        } else  {
            return null;
        }
    }

    public Projeto update(Long id, Projeto projeto) {
        if(projeto.getNome().isEmpty()){
            throw new RuntimeException("O mês não foi informado");
        }
        if(projeto.getDataInicio() == null){
            throw new RuntimeException("A data de início não foi informada.");
        }
        if(projeto.getDataEntrega() == null){
            throw new RuntimeException("A data de entrega não foi informada.");
        }
        if(projeto.getDataEntrega().isBefore(projeto.getDataInicio())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data de início.");
        }
        if(projeto.getDataEntrega().isBefore(LocalDate.now())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data atual.");
        }
        if(projeto.getCliente() == null){
            throw new RuntimeException(("O cliente não foi informado"));
        }
        if(repository.countByNome(projeto.getNome(), projeto.getCliente()) > 0L) {
            throw new RuntimeException("Projeto já cadastrado");
        }
        Projeto savedProjeto = this.findById(id);
        if(projeto == null) {
            throw new RuntimeException("Projeto não encontrado.");
        }
        savedProjeto.setNome(projeto.getNome());
        savedProjeto.setDataInicio(projeto.getDataInicio());
        savedProjeto.setDataEntrega(projeto.getDataEntrega());
        savedProjeto.setCliente(projeto.getCliente());
        return repository.save(savedProjeto);
    }
}
