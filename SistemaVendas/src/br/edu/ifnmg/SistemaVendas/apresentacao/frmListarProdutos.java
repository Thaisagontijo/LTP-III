/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.apresentacao;

import br.edu.ifnmg.DataAcess.ClienteDAO;
import br.edu.ifnmg.DataAcess.ProdutoDAO;
import br.edu.ifnmg.SistemaVendas.entidade.Cliente;
import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class frmListarProdutos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmListarProdutos
     */
     
    List<Produto> lista;
    DefaultTableModel modelo;
    public frmListarProdutos() {
        initComponents();
       
        try {
            ProdutoDAO dao = new ProdutoDAO();
            
            lista = dao.listarTodos();
            
        } catch (SQLException ex) {
            Logger.getLogger(frmListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ErroValidacaoException ex){
            Logger.getLogger(frmListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            Logger.getLogger(frmListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregaCampoProduto(lista);
    }

        private void carregaCampoProduto(List<Produto> lista){
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_Produto");
        modelo.addColumn("Nome");
        modelo.addColumn("Descricao");
        modelo.addColumn("Valor_Unitario_Compra");
        modelo.addColumn("Valor_Unitario_Venda");
       
        
        for(Produto t : lista){
            Vector v = new Vector();
            v.add(0,t.getId());
            v.add(1,t.getNome());
            v.add(2,t.getDescricao());
            v.add(3,t.getValor_unitario_compra());
            v.add(4,t.getValor_unitario_venda());
           
            modelo.addRow(v);
        }
        
        tblProduto.setModel(modelo);
        tblProduto.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBusca = new javax.swing.JLabel();
        btnBusca = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Produtos Cadastrados");

        lbBusca.setText("Pesquisar Produto:");

        btnBusca.setText("Buscar");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProduto);

        btnAlterar.setText("Alterar");

        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBusca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnAlterar)
                        .addGap(38, 38, 38)
                        .addComponent(btnExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBusca)
                    .addComponent(btnBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBusca;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
