package br.gov.sp.fatec.projetointegrador.projeto.controller;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.desenvolvedor.service.DesenvolvedorService;
import br.gov.sp.fatec.projetointegrador.projeto.model.Projeto;
import br.gov.sp.fatec.projetointegrador.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> findAll() {
        return projetoService.findByNome("");
    }

    @PostMapping
    public Projeto save(@RequestBody Projeto projeto)  {
        return projetoService.save(projeto);
    }

    @PutMapping("/{id}")
    public Projeto update(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
        return projetoService.update(id, projeto);
    }
}
