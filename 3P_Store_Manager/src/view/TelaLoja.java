package view;

import controller.ControladorPrincipal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Camiseta;
import model.ItemPedido;
import model.Pedido;
import model.Tamanho;
import model.TipoPagamento;

/**
 *
 * @author Richard
 */
public class TelaLoja extends javax.swing.JFrame {

    private ControladorPrincipal ctr;
    private DefaultTableModel modeloBusca;
    private DefaultTableModel modeloPedido;
    private Pedido pedidoAtual;

    public TelaLoja(ControladorPrincipal ctr) {
        initComponents();
        this.ctr = ctr;
        this.modeloBusca = new DefaultTableModel();
        this.modeloPedido = new DefaultTableModel();

        preencherCabecarioTabelaBusca();
        preencherCabecarioTabelaPedido();
        setarComboTamanho();
        setarComboTipoPagamento();
        this.pedidoAtual = null;

        setLocationRelativeTo(null);
    }

    private void setarComboTamanho() {
        comboTamanho.setModel(new DefaultComboBoxModel<>(Tamanho.values()));
    }

    private void setarComboTipoPagamento() {
        comboTipoPagamento.setModel(new DefaultComboBoxModel<>(TipoPagamento.values()));
    }

    private void preencherCabecarioTabelaBusca() {
        modeloBusca.addColumn("Codigo");
        modeloBusca.addColumn("Produto");
        modeloBusca.addColumn("Tam");
        modeloBusca.addColumn("Qtd em estoque");
        modeloBusca.addColumn("Preço");

        tabelaBusca.setModel(modeloBusca);
    }

    private void preencherCabecarioTabelaPedido() {
        modeloPedido.addColumn("CodItem");
        modeloPedido.addColumn("CodCam");
        modeloPedido.addColumn("Produto");
        modeloPedido.addColumn("Tam");
        modeloPedido.addColumn("Qtd");
        modeloPedido.addColumn("Preço Unico");
        modeloPedido.addColumn("Preço Total");

        tabelaPedido.setModel(modeloPedido);
    }

    private void preencherTabelaBusca(List<Camiseta> lista) {

        modeloBusca.setNumRows(0);

        for (Camiseta c : lista) {
            modeloBusca.addRow(new Object[]{c.getCodigo(), c.getNome(), c.getTamanho(), c.getQuantidade(), c.getPrecoVenda()});
        }
        tabelaBusca.setModel(modeloBusca);
    }

