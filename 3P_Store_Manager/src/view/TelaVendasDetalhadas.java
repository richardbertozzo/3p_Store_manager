/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Pedido;

/**
 *
 * @author Richard
 */
public class TelaVendasDetalhadas extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private List<Pedido> listaPedido;

    public TelaVendasDetalhadas(List lista) {
        initComponents();
        modelo = new DefaultTableModel();
        preencherCabecarioTabela();
        this.listaPedido = lista;
        setLocationRelativeTo(null);
        preencherTabela();
    }

    private void preencherCabecarioTabela() {
        modelo.addColumn("Numero do pedido");
        modelo.addColumn("Data");
        modelo.addColumn("Usuario");
        modelo.addColumn("Codigo do Produto");
        modelo.addColumn("Nome do produto");
        modelo.addColumn("Qtd");
        modelo.addColumn("Preço");

        tabela.setModel(modelo);
    }

    private void preencherTabela() {
        modelo.setNumRows(0);

        for (Pedido p : listaPedido) {
            int tamanho = p.getItensPedido().size();

            for (int i = 0; i < tamanho; i++) {
                if (i == 0) {
                    modelo.addRow(new Object[]{p.getCodigo(), p.getData(), p.getUsuario().getNome(), p.getItensPedido().get(i).getCamiseta().getCodigo(),
                        p.getItensPedido().get(i).getCamiseta().getNome(), p.getItensPedido().get(i).getQuantidade(), p.getItensPedido().get(i).getValorTotal()});
                } else if (i > 0) {
                    modelo.addRow(new Object[]{"", "", "", p.getItensPedido().get(i).getCamiseta().getCodigo(), p.getItensPedido().get(i).getCamiseta().getNome(),
                        p.getItensPedido().get(i).getQuantidade(), p.getItensPedido().get(i).getValorTotal()});

                }
            }
        }
        tabela.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();

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

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}