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
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into produtos(descricao,nome,valor_unitario_compra,valor_unitario_venda,qtd) values(?,?,?,?,?)");
                comando.setString(1, obj.getDescricao());
                comando.setString(2, obj.getNome());
                comando.setDouble(3, obj.getValor_unitario_compra());
                comando.setDouble(4, obj.getValor_unitario_venda());
                comando.setInt(5, obj.getEstoque());
                        
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update produtos set descricao = ?,nome = ?,valor_unitario_compra = ?,valor_unitario_venda = ?, qtd = ? where id = ?");
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


            PreparedStatement comando = bd.getConexao().prepareStatement("select * from produtos where id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();


            resultado.first();


            produto.setId(resultado.getInt("id"));
            produto.setDescricao(resultado.getString("descricao"));
            produto.setNome(resultado.getString("nome"));
            produto.setValor_unitario_compra(resultado.getDouble("valor_unitario_compra"));
            produto.setValor_unitario_venda(resultado.getDouble("valor_unitario_venda"));
            produto.setEstoque(resultado.getInt("qtd"));


            return produto;


        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public boolean Apagar(Produto obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from produtos where id = ?");
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
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from produtos ");
            ResultSet resultado = comando.executeQuery();
            
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                
                Produto tmp = new Produto();
                tmp.setId(resultado.getInt("id"));
                tmp.setDescricao(resultado.getString("descricao"));
                tmp.setNome(resultado.getString("nome"));
                tmp.setValor_unitario_compra(resultado.getDouble("valor_unitario_compra"));
                tmp.setValor_unitario_venda(resultado.getDouble("valor_unitario_venda"));
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
            
            String sql = "select * from produtos ";
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
                where = where + " valor_unitario_compra = " + filtro.getValor_unitario_compra();
            }
            if (filtro.getValor_unitario_venda() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " valor_unitario_venda = " + filtro.getValor_unitario_compra();
            }
            if (filtro.getEstoque() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " qtd = " + filtro.getEstoque();
            }
            
            if (filtro.getId() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " id = " + filtro.getId();
            }
            
            if(where.length() > 0){
                sql = sql + " where " + where;
            }
            
            Statement comando = bd.getConexao().createStatement();
            
            ResultSet resultado = comando.executeQuery(sql);
            
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                
                Produto tmp = new Produto();
                
                tmp.setId(resultado.getInt("id"));
                tmp.setDescricao(resultado.getString("descricao"));
                tmp.setNome(resultado.getString("nome"));
                tmp.setValor_unitario_compra(resultado.getDouble("valor_unitario_compra"));
                tmp.setValor_unitario_venda(resultado.getDouble("valor_unitario_venda"));
                tmp.setEstoque(resultado.getInt("qtd"));
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