    private void preencherTabelaPedido(List<ItemPedido> lista) {

        modeloPedido.setNumRows(0);

        for (ItemPedido c : lista) {
            modeloPedido.addRow(new Object[]{c.getCodigo(), c.getCamiseta().getCodigo(), c.getCamiseta().getNome(), c.getCamiseta().getTamanho(), c.getQuantidade(),
                c.getCamiseta().getPrecoVenda(), c.getValorTotal()});
        }
        tabelaPedido.setModel(modeloPedido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        painelPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        textoNomeCamiseta = new javax.swing.JTextField();
        textoTagCamiseta = new javax.swing.JTextField();
        comboTamanho = new javax.swing.JComboBox<>();
        botaoBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBusca = new javax.swing.JTable();
        botaoAdicionarPedido = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        pesquisarComTamanho = new javax.swing.JCheckBox();
        painelPedido = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        textoDesconto = new javax.swing.JTextField();
        botaoEfetuarDesconto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboTipoPagamento = new javax.swing.JComboBox<>();
        botaoRemoverItem = new javax.swing.JButton();
        botaoCancelarPedido = new javax.swing.JButton();
        botaoConfirmarPedido = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textoTotalPedido = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        botaoVendas = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PESQUISA");

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");

        jLabel4.setText("HashTag:");

        jLabel5.setText("Tamanho:");

        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        tabelaBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaBusca);

        botaoAdicionarPedido.setText("Adicionar ao pedido");
        botaoAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarPedidoActionPerformed(evt);
            }
        });

        pesquisarComTamanho.setText("pesquisar com tamanho");
        pesquisarComTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarComTamanhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelPesquisaLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(textoTagCamiseta))
                            .addGroup(painelPesquisaLayout.createSequentialGroup()
                                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoNomeCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelPesquisaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pesquisarComTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisaLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(botaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
            .addComponent(jSeparator2)
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoNomeCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoTagCamiseta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisarComTamanho)
                        .addGap(14, 14, 14)
                        .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(botaoBuscar))
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAdicionarPedido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
        );

        jLabel6.setText("PEDIDO");

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaPedido);

        jLabel7.setText("Desconto:");

        botaoEfetuarDesconto.setText("Efetuar Desconto");
        botaoEfetuarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEfetuarDescontoActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de Pagamento:");

        botaoRemoverItem.setText("Remover Item");
        botaoRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverItemActionPerformed(evt);
            }
        });

        botaoCancelarPedido.setText("Cancelar Pedido");
        botaoCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarPedidoActionPerformed(evt);
            }
        });

        botaoConfirmarPedido.setText("Confirmar Pedido");
        botaoConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarPedidoActionPerformed(evt);
            }
        });

        jLabel9.setText("Total do Pedido:");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoVendas.setText("Vendas");
        botaoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPedidoLayout = new javax.swing.GroupLayout(painelPedido);
        painelPedido.setLayout(painelPedidoLayout);
        painelPedidoLayout.setHorizontalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelPedidoLayout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(botaoEfetuarDesconto)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPedidoLayout.createSequentialGroup()
                                .addGap(439, 439, 439)
                                .addComponent(botaoVoltar)
                                .addGap(30, 30, 30)
                                .addComponent(botaoVendas))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoCancelarPedido)
                                .addGap(18, 18, 18)
                                .addComponent(botaoConfirmarPedido))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(botaoRemoverItem)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(comboTipoPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
            .addComponent(jSeparator1)
        );
        painelPedidoLayout.setVerticalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(botaoRemoverItem)
                        .addGap(18, 18, 18)
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelarPedido)
                            .addComponent(botaoConfirmarPedido))))
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEfetuarDesconto)
                    .addComponent(jLabel9)
                    .addComponent(textoTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoVendas)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(painelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        List<Camiseta> lista = new ArrayList<>();

        if (textoCodigo.getText().trim().length() > 0) {
            Camiseta camiseta = ctr.getCtrCamisetas().pesquisarPorCodigo(Integer.parseInt(textoCodigo.getText()));
            if (camiseta != null) {
                lista.add(camiseta);
            }
        } else if (textoNomeCamiseta.getText().trim().length() > 0) {
            if (pesquisarComTamanho.isSelected()) {
                lista = ctr.getCtrCamisetas().pesquisarPorNomeTamanho(textoNomeCamiseta.getText(), (Tamanho) comboTamanho.getSelectedItem());
            } else {
                lista = ctr.getCtrCamisetas().pesquisarPorNome(textoNomeCamiseta.getText());
            }
        } else if (textoTagCamiseta.getText().trim().length() > 0) {
            if (pesquisarComTamanho.isSelected()) {
                lista = ctr.getCtrCamisetas().pesquisarPorTagTamanho(textoTagCamiseta.getText(), (Tamanho) comboTamanho.getSelectedItem());
            } else {
                lista = ctr.getCtrCamisetas().pesquisarPorTag(textoTagCamiseta.getText());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Camiseta não encontrada");
        }
        preencherTabelaBusca(lista);
    }//GEN-LAST:event_botaoBuscarActionPerformed


    private void pesquisarComTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarComTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarComTamanhoActionPerformed

    private void botaoAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarPedidoActionPerformed
        Camiseta camiseta = ctr.getCtrCamisetas().pesquisarPorCodigo((int) tabelaBusca.getValueAt(tabelaBusca.getSelectedRow(), 0));
        if (camiseta != null) {
            if (camiseta.getQuantidade() > 0) {
                if (pedidoAtual == null) {
                    ItemPedido item = new ItemPedido(camiseta);
                    Pedido pedido = new Pedido(item, ctr.getUsuarioLogado());
                    this.pedidoAtual = pedido;
                    ctr.getControladorPedidos().inserirPedido(pedido);
                    ctr.getControladorPedidos().inserirItem(item);
                } else {
                    ItemPedido item = ctr.getControladorPedidos().retornaItem(pedidoAtual, camiseta);
                    if (item != null) {
                        ctr.getControladorPedidos().retornaItem(pedidoAtual, camiseta).aumentarQtd();
                        ctr.getControladorPedidos().atualizarItem(item);
                    } else {
                        ItemPedido itemPedido = new ItemPedido(camiseta);
                        ctr.getControladorPedidos().inserirItem(itemPedido);
                        pedidoAtual.getItensPedido().add(itemPedido);
                    }
                }
                camiseta.setQuantidade(camiseta.getQuantidade() - 1);
                ctr.getCtrCamisetas().atualizar(camiseta);

                preencherTabelaPedido(pedidoAtual.getItensPedido());

                textoTotalPedido.setText(Double.toString(ctr.getControladorPedidos().valorTotalPedido(pedidoAtual)));
            } else {
                JOptionPane.showMessageDialog(null, "Camiseta sem estoque");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Camiseta não selecionada");
        }
    }//GEN-LAST:event_botaoAdicionarPedidoActionPerformed

    private void botaoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVendasActionPerformed
        if (ctr.getUsuarioLogado().validarCargo() == 1) {
            List<Pedido> pedidos = ctr.getControladorPedidos().listaPedidosDia();
            TelaVendasDetalhadas tela = new TelaVendasDetalhadas(pedidos);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_botaoVendasActionPerformed

    private void botaoEfetuarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEfetuarDescontoActionPerformed
        if (pedidoAtual != null) {
            if (pedidoAtual.valorTotalPedido() >= Double.parseDouble(textoDesconto.getText())) {
                textoTotalPedido.setText(Double.toString(ctr.getControladorPedidos().valorTotalPedido(pedidoAtual) - Double.parseDouble(textoDesconto.getText())));
                pedidoAtual.setDesconto(Double.parseDouble(textoDesconto.getText()));
                ctr.getControladorPedidos().atualizarDesconto(pedidoAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Desconto deve ser menor ou igual que o valor do total do pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe pedido");
        }

    }//GEN-LAST:event_botaoEfetuarDescontoActionPerformed

    private void botaoCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarPedidoActionPerformed
        if (pedidoAtual != null) {
            pedidoAtual.setDataCancelamento(new Date());
            ctr.getControladorPedidos().atualizarDataCancelamento(pedidoAtual.getCodigo());
            for (int i = 0; i < pedidoAtual.getItensPedido().size(); i++) {
                Camiseta camiseta = pedidoAtual.getItensPedido().get(i).getCamiseta();
                camiseta.setQuantidade(camiseta.getQuantidade() + pedidoAtual.getItensPedido().get(i).getQuantidade());
                ctr.getCtrCamisetas().atualizar(camiseta);
            }
            pedidoAtual = null;
            modeloPedido.setNumRows(0);
            tabelaPedido.setModel(modeloPedido);
            textoTotalPedido.setText("");
            textoDesconto.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Não existe pedido");
        }
    }//GEN-LAST:event_botaoCancelarPedidoActionPerformed

    protected boolean desejaConfirmarPedido(int opcao) {
        return opcao == 0;
    }

    private void botaoConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarPedidoActionPerformed
        if (pedidoAtual != null) {
            if (pedidoAtual.getItensPedido().size() > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido");
                if (desejaConfirmarPedido(opcao)) {
                    pedidoAtual.setTipoPagamento((TipoPagamento) comboTipoPagamento.getSelectedItem());
                    ctr.getControladorPedidos().atualizarTipoPagamento(pedidoAtual);
                    pedidoAtual = null;
                    modeloPedido.setNumRows(0);
                    tabelaPedido.setModel(modeloPedido);
                    textoTotalPedido.setText("");
                    textoDesconto.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Valide o que for necessário, caso não, clique em Cancelar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não existe itens no pedido, favor adicionar camisetas ou cancelar o pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe pedido");
        }
    }//GEN-LAST:event_botaoConfirmarPedidoActionPerformed

    private void botaoRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverItemActionPerformed
        if (pedidoAtual != null) {
            if (tabelaPedido.getSelectedRowCount() == 1) {
                ItemPedido item = ctr.getControladorPedidos().retornarItemPedido((int) tabelaPedido.getValueAt(tabelaPedido.getSelectedRow(), 0));
                for (int i = 0; i < pedidoAtual.getItensPedido().size(); i++) {
                    if (pedidoAtual.getItensPedido().get(i).getCodigo() == item.getCodigo()) {
                        pedidoAtual.getItensPedido().remove(i);
                    }
                }
                Camiseta camiseta = item.getCamiseta();
                camiseta.setQuantidade(item.getCamiseta().getQuantidade() + item.getQuantidade());
                ctr.getCtrCamisetas().atualizar(camiseta);
                ctr.getControladorPedidos().removerItemPedido(item);

                preencherTabelaPedido(pedidoAtual.getItensPedido());
                textoTotalPedido.setText(Double.toString(ctr.getControladorPedidos().valorTotalPedido(pedidoAtual)));
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar item");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não existe pedido");
        }
    }//GEN-LAST:event_botaoRemoverItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarPedido;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoCancelarPedido;
    private javax.swing.JButton botaoConfirmarPedido;
    private javax.swing.JButton botaoEfetuarDesconto;
    private javax.swing.JButton botaoRemoverItem;
    private javax.swing.JButton botaoVendas;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<Tamanho> comboTamanho;
    private javax.swing.JComboBox<TipoPagamento> comboTipoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel painelPedido;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JCheckBox pesquisarComTamanho;
    private javax.swing.JTable tabelaBusca;
    private javax.swing.JTable tabelaPedido;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDesconto;
    private javax.swing.JTextField textoNomeCamiseta;
    private javax.swing.JTextField textoTagCamiseta;
    private javax.swing.JTextField textoTotalPedido;
    // End of variables declaration//GEN-END:variables
}
