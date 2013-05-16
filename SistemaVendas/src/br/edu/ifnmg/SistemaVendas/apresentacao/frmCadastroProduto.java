/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.apresentacao;

import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Produto;
import javax.swing.JOptionPane;


public class frmCadastroProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCadastroProduto
     */
    public frmCadastroProduto() {
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

        lbNome = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbValorCompra = new javax.swing.JLabel();
        lbValorVenda = new javax.swing.JLabel();
        lbQtd = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtValor_Compra = new javax.swing.JTextField();
        txtValor_Venda = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Produtos");

        lbNome.setText("Nome:");

        lbDescricao.setText("Descrição:");

        lbValorCompra.setText("Preço de Compra:");

        lbValorVenda.setText("Preço de Venda:");

        lbQtd.setText("Quantidade:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescricao)
                            .addComponent(lbNome))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtDescricao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbValorCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbQtd)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtQtd))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbValorVenda)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtValor_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorCompra)
                    .addComponent(txtValor_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorVenda)
                    .addComponent(txtValor_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQtd)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Salvar?","Deseja Salvar?", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == confirmar){
            
            if(txtDescricao.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Descrição deve ser preenchido");
        }
            if(txtNome.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Nome deve ser preenchido");
        }
            if(txtQtd.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Quantidade deve ser preenchido");
        }
            if(txtValor_Compra.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Valor Compra deve ser preenchido");
        }
            if(txtValor_Venda.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "O campo Valor Venda deve ser preenchido");
        }
            else {
                Produto produto = new Produto();
                produto.setDescricao(txtDescricao.getText());
                
                try{
                    produto.setNome(txtNome.getText());
                    produto.setValor_unitario_compra(Double.parseDouble(txtValor_Compra.getText()));
                    produto.setValor_unitario_venda(Double.parseDouble(txtValor_Venda.getText()));
                    produto.setEstoque(Integer.parseInt(txtQtd.getText()));
                }catch(ErroValidacaoException ex){
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }catch( Exception ex){
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
                
                JOptionPane.showMessageDialog(this,"Dados gravados com sucesso");
                 
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Cancelar?","Deseja Cancelar?", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == confirmar){
        
        this.dispose();
        }     
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JLabel lbValorCompra;
    private javax.swing.JLabel lbValorVenda;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtValor_Compra;
    private javax.swing.JTextField txtValor_Venda;
    // End of variables declaration//GEN-END:variables
}
