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
import java.util.List;
import model.Cargo;
import model.Usuario;

/**
 *
 * @author Richard
 */
public class ControladorUsuario {

    protected ConectaBD conexao;

    public ControladorUsuario() throws ClassNotFoundException {
        this.conexao = new ConectaBD();
    }

    public void excluir(int codigo) {

        try {
            Connection conn = conexao.conexao();

            String sql = "DELETE FROM Usuario WHERE codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigo);

            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> retorno = new ArrayList<>();

        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT codigo, nome, login, codcargo FROM Usuario";

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultSet.getInt("codigo"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                int cargo = resultSet.getInt("codcargo");
                if (Cargo.Dono_Da_Empresa.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Dono_Da_Empresa);
                } else if (Cargo.Gerente_Da_Loja.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Gerente_Da_Loja);
                } else if (Cargo.Vendedor.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Vendedor);
                }

                retorno.add(usuario);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return retorno;

    }

    public void inserir(Usuario usuario) {
        try {
            Connection conn = conexao.conexao();

            String sql = "INSERT INTO Usuario "
                    + "(nome, login, senha, codcargo) VALUES (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getCargo().getCargo());

            statement.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void atualizar(Usuario usuario) {
        try {

            Connection conn = conexao.conexao();

            String sql = "UPDATE usuario "
                    + "	SET  nome = ?, login = ?, senha = ?, codcargo = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setInt(4, usuario.getCargo().getCargo());
            preparedStatement.setInt(5, usuario.getCodigo());

            preparedStatement.execute();
           
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Usuario pesquisarPorCodigo(int codigo) {
        Usuario usuario = null;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT codigo, nome, login, senha, codcargo FROM Usuario where codigo = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setCodigo(resultSet.getInt("codigo"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                int cargo = resultSet.getInt("codcargo");
                if (Cargo.Dono_Da_Empresa.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Dono_Da_Empresa);
                } else if (Cargo.Gerente_Da_Loja.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Gerente_Da_Loja);
                } else if (Cargo.Vendedor.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Vendedor);
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return usuario;
    }

    public Usuario autenticar(String login, String senha) {
        Usuario usuario = null;
        try {
            Connection conn = conexao.conexao();

            String sql = "SELECT codigo, nome, login, senha, codcargo FROM Usuario"
                    + " where login = ? AND senha = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setCodigo(resultSet.getInt("codigo"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                int cargo = resultSet.getInt("codcargo");
                if (Cargo.Dono_Da_Empresa.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Dono_Da_Empresa);
                } else if (Cargo.Gerente_Da_Loja.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Gerente_Da_Loja);
                } else if (Cargo.Vendedor.getCargo() == cargo) {
                    usuario.setCargo(Cargo.Vendedor);
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return usuario;
    }

}
