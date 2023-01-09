package br.com.unincor.sistemacomanda.model.servicos;

import br.com.unincor.sistemacomanda.model.dao.PedidoDao;
import br.com.unincor.sistemacomanda.model.domain.Cliente;
import br.com.unincor.sistemacomanda.model.domain.Pedido;
import br.com.unincor.sistemacomanda.model.domain.Produto;
import br.com.unincor.sistemacomanda.model.exception.ClienteException;
import br.com.unincor.sistemacomanda.model.exception.PedidoException;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    public Pedido salvarPedido(Pedido pedido) throws PedidoException {
        PedidoDao pedidoDao = new PedidoDao();

        if (pedidoDao.findPorCliente(pedido.getCliente()) != null) {
            throw new PedidoException("Pedido possui cliente informado!");
        }
        if (pedido.getProdutos() == null) {
            throw new PedidoException("Lista de produtos vazia!");
        }
        if (pedido.getValorItens() <= 0) {
            throw new PedidoException("Pedido valor menor que 0!");
        }
        if (pedido.getDesconto() > pedido.getValorTotal()) {
            throw new PedidoException("Valor do desconto é maior que o valor total!");
        }
        if (pedido.getValorEntrega() == 8.0) {
            throw new PedidoException("Valor de entrega é 8 reais");
        }
        if (pedido.getValorItens() > 100.0) {
            pedido.setValorEntrega(0.d);
        }
        pedido.calcularValorTotal();

        return pedidoDao.save(pedido);
    }


    public List<Pedido> buscarPedidoPorCliente(Cliente cliente) throws PedidoException {
        PedidoDao pedidoDao = new PedidoDao();

        if (cliente == null) {
            throw new PedidoException("Cliente não pode estar vazio!");
        }

        List<Cliente> clientes = pedidoDao.buscarPedidoPorCliente(cliente);

        return clientes;
    }

    public static void main(String[] args) {
        try {
            List<Produto> produtos = new ArrayList<>();
            Pedido pedido = new Pedido();
            Cliente cliente = new Cliente();
            pedido.setCliente(cliente);
            pedido.setDesconto(10.0);
            pedido.setValorEntrega(8.0);
            pedido.setProdutos(produtos);
            System.out.println(new PedidoService().salvarPedido(pedido));
        } catch (PedidoException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
