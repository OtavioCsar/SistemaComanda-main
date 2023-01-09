package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author otavi
 */
@Table(name = "Pedidos")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity

public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany
    @JoinTable(name = "pedido_produtos",
            joinColumns = {
                    @JoinColumn(name = "pedido_id"),},
            inverseJoinColumns = {
                    @JoinColumn(name = "produto_id")
            })

    private List<Produto> produtos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "valor_itens")
    private Double valorItens;
    private Double desconto;

    @Column(name = "valor_entrega")
    private Double valorEntrega;

    @Column(name = "valor_total")
    private Double valorTotal;

    public void calcularValorTotalItens() {
        /*this.valorItens = 0.0;
        for(Produto produto : produtos){
            this.valorItens += produto.getPreco();
        }*/
        this.valorItens = produtos.stream().map(Produto::getPreco).reduce(0., Double::sum);
    }

    public void calcularValorTotal() {

        this.valorTotal = getValorItens() + getValorEntrega() - getDesconto();


    }

}
