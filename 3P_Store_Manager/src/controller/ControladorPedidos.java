/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Camiseta;
import model.ItemPedido;
import model.Pedido;
import model.Relatorio1;
import model.Relatorio2;

/**
 *
 * @author Richard
 */
public class ControladorPedidos {

    protected ConectaBD conexao;
    protected ControladorPrincipal ctr;

    public ControladorPedidos(ControladorPrincipal ctr) throws ClassNotFoundException {
        this.conexao = new ConectaBD();
        this.ctr = ctr;
    }

    public List<Pedido> listarPedidoData(Date dataBuscar) {
        List<Pedido> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT p.codigo as codigo, data, datacancelamento, usuario FROM pedido p"
                    + " JOIN itempedido i ON i.pedido = p.codigo"
                    + " WHERE data = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(dataBuscar.getTime());
            statement.setDate(1, sqlDate);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<ItemPedido> itens = new ArrayList<>();

            while (resultSet.next()) {
                int codigoPedido = resultSet.getInt("codigo");
                itens = retornarItemPedidoPorPedido(codigoPedido);

                Pedido pedido = new Pedido();
                pedido.setCodigo(codigoPedido);
                pedido.setItensPedido(itens);
                pedido.setData(resultSet.getDate("data"));
                pedido.setDataCancelamento(resultSet.getDate("datacancelamento"));
                pedido.setUsuario(ctr.getCtrUsuarios().pesquisarPorCodigo(resultSet.getInt("usuario")));

                retorno.add(pedido);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

    public List<Pedido> listaPedidosDia() {

        List<Pedido> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT DISTINCT p.codigo as codigo, data, datacancelamento, usuario FROM pedido p"
                    + " JOIN itempedido i ON i.pedido = p.codigo"
                    + " WHERE data = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
            statement.setDate(1, sqlDate);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<ItemPedido> itens = new ArrayList<>();

            while (resultSet.next()) {
                int codigoPedido = resultSet.getInt("codigo");
                itens = retornarItemPedidoPorPedido(codigoPedido);

                Pedido pedido = new Pedido();
                pedido.setCodigo(codigoPedido);
                pedido.setItensPedido(itens);
                pedido.setData(resultSet.getDate("data"));
                pedido.setDataCancelamento(resultSet.getDate("datacancelamento"));
                pedido.setUsuario(ctr.getCtrUsuarios().pesquisarPorCodigo(resultSet.getInt("usuario")));

                retorno.add(pedido);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public ItemPedido retornaItem(Pedido pedido, Camiseta camisa) {
        return pedido.retornaItem(camisa);
    }

    public double valorTotalPedido(Pedido pedido) {
        return pedido.valorTotalPedido();
    }

    public void inserirItem(ItemPedido item) {
        try {
            Connection conn = conexao.conexao();

            String sqlItem = "INSERT INTO itempedido(camiseta, quantidade, valorTotal, pedido) "
                    + "	VALUES (?, ?, ?, ?)";
            PreparedStatement statementItem = conn.prepareStatement(sqlItem);
            statementItem.setInt(1, item.getCamiseta().getCodigo());
            statementItem.setInt(2, item.getQuantidade());
            statementItem.setDouble(3, item.getValorTotal());
            statementItem.setInt(4, retornaCodigoPedido());

            statementItem.execute();

            item.setCodigo(retornaCodigoItem());

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inserirPedido(Pedido pedidoAtual) {

        try {
            Connection conn = conexao.conexao();

            String sql = "INSERT INTO pedido(data, desconto, usuario) "
                    + "	VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(pedidoAtual.getData().getTime());
            statement.setDate(1, sqlDate);
            statement.setDouble(2, pedidoAtual.getDesconto());
            statement.setInt(3, pedidoAtual.getUsuario().getCodigo());

            statement.execute();

            pedidoAtual.setCodigo(retornaCodigoPedido());

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public int retornaCodigoPedido() {
        int retorno = 0;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT max(codigo) FROM Pedido";

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                retorno = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public int retornaCodigoItem() {
        int retorno = 0;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT max(codigo) FROM itempedido";

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                retorno = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;

    }

    public void removerItemPedido(ItemPedido item) {
        try {
            Connection conn = conexao.conexao();

            String sql = "DELETE FROM itempedido WHERE codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, item.getCodigo());

            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizarItem(ItemPedido item) {
        try {
            Connection conn = conexao.conexao();

            String sql = "UPDATE itempedido SET quantidade=?, valortotal=? "
                    + "	WHERE codigo=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, item.getQuantidade());
            preparedStatement.setDouble(2, item.getValorTotal());
            preparedStatement.setInt(3, item.getCodigo());

            preparedStatement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizarDesconto(Pedido pedidoAtual) {
        try {
            Connection conn = conexao.conexao();

            String sql = "UPDATE pedido SET desconto=? "
                    + "	WHERE codigo=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, pedidoAtual.getDesconto());
            preparedStatement.setInt(2, pedidoAtual.getCodigo());

            preparedStatement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizarTipoPagamento(Pedido pedidoAtual) {
        try {
            Connection conn = conexao.conexao();

            String sql = "UPDATE pedido SET tipopagamento=? "
                    + "	WHERE codigo=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, pedidoAtual.getTipoPagamento().getTipoPagemento());
            preparedStatement.setInt(2, pedidoAtual.getCodigo());

            preparedStatement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizarDataCancelamento(int i) {
        try {
            Connection conn = conexao.conexao();

            String sql = "UPDATE pedido SET datacancelamento=? "
                    + "	WHERE codigo=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, i);

            preparedStatement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ItemPedido retornarItemPedido(int i) {
        ItemPedido item = null;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT codigo, camiseta, quantidade, valortotal FROM itempedido"
                    + " WHERE codigo=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                item = new ItemPedido(ctr.getCtrCamisetas().pesquisarPorCodigo(resultSet.getInt("camiseta")));
                item.setCodigo(resultSet.getInt("codigo"));
                item.setQuantidade(resultSet.getInt("quantidade"));
                item.setValorTotal(resultSet.getDouble("valortotal"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return item;
    }

    public ArrayList<ItemPedido> retornarItemPedidoPorPedido(int i) {
        ArrayList<ItemPedido> retorno = new ArrayList<>();
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT codigo , camiseta, quantidade, valortotal FROM itempedido"
                    + " WHERE pedido=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ItemPedido item = new ItemPedido();
                item.setCodigo(resultSet.getInt("codigo"));
                item.setQuantidade(resultSet.getInt("quantidade"));
                item.setValorTotal(resultSet.getDouble("valortotal"));
                item.setCamiseta(ctr.getCtrCamisetas().pesquisarPorCodigo(resultSet.getInt("camiseta")));
                retorno.add(item);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

    public List<Relatorio2> listarPedidoVendedor(Date dataInicioBuscar, Date dataFinalBuscar, String usuario) {
        List<Relatorio2> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "select data, nome, count(p.codigo) as qtd from pedido p"
                    + " join usuario u on u.codigo = p.usuario"
                    + " WHERE datacancelamento isnull AND data between ? AND ? AND u.nome = ?"
                    + " group by data, u.nome";

            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(dataInicioBuscar.getTime());
            statement.setDate(1, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(dataFinalBuscar.getTime());
            statement.setDate(2, sqlDate2);
            statement.setString(3, usuario);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Relatorio2 relatorio = new Relatorio2();
                relatorio.setData(resultSet.getDate("data"));
                relatorio.setVendedor(resultSet.getString("nome"));
                relatorio.setQtd(resultSet.getInt("qtd"));
                retorno.add(relatorio);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

    public List<Relatorio1> listarPedidoCamisetaCodigo(Date dataInicioBuscar, Date dataFinalBuscar, int codigo) {
        List<Relatorio1> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "select data, camiseta, c.nome as nome, sum(i.quantidade) as qtd from itempedido i"
                    + " join pedido p on p.codigo = i.pedido"
                    + " join camiseta c on c.codigo = i.camiseta"
                    + " WHERE datacancelamento isnull AND data between ? AND ? AND i.camiseta = ?"
                    + " group by data, camiseta, c.nome";

            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(dataInicioBuscar.getTime());
            statement.setDate(1, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(dataFinalBuscar.getTime());
            statement.setDate(2, sqlDate2);
            statement.setInt(3, codigo);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Relatorio1 relatorio = new Relatorio1();
                relatorio.setData(resultSet.getDate("data"));
                relatorio.setCodigo(resultSet.getInt("camiseta"));
                relatorio.setNome(resultSet.getString("nome"));
                relatorio.setQtd(resultSet.getInt("qtd"));
                retorno.add(relatorio);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

    public List<Relatorio1> listarPedidoCamisetaNome(Date dataInicioBuscar, Date dataFinalBuscar, String nomeCamiseta) {
        List<Relatorio1> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "select data, camiseta, c.nome as nome, sum(i.quantidade) as qtd from itempedido i"
                    + " join pedido p on p.codigo = i.pedido"
                    + " join camiseta c on c.codigo = i.camiseta"
                    + " WHERE datacancelamento isnull AND data between ? AND ? AND c.nome = ?"
                    + " group by data, camiseta, c.nome";

            PreparedStatement statement = conn.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(dataInicioBuscar.getTime());
            statement.setDate(1, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(dataFinalBuscar.getTime());
            statement.setDate(2, sqlDate2);
            statement.setString(3, nomeCamiseta);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Relatorio1 relatorio = new Relatorio1();
                relatorio.setData(resultSet.getDate("data"));
                relatorio.setCodigo(resultSet.getInt("camiseta"));
                relatorio.setNome(resultSet.getString("nome"));
                relatorio.setQtd(resultSet.getInt("qtd"));
                retorno.add(relatorio);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

}
