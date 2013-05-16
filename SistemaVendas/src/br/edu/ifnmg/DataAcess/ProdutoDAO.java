/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO {
     private BD bd;


    public ProdutoDAO() throws SQLException {
        bd = new BD();
    }


    public boolean Salvar(Produto obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into Produtos(Descricao,Nome,Valor_Unitario_Compra,Valor_Unitario_Venda,Quantidade) values(?,?,?,?,?)");
                comando.setString(1, obj.getDescricao());
                comando.setString(2, obj.getNome());
                comando.setDouble(3, obj.getValor_unitario_compra());
                comando.setDouble(4, obj.getValor_unitario_venda());
                comando.setInt(5, obj.getEstoque());
                        
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update Produtos set Descricao = ?,Nome = ?,Valor_Unitario_Compra = ?,Valor_Unitario_Venda = ?, Quantidade = ? where Id_Produto = ?");
                comando.setString(1, obj.getDescricao());
                comando.setString(2, obj.getNome());
                comando.setDouble(3, obj.getValor_unitario_compra());
                comando.setDouble(4, obj.getValor_unitario_venda());
                comando.setInt(5, obj.getEstoque());
                
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public Produto Abrir(int id)   throws Exception{
        try {
            Produto produto = new Produto();


            PreparedStatement comando = bd.getConexao().prepareStatement("select * from Produtos where Id_Produto = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();


            resultado.first();


            produto.setId(resultado.getInt("Id_Produto"));
            produto.setDescricao(resultado.getString("Descricao"));
            produto.setNome(resultado.getString("Nome"));
            produto.setValor_unitario_compra(resultado.getDouble("Valor_Unitario_Compra"));
            produto.setValor_unitario_venda(resultado.getDouble("Valor_Unitario_Venda"));
            produto.setEstoque(resultado.getInt("Quantidade"));


            return produto;


        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public boolean Apagar(Produto obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from Produtos where Id_Produtos = ?");
            comando.setInt(0, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    public List<Produto> listarTodos() throws Exception{
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from Produtos ");
            ResultSet resultado = comando.executeQuery();
            
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                
                Produto tmp = new Produto();
                tmp.setId(resultado.getInt("Id"));
                tmp.setDescricao(resultado.getString("Descricao"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setValor_unitario_compra(resultado.getDouble("Valor_Unitario_Compra"));
                tmp.setValor_unitario_venda(resultado.getDouble("Valor_Unitario_Venda"));
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public List<Produto> buscar(Produto filtro) throws Exception{
        try {
            
            String sql = "select * from Produtos ";
            String where = "";
            
            if(filtro.getDescricao().length() > 0){
                where = "descricao like '%"+filtro.getDescricao()+"%'";
            }
            if(filtro.getNome().length() > 0){
                where = "nome like '%"+filtro.getNome()+"%'";
            }
            
            if (filtro.getValor_unitario_compra() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Valor_Unitario_Compra = " + filtro.getValor_unitario_compra();
            }
            if (filtro.getValor_unitario_venda() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Valor_Unitario_Venda = " + filtro.getValor_unitario_compra();
            }
            if (filtro.getEstoque() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Quantidade = " + filtro.getEstoque();
            }
            
            if (filtro.getId() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Id_Produto = " + filtro.getId();
            }
            
            if(where.length() > 0){
                sql = sql + " where " + where;
            }
            
            Statement comando = bd.getConexao().createStatement();
            
            ResultSet resultado = comando.executeQuery(sql);
            
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                
                Produto tmp = new Produto();
                
                tmp.setId(resultado.getInt("Id_Produto"));
                tmp.setDescricao(resultado.getString("Descricao"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setValor_unitario_compra(resultado.getDouble("Valor_Unitario_Compra"));
                tmp.setValor_unitario_venda(resultado.getDouble("Valor_Unitario_Venda"));
                tmp.setEstoque(resultado.getInt("Quantidade"));
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
