/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Cliente;
import br.com.unincor.sistemacomanda.model.domain.Pedido;
import br.com.unincor.sistemacomanda.model.domain.Produto;

import javax.persistence.Query;
import java.util.ArrayList;

import java.util.List;

/**
 * @author otavi
 */
public class PedidoDao extends GenericDAO<Pedido, Long> {

    /*public Pedido findPorID(Long id) {
        Query query = getEntityManagerReadOnly().createQuery("from Pedido c where c.id =  :id").setParameter("id", id);
        List<Pedido> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }*/

    public Pedido findPorCliente(Cliente cliente) {
        Query query = getEntityManagerReadOnly().createQuery("from Pedido c where c.cliente =  :cliente").setParameter("cliente", cliente);
        List<Pedido> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public static void main(String[] args) {
        Cliente cliente = new ClienteDao().findById(1l);

        Pedido pedido = new Pedido();
        List<Produto> produtos = new ArrayList<>();


        pedido.setProdutos(produtos);


        pedido.setCliente(cliente);
        pedido.setDesconto(10.0);
        pedido.setValorEntrega(8.0);
        pedido.setProdutos(produtos);

        pedido.calcularValorTotal();
        pedido.calcularValorTotalItens();

        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.save(pedido);


    }
}
