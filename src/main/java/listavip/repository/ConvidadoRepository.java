package listavip.repository;

import listavip.modelo.Convidado;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudReposytory serve para ter todas as implementações prontas logo de cara
 */
public interface ConvidadoRepository extends CrudRepository<Convidado,Long> {
}
