/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.FormadePagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FormasPagamentoDAO {
   private BD banco;
    
    public FormasPagamentoDAO() throws SQLException{
        banco = new BD();
    
    }
    
    
    public boolean Salvar(FormadePagamento obj){
        PreparedStatement comando;
        try{
            if(obj.getId() == 0){
                comando = banco.getConexao()
                        .prepareStatement("INSERT INTO Formas_Pagamento (Nome) VALUES (?)");
                comando.setString(1, obj.getNome());


                comando.executeUpdate();
                comando.getConnection().commit();
            }else if (obj.isAlterado()){
                comando = banco.getConexao()
                        .prepareStatement("UPDATE Formas_Pagamento SET Nome = ? WHERE Id_Forma_Pagamento = ?");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getId());


                comando.executeUpdate();
                comando.getConnection().commit();
                        
            }
            return true;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
            
        }
            
    
    }
    
    
    public FormadePagamento Abrir(int id){
        try{
            FormadePagamento fp = new FormadePagamento();
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Formas_pagamento WHERE Id_Forma_Pagamento = ?");
            comando.setInt(1, id);
            
            ResultSet rs = comando.executeQuery();
            //comando.getConnection().commit();//verificar
            rs.first();
             
             fp.setId(id);
             fp.setNome(rs.getString("nome"));
            return fp;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    public boolean Apagar(FormadePagamento obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Forma_Pagamento WHERE Id_Forma_Pagamento = ?");
            comando.setInt(1, obj.getId());
            if(comando.executeUpdate() == 1) {
                comando.getConnection().commit();
                return true;
            }
            else {
                comando.getConnection().rollback();
                return false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public List<FormadePagamento> ListarTodos(){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Forma_Pagamento");
           ResultSet rs = comando.executeQuery();
           
           List<FormadePagamento> formasPagamento = new LinkedList<>();
           
           while(rs.next()){
               FormadePagamento temp = new FormadePagamento();
               temp.setId(rs.getInt("Id_Forma_Pagamento"));
               temp.setNome(rs.getString("Nome"));
               
               formasPagamento.add(temp);
           
           }
           return formasPagamento;
           
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
 
}
