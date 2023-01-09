package br.com.unincor.sistemacomanda.model.servicos;

import br.com.unincor.sistemacomanda.model.dao.ProdutoDao;
import br.com.unincor.sistemacomanda.model.domain.Produto;
import br.com.unincor.sistemacomanda.model.domain.TipoUnidade;
import br.com.unincor.sistemacomanda.model.exception.ProdutoException;

import java.util.Date;


public class ProdutoService {
    public Produto salvarProduto(Produto produto) throws ProdutoException {
        ProdutoDao produtoDao = new ProdutoDao();

        if (produtoDao.findPorNome(produto.getNome()) != null) {
            throw new ProdutoException("Este produto já se encontra cadastrado!");
        }
        return produtoDao.save(produto);
    }

    public static void main(String[] args) {
        try {
            Produto produto = new Produto();
            produto.setNome("Meu 4 produto");
            produto.setPreco(5000.);
            produto.setEstoque(100.);
            produto.setTipoUnidade(TipoUnidade.UN);
            produto.setValidade(new Date());

            System.out.println(new ProdutoService().salvarProduto(produto));
        } catch (ProdutoException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
