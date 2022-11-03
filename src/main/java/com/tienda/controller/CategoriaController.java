package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    
     @GetMapping("/categoria/listado") //ruta metodo
    public String inicio(Model model) {
        var texto = "Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
        var categorias = categoriaService.getCategorias(false);
        
        model.addAttribute("categorias", categorias);

        return "/categoria/listado"; // ruta pagina
    }

    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificarCategoria/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {

        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);

        return "/categoria/modificar";
    }

    @GetMapping("/categoria/eliminarCategoria/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {

        categoriaService.delete(categoria);

        return "redirect:/categoria/listado";
    }
}
