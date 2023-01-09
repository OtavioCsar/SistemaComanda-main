/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.domain;

import lombok.Getter;

/**
 * @author otavi
 */
@Getter
public enum TipoUnidade {

    KG("Kg"),
    UN("Un"),
    CX("Cx");

    private String label;

    private TipoUnidade(String label) {
        this.label = label;
    }
}
