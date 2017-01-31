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
public enum TipoPagamento {

    DinheiroAVista(1),
    CartaoDebitoAVista(2),
    CartaoCreditoAVista(3);

    private final int tipoPagamento;

    private TipoPagamento(int tipo) {
        this.tipoPagamento = tipo;
    }

    public int getTipoPagemento() {
        return tipoPagamento;
    }

}
