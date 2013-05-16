/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.ItemVenda;
import br.edu.ifnmg.SistemaVendas.entidade.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {
    private BD bd;


    public VendaDAO() throws SQLException {
        bd = new BD();
    }


    public boolean Salvar(Venda obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into Vendas(ValorTotal, Data, Id_Cliente, Id_Usuario_Sistema, Id_Forma_Pagamento) values(?,?,?,?)");
                comando.setDouble(1, obj.getValorTotal());
                java.sql.Date dt = new java.sql.Date(obj.getData().getTime());
                comando.setDate(2, dt); 
                comando.setInt(3, obj.getCliente().getIdCliente());
                comando.setInt(4, obj.getUsuarioSistema().getId());
                comando.setInt(5, obj.getFormadepagamento().getId());
             
                  comando.executeUpdate();
                
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update Vendas set ValorTotal = ?,Data = ?, Id_Cliente = ?, Id_Usuario_Sistema = ?, Id_Forma_Pagamento = ? where id = ?");
                comando.setDouble(1, obj.getValorTotal());
                java.sql.Date dt = new java.sql.Date(obj.getData().getTime());
                comando.setDate(2, dt);
                comando.setDouble(2, obj.getId());
                comando.executeUpdate();
                comando.setInt(3, obj.getCliente().getIdCliente());
                comando.setInt(4, obj.getUsuarioSistema().getId());
                comando.setInt(5, obj.getFormadepagamento().getId());
            }


            for (ItemVenda iv : obj.getItens()) {
                if (iv.isAtivo()) {
                    if (iv.getId() == 0) {
                        PreparedStatement comando = bd.getConexao().prepareStatement("insert into Itens_Venda(venda, produto, quantidade) values(?,?,?)");
                        comando.setInt(1, obj.getId());
                        comando.setInt(2, iv.getProduto().getId());
                        comando.setInt(3, iv.getQuantidade());
                        comando.executeUpdate();
                    } else {
                        PreparedStatement comando = bd.getConexao().prepareStatement("update Itens_Venda set produto = ?, quantidade = ? where id = ?");
                        comando.setInt(1, iv.getProduto().getId());
                        comando.setInt(2, iv.getQuantidade());
                        comando.setInt(3, obj.getId());
                        comando.executeUpdate();
                    }
                } else {
                    PreparedStatement comando = bd.getConexao().prepareStatement("delete from Itens_Venda where id = ?");
                    comando.setInt(1, obj.getId());
                    comando.executeUpdate();
                }
            }


            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public Venda Abrir(int id) throws Exception {
        try {
            Venda venda = new Venda();


            PreparedStatement comando = bd.getConexao().prepareStatement("select * from Vendas where id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();


            resultado.first();

            
            venda.setId(resultado.getInt("Id"));
            venda.setData(resultado.getDate("Data"));
            venda.setValorTotal(resultado.getDouble("ValorTotal"));
            venda.setCliente(null);
            venda.setValorTotal(resultado.getDouble("valorTotal"));

           
            carregaItens(id, venda);


            return venda;


        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public boolean Apagar(Venda obj) {
        try {
            PreparedStatement comando2 = bd.getConexao().prepareStatement("delete from Itens_Venda where Vendas = ?");
            comando2.setInt(1, obj.getId());
            comando2.executeUpdate();
            
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from vendas where id = ?");
            comando.setInt(1, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public List<Venda> listarTodos() throws Exception {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from Vendas ");
            ResultSet resultado = comando.executeQuery();
           // Cria uma lista de vendas vazia
            List<Venda> vendas = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de venda vazio
                Venda tmp = new Venda();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("id"));
                tmp.setData(resultado.getDate("data"));
                tmp.setValorTotal(resultado.getDouble("valorTotal"));
                // Pega o objeto e coloca na lista
                
                carregaItens(tmp.getId(), tmp);
                
                vendas.add(tmp);
            }
            return vendas;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public List<Venda> buscar(Venda filtro) throws Exception {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from vendas where valorTotal = ? or data = ? or id = ? ");
            comando.setDouble(1, filtro.getValorTotal());
            java.sql.Date dt = new java.sql.Date(filtro.getData().getTime());
            comando.setDate(2, dt);
            comando.setInt(3, filtro.getId());
            ResultSet resultado = comando.executeQuery();
            // Cria uma lista de vendas vazia
            List<Venda> vendas = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de venda vazio
                Venda tmp = new Venda();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("id"));
                tmp.setData(resultado.getDate("data"));
                tmp.setValorTotal(resultado.getDouble("valorTotal"));
                // Pega o objeto e coloca na lista
                
                carregaItens(tmp.getId(), tmp);
                
                vendas.add(tmp);
            }
            return vendas;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    private void carregaItens(int id, Venda venda) throws SQLException, Exception {
        PreparedStatement comando2 = bd.getConexao().prepareStatement("select * from itensvenda where venda = ?");
        comando2.setInt(1, id);
        ResultSet resultado2 = comando2.executeQuery();


        List<ItemVenda> itens = new LinkedList<>();
        ProdutoDAO prod = new ProdutoDAO();
        while (resultado2.next()) {
            ItemVenda tmp = new ItemVenda();
            tmp.setId(resultado2.getInt("id"));
            tmp.setQuantidade(resultado2.getInt("quantidade"));
            tmp.setProduto(prod.Abrir(resultado2.getInt("produto")));
            itens.add(tmp);
        }


        venda.setItens(itens);
    }

}
