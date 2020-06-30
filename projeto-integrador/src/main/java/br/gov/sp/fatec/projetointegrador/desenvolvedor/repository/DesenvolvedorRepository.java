package br.gov.sp.fatec.projetointegrador.desenvolvedor.repository;

import br.gov.sp.fatec.projetointegrador.desenvolvedor.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
    @Query("select count(d) from Desenvolvedor d where d.nome like :nome and d.id <> :id")
    Long countByNome(@Param("nome") String nome, @Param("id") Long id);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.nome like :nome")
    List<Desenvolvedor> findAllByNome(@Param("nome") String nome);
}
