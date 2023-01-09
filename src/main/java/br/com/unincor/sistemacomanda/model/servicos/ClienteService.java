package br.com.unincor.sistemacomanda.model.servicos;

import br.com.unincor.sistemacomanda.model.dao.ClienteDao;
import br.com.unincor.sistemacomanda.model.domain.Cliente;
import br.com.unincor.sistemacomanda.model.exception.ClienteException;

import java.util.Date;

public class ClienteService {
    public Cliente salvarCliente(Cliente cliente) throws ClienteException {
        ClienteDao clienteDao = new ClienteDao();

        if (clienteDao.findPorCpf(cliente.getCpf()) != null && cliente.getId() == null) {
            throw new ClienteException("Este cpf já se encontra cadastrado!");
        }
        if (clienteDao.findPorEmail(cliente.getEmail()) != null && cliente.getId() == null) {
            throw new ClienteException("Este email já está cadastrado!");
        }
        return clienteDao.save(cliente);
    }

    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome("teste");
            cliente.setCpf("1111");
            cliente.setEmail("teste@teste.com");
            cliente.setDataNascimento(new Date());
            cliente.setCelular("111");

            System.out.println(new ClienteService().salvarCliente(cliente));
        } catch (ClienteException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
