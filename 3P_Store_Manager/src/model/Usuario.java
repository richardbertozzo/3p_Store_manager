/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Usuario {

    protected int codigo;
    protected String nome;
    protected String login;
    protected String senha;
    protected Cargo cargo;

    public Usuario(String nome, String login, String senha, Cargo cargo) {
        this.codigo = 1;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuario() {
        this.codigo = 0;
        this.nome = "";
        this.login = "";
        this.senha = "";
        this.cargo = null;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int validarCargo() {
        if (this.cargo.equals(Cargo.Dono_Da_Empresa)) {
            return 1;
        } else if (this.cargo.equals(Cargo.Gerente_Da_Loja)) {
            return 2;
        } else {
            return 3;
        }

    }
}
