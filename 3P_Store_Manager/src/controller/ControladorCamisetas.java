/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Camiseta;
import model.Tamanho;

/**
 *
 * @author Richard
 */
public class ControladorCamisetas {

    protected ConectaBD conexao;

    public ControladorCamisetas() throws ClassNotFoundException {
        conexao = new ConectaBD();
    }

    public List<Camiseta> listarCamisetas() {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n, precocusto, precovenda, quantidade, qm FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho";

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }

    public Camiseta pesquisarPorCodigo(int codigo) {
        Camiseta camiseta = null;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n , precocusto, precovenda, quantidade, qm, hashtag FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho where codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                camiseta.setHashTag(resultSet.getString("hashtag"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return camiseta;
    }

    public void inserir(Camiseta camiseta) {
        try {
            Connection conn = conexao.conexao();

            String sql = "INSERT INTO Camiseta "
                    + "(nome, hashtag, precocusto, precovenda, qm, quantidade, codtamanho) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, camiseta.getNome());
            statement.setString(2, camiseta.getHashTag());
            statement.setFloat(3, (float) camiseta.getPrecoCusto());
            statement.setFloat(4, (float) camiseta.getPrecoVenda());
            statement.setInt(5, camiseta.getQm());
            statement.setInt(6, camiseta.getQuantidade());
            statement.setInt(7, camiseta.getTamanho().getTamanho());

            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void excluir(int codigo) {
        try {
            Connection conn = conexao.conexao();

            String sql = "DELETE FROM Camiseta WHERE codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigo);

            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizar(Camiseta camiseta) {
        try {

            Connection conn = conexao.conexao();

            String sql = "UPDATE camiseta "
                    + "	SET  nome = ?, hashtag = ?, precocusto = ?, precovenda = ?, qm = ?, quantidade = ?, codtamanho = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, camiseta.getNome());
            preparedStatement.setString(2, camiseta.getHashTag());
            preparedStatement.setDouble(3, camiseta.getPrecoCusto());
            preparedStatement.setDouble(4, camiseta.getPrecoVenda());
            preparedStatement.setInt(5, camiseta.getQm());
            preparedStatement.setInt(6, camiseta.getQuantidade());
            preparedStatement.setInt(7, camiseta.getTamanho().getTamanho());
            preparedStatement.setInt(8, camiseta.getCodigo());

            preparedStatement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public List<Camiseta> pesquisarPorNomeTamanho(String nome, Tamanho tamanho) {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n , precocusto, precovenda, quantidade, qm, hashtag FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho where c.nome like ? and c.codtamanho = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + nome + '%');
            statement.setInt(2, tamanho.getTamanho());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                camiseta.setHashTag(resultSet.getString("hashtag"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public List<Camiseta> pesquisarPorNome(String nome) {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n , precocusto, precovenda, quantidade, qm, hashtag FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho where c.nome like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + nome + '%');

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                camiseta.setHashTag(resultSet.getString("hashtag"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public List<Camiseta> pesquisarPorTag(String tag) {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n , precocusto, precovenda, quantidade, qm, hashtag FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho where hashtag like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + tag + '%');

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                camiseta.setHashTag(resultSet.getString("hashtag"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public List<Camiseta> pesquisarPorTagTamanho(String tag, Tamanho tamanho) {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT  codigo, c.nome, t.nome as n , precocusto, precovenda, quantidade, qm, hashtag FROM Camiseta c"
                    + " join tamanho t on t.codtamanho = c.codtamanho where hashtag like ? and c.codtamanho = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + tag + '%');
            statement.setInt(2, tamanho.getTamanho());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setPrecoCusto(resultSet.getDouble("precocusto"));
                camiseta.setPrecoVenda(resultSet.getDouble("precovenda"));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                camiseta.setHashTag(resultSet.getString("hashtag"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public List<Camiseta> listarCamisetasAbaixoQM() {
        List<Camiseta> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT c.codigo, c.nome, qm, quantidade, t.nome as n FROM camiseta c "
                    + " JOIN tamanho t on t.codtamanho = c.codtamanho WHERE quantidade < qm";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Camiseta camiseta = new Camiseta();
                camiseta.setCodigo(resultSet.getInt("codigo"));
                camiseta.setNome(resultSet.getString("nome"));
                camiseta.setTamanho(Tamanho.valueOf(resultSet.getString("n")));
                camiseta.setQuantidade(resultSet.getInt("quantidade"));
                camiseta.setQm(resultSet.getInt("qm"));
                retorno.add(camiseta);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;
    }
}
