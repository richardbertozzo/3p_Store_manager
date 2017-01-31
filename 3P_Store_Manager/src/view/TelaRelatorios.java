/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControladorPrincipal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.Camiseta;
import model.Relatorio1;
import model.Relatorio2;
import model.Usuario;

/**
 *
 * @author Richard
 */
public class TelaRelatorios extends javax.swing.JFrame {

    protected ControladorPrincipal ctr;
    protected DefaultTableModel modelo;
    protected MaskFormatter mskData;

    public TelaRelatorios(ControladorPrincipal ctr) {
        initComponents();
        this.ctr = ctr;
        this.modelo = new DefaultTableModel();
        preencherCombo();
        setLocationRelativeTo(null);
    }

    private void preencherCombo() {
        List<Usuario> users = ctr.getCtrUsuarios().listarUsuarios();
        for (Usuario u : users) {
            comboVendedor.addItem(u.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        try{
            mskData = new MaskFormatter("##/##/####");
            mskData.setValidCharacters("0123456789");
        }catch(ParseException e){

        }
        textoDataInicio = new javax.swing.JFormattedTextField(mskData);
        try{
            mskData = new MaskFormatter("##/##/####");
            mskData.setValidCharacters("0123456789");
        }catch(ParseException e){

        }
        textoDataFinal = new javax.swing.JFormattedTextField(mskData);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboVendedor = new javax.swing.JComboBox<>();
        botaoVoltar = new javax.swing.JButton();
        botaoEmitir = new javax.swing.JButton();
        botaoAbaixoQM = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        textoNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("Relatórios");

        jLabel2.setText("Data:");

        textoDataInicio.setColumns(6);
        textoDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDataInicioActionPerformed(evt);
            }
        });

        textoDataFinal.setColumns(6);

        jLabel3.setText("Inicio:");

        jLabel4.setText("Final:");

        jLabel5.setText("Vendedor:");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoEmitir.setText("Emitir");
        botaoEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEmitirActionPerformed(evt);
            }
        });

        botaoAbaixoQM.setText(" Produtos abaixo da quantidade minima");
        botaoAbaixoQM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAbaixoQMActionPerformed(evt);
            }
        });

        jLabel6.setText("Camiseta:");

        jLabel7.setText("Codigo:");

        jLabel8.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel2)
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(8, 8, 8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoCodigo)
                            .addComponent(textoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(botaoEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addGap(226, 226, 226)
                .addComponent(botaoAbaixoQM)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(botaoEmitir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoAbaixoQM))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDataInicioActionPerformed

    private void preencherTabelaVendedor(List<Relatorio2> lista) {
        modelo.setColumnCount(0);
        modelo.addColumn("Data");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Quantidade Vendas");

        modelo.setNumRows(0);

        for (Relatorio2 r : lista) {
            modelo.addRow(new Object[]{r.getData(), r.getVendedor(), r.getQtd()});
        }
        tabela.setModel(modelo);
    }

    private void preencherTabelaCamiseta(List<Relatorio1> lista) {
        modelo.setColumnCount(0);
        modelo.addColumn("Data");
        modelo.addColumn("Codigo Camiseta");
        modelo.addColumn("Nome Camiseta");
        modelo.addColumn("Quantidade Vendas");

        modelo.setNumRows(0);
        for (Relatorio1 r : lista) {
            modelo.addRow(new Object[]{r.getData(), r.getCodigo(), r.getNome(), r.getQtd()});
        }
        tabela.setModel(modelo);
    }


    private void botaoEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEmitirActionPerformed
        if (textoDataInicio.getText().length() > 0 && textoDataFinal.getText().length() > 0) {

            Format formater = new SimpleDateFormat("dd/MM/yyyy");
            String dataInicio = this.textoDataInicio.getText();
            String dataFinal = this.textoDataFinal.getText();
            Date dataInicioBuscar; 
            Date dataFinalBuscar;

            if (textoCodigo.getText().trim().length() > 0 || textoNome.getText().trim().length() > 0) {
                if (textoCodigo.getText().trim().length() > 0) { //busca por codigo camiseta
                    try {
                        dataInicioBuscar = (Date) formater.parseObject(dataInicio);
                        dataFinalBuscar = (Date) formater.parseObject(dataFinal);
                        List<Relatorio1> pedidos = ctr.getControladorPedidos().listarPedidoCamisetaCodigo(dataInicioBuscar, dataFinalBuscar, Integer.parseInt(textoCodigo.getText()));
                        preencherTabelaCamiseta(pedidos);
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {//busca por nome camiseta
                    try {
                        dataInicioBuscar = (Date) formater.parseObject(dataInicio);
                        dataFinalBuscar = (Date) formater.parseObject(dataFinal);
                        List<Relatorio1> pedidos = ctr.getControladorPedidos().listarPedidoCamisetaNome(dataInicioBuscar, dataFinalBuscar, textoNome.getText());
                        preencherTabelaCamiseta(pedidos);
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else { //busca por vendedor
                try {
                    dataInicioBuscar = (Date) formater.parseObject(dataInicio);
                    dataFinalBuscar = (Date) formater.parseObject(dataFinal);
                    List<Relatorio2> pedidos = ctr.getControladorPedidos().listarPedidoVendedor(dataInicioBuscar, dataFinalBuscar, comboVendedor.getSelectedItem().toString());
                    preencherTabelaVendedor(pedidos);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencher campos");
        }
    }//GEN-LAST:event_botaoEmitirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoAbaixoQMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAbaixoQMActionPerformed
        modelo.setColumnCount(0);
        modelo.addColumn("Cod Camiseta");
        modelo.addColumn("Nome Camiseta");
        modelo.addColumn("Tamanho");
        modelo.addColumn("Quantidade");
        modelo.addColumn("QM");

        modelo.setNumRows(0);
        List<Camiseta> camisetas = ctr.getCtrCamisetas().listarCamisetasAbaixoQM();
        for (Camiseta c : camisetas) {
            modelo.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getTamanho(), c.getQuantidade(), c.getQm()});
        }
        tabela.setModel(modelo);
    }//GEN-LAST:event_botaoAbaixoQMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAbaixoQM;
    private javax.swing.JButton botaoEmitir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JFormattedTextField textoDataFinal;
    private javax.swing.JFormattedTextField textoDataInicio;
    private javax.swing.JTextField textoNome;
    // End of variables declaration//GEN-END:variables
}
