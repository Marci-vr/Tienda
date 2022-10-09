package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;
            
    @GetMapping("/")
    public String inicio(Model model) {
        var texto = "Estamos en semana 4";
        model.addAttribute("mensaje", texto);

        /*Cliente cliente1 = new Cliente("Juan", "Perez Moreno", "jperez@gmail.com", "2552-4884");
        Cliente cliente2 = new Cliente("Pedro", "Moreno Perez", "pmoreno@gmail.com", "2552-4883");
        Cliente cliente3 = new Cliente("Rebeca", "Perez Contreras", "rperez@gmail.com", "2552-4882");
        
        var clientes =Arrays.asList(cliente1,cliente2,cliente3);*/
        
        var clientes = clienteDao.findAll();
        
        model.addAttribute("clientes", clientes);

        return "index";
    }

}
