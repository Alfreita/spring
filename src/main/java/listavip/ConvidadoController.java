package listavip;

import br.com.victor.enviadorEmail.enviadorEmail.*;
import listavip.modelo.Convidado;
import listavip.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("listavip")
    public String listadeconvidados(Model model){

        Iterable<Convidado> convidados = service.findAll();
        model.addAttribute("convidados",convidados);

        return "listaconvidados";
    }
    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone, Model model ){

        Convidado novoConvidado = new Convidado(nome, email, telefone);
        service.salvar(novoConvidado);

         new EmailService().enviar(nome,email);

        Iterable<Convidado> convidados = service.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }


}
