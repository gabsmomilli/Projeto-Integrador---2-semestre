package br.gov.sp.fatec.projetointegrador.desenvolvedor.controller;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.desenvolvedor.service.DesenvolvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/desenvolvedores")
public class DesenvolvedorController {
    @Autowired
    private DesenvolvedorService desenvolvedorService;

    @GetMapping
    public List<Desenvolvedor> findAll() {
        return desenvolvedorService.findByNome("");
    }

    @PostMapping
    public Desenvolvedor save(@RequestBody Desenvolvedor desenvolvedor)  {
        return desenvolvedorService.save(desenvolvedor);
    }

    @PutMapping("/{id}")
    public Desenvolvedor update(@PathVariable("id") Long id, @RequestBody Desenvolvedor desenvolvedor) {
        return desenvolvedorService.update(id, desenvolvedor);
    }

}
