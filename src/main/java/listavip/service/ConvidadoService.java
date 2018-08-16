package listavip.service;

import listavip.modelo.Convidado;
import listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado>findAll(){
        Iterable<Convidado>convidados=repository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);

    }
}
