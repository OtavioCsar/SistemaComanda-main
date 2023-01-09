/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.com.unincor.sistemacomanda;

import br.com.unincor.sistemacomanda.model.domain.Cliente;

/**
 *
 * @author dioge
 */
public class SistemaComanda {

    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.getNome();
        c1.setNome("Teste");
        
        System.out.println(c1.getNome());
    }
}
