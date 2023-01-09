/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.domain;

import java.util.Date;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;
/**
 *
 * @author otavi
 */

@Entity
@NoArgsConstructor

public class Cliente extends Pessoa {

    public Cliente(Long id, String nome, String cpf, String email, Date dataNascimento, String celular) {
        super(id, nome, cpf, email, dataNascimento, celular);
    }

    
    
    
}
