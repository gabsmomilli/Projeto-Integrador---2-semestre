package br.gov.sp.fatec.projetointegrador.tarefa.repository;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import br.gov.sp.fatec.projetointegrador.tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    @Query("SELECT COUNT(t) FROM Tarefa t join t.projeto p WHERE t.titulo like :titulo and p.id = :id")
    Long countByTituloAndProjeto(@Param("titulo") String titulo, @Param("id") Long id);

    @Query("SELECT t FROM Tarefa t WHERE t.titulo like :titulo")
    List<Tarefa> findAllByTitulo(@Param("titulo") String titulo);

}
