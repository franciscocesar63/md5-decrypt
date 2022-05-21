/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cesarfilho.md5decrypt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Cesinha
 */
@Entity
public class Decrypt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valorReal;
    private String valorCriptografado;

    public Decrypt() {
    }


    public Decrypt(Long id, String valorReal, String valorCriptografado) {
        this.id = id;
        this.valorReal = valorReal;
        this.valorCriptografado = valorCriptografado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValorReal() {
        return valorReal;
    }

    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }

    public String getValorCriptografado() {
        return valorCriptografado;
    }

    public void setValorCriptografado(String valorCriptografado) {
        this.valorCriptografado = valorCriptografado;
    }

}
