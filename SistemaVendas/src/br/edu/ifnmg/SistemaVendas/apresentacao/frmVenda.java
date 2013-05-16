/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.apresentacao;

import javax.swing.JOptionPane;


public class frmVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVenda
     */
    public frmVenda() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lbValor = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        TpDados = new javax.swing.JTabbedPane();
        PanelDadosGerais = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        Cbusuario = new javax.swing.JComboBox();
        lbData = new javax.swing.JLabel();
        PanelItensVenda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnAdiciona = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnFecharVenda = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Vendas");

        lbValor.setText("Valor Total:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbUsuario.setText("Usuario: ");

        lbCliente.setText("Cliente:");

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Cliente", "Item 2", "Item 3", "Item 4" }));
        cbCliente.setToolTipText("Selecione o Cliente");

        Cbusuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Usuário", "Item 2", "Item 3", "Item 4" }));

        lbData.setText("jLabel2");

        javax.swing.GroupLayout PanelDadosGeraisLayout = new javax.swing.GroupLayout(PanelDadosGerais);
        PanelDadosGerais.setLayout(PanelDadosGeraisLayout);
        PanelDadosGeraisLayout.setHorizontalGroup(
            PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosGeraisLayout.createSequentialGroup()
                .addGroup(PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDadosGeraisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsuario)
                            .addComponent(lbCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDadosGeraisLayout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(lbData)))
                .addContainerGap(397, Short.MAX_VALUE))
        );
        PanelDadosGeraisLayout.setVerticalGroup(
            PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosGeraisLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbData)
                .addGap(30, 30, 30)
                .addGroup(PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuario))
                .addGap(28, 28, 28)
                .addGroup(PanelDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliente))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        TpDados.addTab("Dados Gerais", PanelDadosGerais);

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome Produto", "Valor Unitário"
            }
        ));
        jScrollPane1.setViewportView(tblProduto);
        tblProduto.getColumnModel().getColumn(1).setResizable(false);

        btnAdiciona.setText("Adicionar Produto");
        btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaActionPerformed(evt);
            }
        });

        btnRemove.setText("Remover Produto");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelItensVendaLayout = new javax.swing.GroupLayout(PanelItensVenda);
        PanelItensVenda.setLayout(PanelItensVendaLayout);
        PanelItensVendaLayout.setHorizontalGroup(
            PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItensVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdiciona, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(110, 110, 110))
        );
        PanelItensVendaLayout.setVerticalGroup(
            PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItensVendaLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelItensVendaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnAdiciona)
                        .addGap(26, 26, 26)
                        .addComponent(btnRemove)))
                .addGap(117, 117, 117))
        );

        TpDados.addTab("Itens da Venda", PanelItensVenda);

        btnFecharVenda.setText("Concluir Venda");
        btnFecharVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TpDados))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnFecharVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TpDados, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbValor))
                    .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnFecharVenda))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed
        
    }//GEN-LAST:event_btnAdicionaActionPerformed

    private void btnFecharVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharVendaActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Salvar?","Deseja Salvar?", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == confirmar){
            
            if(txtCliente.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Nome deve ser preenchido");
        }
               if(txtUsuario.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Usuário deve ser preenchido");
        }
                        
        else {
          
                 JOptionPane.showMessageDialog(this,"Dados gravados com sucesso");
                 
                 
        }
        }
    }//GEN-LAST:event_btnFecharVendaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Cancelar?","Deseja Cancelar?", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == confirmar){
        
        this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Cbusuario;
    private javax.swing.JPanel PanelDadosGerais;
    private javax.swing.JPanel PanelItensVenda;
    private javax.swing.JTabbedPane TpDados;
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFecharVenda;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbValor;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables
}
