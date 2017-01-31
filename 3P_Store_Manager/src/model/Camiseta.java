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
public class Camiseta {

    protected int codigo;
    protected String hashTag;
    protected String nome;

    protected double precoCusto;
    protected double precoVenda;
    protected int qm;
    protected int quantidade;
    protected Tamanho tamanho;

    public Camiseta(String nome, String hashTag, double precoCusto, double precoVenda, int qm, int quantidade, Tamanho tamanho) {
        this.codigo = 1;
        this.nome = nome;
        this.hashTag = hashTag;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.qm = qm;
        this.quantidade = quantidade;
        this.tamanho = tamanho;

    }

    public Camiseta() {
        this.codigo = 0;
        this.nome = "";
        this.hashTag = "";
        this.precoCusto = 0;
        this.precoVenda = 0;
        this.qm = 0;
        this.quantidade = 0;
        this.tamanho = null;
    }

    /**
     * @return the precoCusto
     */
    public double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * @return the precoVenda
     */
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the qm
     */
    public int getQm() {
        return qm;
    }

    /**
     * @param qm the qm to set
     */
    public void setQm(int qm) {
        this.qm = qm;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the tamanho
     */
    public Tamanho getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the hashTag
     */
    public String getHashTag() {
        return hashTag;
    }

    /**
     * @param hashTag the hashTag to set
     */
    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

}
