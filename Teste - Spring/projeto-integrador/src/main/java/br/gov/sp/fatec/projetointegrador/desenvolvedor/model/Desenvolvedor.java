package br.gov.sp.fatec.projetointegrador.desenvolvedor.model;

import br.gov.sp.fatec.projetointegrador.tarefa.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name="desenvolvedor")
@NoArgsConstructor
@AllArgsConstructor
public class Desenvolvedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer cargaHoraria;

    @OneToMany(mappedBy = "desenvolvedor")
    private List<Tarefa> tarefas;
}
