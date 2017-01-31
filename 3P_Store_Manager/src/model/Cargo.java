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
public enum Cargo {

    Dono_Da_Empresa(1),
    Gerente_Da_Loja(2),
    Vendedor(3);

    private final int cargo;

    private Cargo(int cargo) {
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

}
