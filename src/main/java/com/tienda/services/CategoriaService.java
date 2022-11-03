package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se definen los 4 metodos de un CRUD   
    // Create Read Update Delete

    //Retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
    
    //Dado un categoria.id se busca en la tabla y 
    //se retorna todo el objeto Categoria
    public Categoria getCategoria(Categoria categoria);
    
    // Si categoria.id tiene un valor, se busca y se actualiza
    // Si categoria.id no tiene  valor, se inserta onbjeto en la tabla
    public void save(Categoria categoria);
    
    //Elimina el registro que tiene un id igual a cli8ente.id
    public void delete(Categoria categoria);
}
