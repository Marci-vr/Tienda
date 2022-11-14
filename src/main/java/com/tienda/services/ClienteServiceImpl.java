package com.tienda.services;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    //Se implementan los 4 metodos de un CRUD   
    // Create Read Update Delete mediante ClienteDao

    // Se utiliza una anotacion Autowired para el objeto ClienteDao
    // Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    @Autowired
    private ClienteDao clienteDao;

    // Se utiliza una anotacion Autowired para el objeto ClienteDao
    // Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    @Autowired
    private CreditoDao creditoDao;

    //Retorna la lista de clientes
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    //Dado un cliente.id se busca en la tabla y 
    //se retorna todo el objeto Cliente
    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    // Si cliente.id tiene un valor, se busca y se actualiza
    // Si cliente.id no tiene  valor, se inserta onbjeto en la tabla
    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();

        credito = creditoDao.save(credito);

        cliente.setCredito(credito);

        clienteDao.save(cliente);
    }

    //Elimina el registro que tiene un id igual a cli8ente.id
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getClientePorApellido(String apellidos) {
        return clienteDao.findbyApellidos(apellidos);
    }
}
