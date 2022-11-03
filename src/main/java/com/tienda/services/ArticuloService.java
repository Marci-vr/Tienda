package com.tienda.services;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    //Se definen los 4 metodos de un CRUD   
    // Create Read Update Delete

    //Retorna la lista de articulos
    public List<Articulo> getArticulos(boolean activos);
    
    //Dado un articulo.id se busca en la tabla y 
    //se retorna todo el objeto Articulo
    public Articulo getArticulo(Articulo articulo);
    
    // Si articulo.id tiene un valor, se busca y se actualiza
    // Si articulo.id no tiene  valor, se inserta onbjeto en la tabla
    public void save(Articulo articulo);
    
    //Elimina el registro que tiene un id igual a cli8ente.id
    public void delete(Articulo articulo);
}
