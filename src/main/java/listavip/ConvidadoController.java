package listavip;

import modelo.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repo;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listadeconvidados(Model model){

        Iterable<Convidado> convidados = repo.findAll();
        model.addAttribute("convidados",convidados);


        return "listaconvidados";
    }
}
