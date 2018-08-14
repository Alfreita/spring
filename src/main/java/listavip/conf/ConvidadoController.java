package listavip.conf;

import listavip.modelo.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import listavip.repository.ConvidadoRepository;

import javax.sql.DataSource;


@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listadeconvidados(Model model){

        Iterable<Convidado> convidados = repository.findAll();
        model.addAttribute("convidados",convidados);

        return "listaconvidados";
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

}
