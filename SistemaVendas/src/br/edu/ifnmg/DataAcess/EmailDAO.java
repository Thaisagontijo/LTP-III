/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.Email;
import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class EmailDAO {
   private BD banco;
    
    public EmailDAO() throws SQLException{
        this.banco = new BD();
    }
    
    public boolean Salvar(Email obj, int id){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("INSERT INTO Emails (Endereco,Id_Pessoa) VALUES (?,?)");
            comando.setString(1, obj.getEndereco());
            comando.setInt(2, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Email Abrir(int id){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Emails WHERE Id_Email = ?");
            comando.setInt(1, id);
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            Email tmp = null;
            if(consulta.first()){
                tmp = new Email();
                tmp.setEndereco(consulta.getString("endereco"));
                tmp.setId(consulta.getInt("id"));
                
                
            }
            return tmp;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }
     
    
    }
    
    public boolean Apagar(Email obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Emails WHERE Id_Email = ?");
            comando.setInt(1, obj.getId());
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
                    
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    public List<Email> listarTodos(){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Emails");
            ResultSet consulta = comando.executeQuery();
            
            List<Email> listaEmails = new LinkedList<>();
            while(consulta.next()){
                Email tmp = new Email();
                
                tmp.setEndereco(consulta.getString("endereco"));
                tmp.setId(consulta.getInt("id"));
                listaEmails.add(tmp);
            }
            return listaEmails;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Emails WHERE Id_Pessoa= ?");
            comando.setInt(1, idPessoa);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    
 
}
