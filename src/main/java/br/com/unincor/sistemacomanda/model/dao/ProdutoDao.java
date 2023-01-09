/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.dao;

import br.com.unincor.sistemacomanda.model.domain.Produto;
import br.com.unincor.sistemacomanda.model.domain.TipoUnidade;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * @author otavi
 */
public class ProdutoDao extends GenericDAO<Produto, Long> {

    public Produto findPorNome(String nome) {
        Query query = getEntityManagerReadOnly().createQuery("from Produto n where n.nome =  :nome").setParameter("nome", nome);
        List<Produto> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);

    }


    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Meu 4 produto");
        produto.setPreco(5000.);
        produto.setEstoque(100.);
        produto.setTipoUnidade(TipoUnidade.UN);
        produto.setValidade(new Date());
        ProdutoDao produtoDao = new ProdutoDao();

        produtoDao.save(produto);
    }
}
