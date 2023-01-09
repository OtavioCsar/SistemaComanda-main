/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.sistemacomanda.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author otavi
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public abstract class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    
    @Column(nullable=false)
    protected String nome;
    protected String cpf;
    protected String email;
    
    @Column (name="data_nascimento")
    @Temporal(TemporalType.DATE)
    protected Date dataNascimento;

    protected String celular;

    public Pessoa(Long id, String nome, String cpf, String email, Date dataNascimento, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.celular = celular;
    }

    
    
    
}
