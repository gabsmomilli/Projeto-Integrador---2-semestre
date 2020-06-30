package br.gov.sp.fatec.projetointegrador.projeto.repository;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.projeto.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("SELECT COUNT(p) FROM Projeto p WHERE p.nome like :nome AND p.cliente like :cliente")
    Long countByNome(@Param("nome") String nome, @Param("cliente") String cliente);

    @Query("SELECT p FROM Projeto p WHERE p.nome like :nome")
    List<Projeto> findAllByNome(@Param("nome") String nome);

}
