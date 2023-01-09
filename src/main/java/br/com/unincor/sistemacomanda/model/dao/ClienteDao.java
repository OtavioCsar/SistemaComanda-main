/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Cliente;


import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * @author otavi
 */

public class ClienteDao extends GenericDAO<Cliente, Long> {

    public Cliente findPorCpf(String cpf) {
        Query query = getEntityManagerReadOnly().createQuery("from Cliente c where c.cpf =  :cpf").setParameter("cpf", cpf);
        List<Cliente> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);

    }

    public Cliente findPorEmail(String email) {
        Query query = getEntityManagerReadOnly().createQuery("from Cliente c where c.email =  :email").setParameter("email", email);
        List<Cliente> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        cliente.setNome("Teste");
        cliente.setCpf("000.000.000-21");
        cliente.setDataNascimento(new Date());
        cliente.setEmail("teste@email.com");
        cliente.setCelular("1111111111");

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.save(cliente);

    }
}
