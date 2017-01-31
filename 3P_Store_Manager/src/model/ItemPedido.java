package model;

/**
 *
 * @author Richard
 */
public class ItemPedido {

    protected int codigo; 
    protected Camiseta camiseta;
    protected int quantidade;
    protected double valorTotal;

    public ItemPedido(Camiseta camiseta) {
        this.codigo = 1;
        this.camiseta = camiseta;
        this.quantidade = 1;
        this.valorTotal = camiseta.getPrecoVenda();
    }

    public ItemPedido() {
        
        
    }

    public void aumentarQtd() {
        this.quantidade = quantidade + 1;
        this.valorTotal = valorTotal + valorTotal;
    }

    /**
     * @return the camiseta
     */
    public Camiseta getCamiseta() {
        return camiseta;
    }

    /**
     * @param camiseta the camiseta to set
     */
    public void setCamiseta(Camiseta camiseta) {
        this.camiseta = camiseta;
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
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
