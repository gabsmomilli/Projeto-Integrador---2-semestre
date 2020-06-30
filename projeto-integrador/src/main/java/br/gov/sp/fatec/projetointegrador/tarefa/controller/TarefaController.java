package br.gov.sp.fatec.projetointegrador.tarefa.controller;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.desenvolvedor.service.DesenvolvedorService;
import br.gov.sp.fatec.projetointegrador.tarefa.model.Tarefa;
import br.gov.sp.fatec.projetointegrador.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> findAll() {
        return tarefaService.findByNome("");
    }

    @PostMapping
    public Tarefa save(@RequestBody Tarefa tarefa)  {
        return tarefaService.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa update(@PathVariable("id") Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.update(id, tarefa);
    }
}
