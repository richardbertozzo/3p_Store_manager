/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Richard
 */
public enum Tamanho {
    PP(1),
    P(2),
    M(3),
    G(4),
    GG(5);

    private final int tamanho;

    private Tamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }
    

}
