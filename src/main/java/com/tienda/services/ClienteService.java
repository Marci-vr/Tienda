package com.tienda.services;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {
    //Se definen los 4 metodos de un CRUD   
    // Create Read Update Delete

    //Retorna la lista de clientes
    public List<Cliente> getClientes();
    
    //Dado un cliente.id se busca en la tabla y 
    //se retorna todo el objeto Cliente
    public Cliente getCliente(Cliente cliente);
    
    // Si cliente.id tiene un valor, se busca y se actualiza
    // Si cliente.id no tiene  valor, se inserta onbjeto en la tabla
    public void save(Cliente cliente);
    
    //Elimina el registro que tiene un id igual a cli8ente.id
    public void delete(Cliente cliente);
}
