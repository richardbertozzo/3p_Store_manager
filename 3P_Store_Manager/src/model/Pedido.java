/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Richard
 */
public class Pedido {

    protected int codigo;
    protected Date data;
    protected double desconto;
    protected TipoPagamento tipoPagamento;
    protected Usuario usuario;
    protected ArrayList<ItemPedido> itensPedido;
    protected Date dataCancelamento;

    public Pedido(ItemPedido item, Usuario usuario) {

        this.codigo = 1;
        this.tipoPagamento = null;
        this.desconto = 0;
        this.data = new Date();
        this.itensPedido = new ArrayList<>();
        this.usuario = usuario;
        this.itensPedido.add(item);
        this.dataCancelamento = null;

    }

    public Pedido() {
        this.codigo = 1;
        this.data = null;
        this.desconto = 0;
        this.tipoPagamento = null;
        this.usuario = null;
        this.itensPedido = null;
        this.dataCancelamento = null;
    }

    public ItemPedido retornaItem(Camiseta camiseta) {
        ItemPedido retorno = null;
        for (ItemPedido itemPedido : itensPedido) {
            if (itemPedido.getCamiseta().getCodigo() == camiseta.getCodigo()) {
                retorno = itemPedido;
            }
        }
        return retorno;
    }

    public double valorTotalPedido() {
        double retorno = 0;
        for (ItemPedido itemPedido : itensPedido) {
            retorno = retorno + itemPedido.getValorTotal();
        }
        return retorno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipoPagamento
     */
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     * @return the itensPedido
     */
    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    /**
     * @param itensPedido the itensPedido to set
     */
    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
