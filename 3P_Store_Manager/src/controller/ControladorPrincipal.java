/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import model.Pedido;
import model.Usuario;
import view.TelaCRUDCamiseta;
import view.TelaCRUDUsuario;
import view.TelaHistorico;
import view.TelaLogin;
import view.TelaLoja;
import view.TelaPrincipal;
import view.TelaRelatorios;

/**
 *
 * @author Richard
 */
public class ControladorPrincipal {
    
    protected ControladorCamisetas ctrCamisetas;
    protected ControladorUsuario ctrUsuarios;
    protected ControladorPedidos ctrPedidos;
    protected TelaCRUDCamiseta telaCRUDCamiseta;
    protected TelaCRUDUsuario telaCRUDUsuario;
    protected TelaLogin telaLogin;
    protected TelaPrincipal telaPrincipal;
    protected TelaLoja telaLoja;
    protected TelaHistorico telaHistorico;
    protected TelaRelatorios telaRelatorios;
    
    private Usuario usuarioLogado;
    
    public ControladorPrincipal() throws ClassNotFoundException, ParseException {
        this.ctrCamisetas = new ControladorCamisetas();
        this.ctrPedidos = new ControladorPedidos(this);
        this.ctrUsuarios = new ControladorUsuario();
        this.telaCRUDUsuario = new TelaCRUDUsuario(this);
        this.telaCRUDCamiseta = new TelaCRUDCamiseta(this);
        this.telaLogin = new TelaLogin(this);
        this.telaPrincipal = new TelaPrincipal(this);
        this.telaLoja = new TelaLoja(this);
        this.telaHistorico = new TelaHistorico(this);
        this.telaRelatorios = new TelaRelatorios(this);
        this.usuarioLogado = null;
    }
    
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public void startSistema() {
        this.telaLogin.setVisible(true);
    }
    
    public void startTelaLoja() {
        this.telaLoja.setVisible(true);
    }
    
    public void startTelaPrincipal() {
        this.telaPrincipal.setVisible(true);
    }
    
    public ControladorUsuario getCtrUsuarios() {
        return ctrUsuarios;
    }
    
    public void startTelaUsuario() {
        this.telaCRUDUsuario.setVisible(true);
    }
    
    public void startTelaCamiseta() {
        this.telaCRUDCamiseta.setVisible(true);
    }
    
    public ControladorCamisetas getCtrCamisetas() {
        return ctrCamisetas;
    }
    
    public ControladorPedidos getControladorPedidos() {
        return ctrPedidos;
    }
    
    public void startHistorico() {
        this.telaHistorico.setVisible(true);
    }
    
    public void startRelatorios() {
        this.telaRelatorios.setVisible(true);
    }
    
}
