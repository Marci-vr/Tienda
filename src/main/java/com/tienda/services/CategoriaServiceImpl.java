package com.tienda.services;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    //Se implementan los 4 metodos de un CRUD   
    // Create Read Update Delete mediante CategoriaDao

    // Se utiliza una anotacion Autowired para el objeto CategoriaDao
    // Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    @Autowired
    private CategoriaDao categoriaDao;

    //Retorna la lista de categorias
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        if (activos) { //solo los categorias activas
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    //Dado un categoria.id se busca en la tabla y 
    //se retorna todo el objeto Categoria
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    // Si categoria.id tiene un valor, se busca y se actualiza
    // Si categoria.id no tiene  valor, se inserta onbjeto en la tabla
    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    //Elimina el registro que tiene un id igual a cli8ente.id
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
