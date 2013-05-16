/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class TelefoneDAO {
   private BD banco;
    
    public TelefoneDAO() throws SQLException{
        banco = new BD();
    }
    
    public boolean Salvar(Telefone obj, int idPessoa){
        try{
                if(obj.getId() == 0 ){
                PreparedStatement comando = banco
                        .getConexao().prepareStatement("INSERT INTO Telefones (DDD,Numero,Id_Pessoa) VALUES(?,?,?)");


                comando.setInt(1, obj.getDdd());
                comando.setInt(2, obj.getNumero());
                comando.setInt(3, idPessoa);


                comando.executeUpdate();
                comando.getConnection().commit();
                
            }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public Telefone Abrir(int id) {
        Telefone tmp = null;
        try{
            if(id != 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("SELECT * FROM Telefones WHERE Id_Telefone = ?");
                comando.setInt(1, id);
                ResultSet consulta = comando.executeQuery();
                comando.getConnection().commit();
                
                
                if(consulta.first()){
                    tmp = new Telefone();
                    tmp.setDdd(consulta.getInt("DDD"));
                    
                    tmp.setId(consulta.getInt("Id_Telefone"));
                    
                    tmp.setNumero(consulta.getInt("Numero"));
                    
                }


            }
            return tmp;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return null;
        }
        
    
    
    }
    
    
    public boolean Apagar(Telefone obj){
        try{
            PreparedStatement comando = banco
                    .getConexao().prepareStatement("DELETE FROM Telefones WHERE Id_Telefone = ?");
            comando.setInt(1, obj.getId());
            comando.executeUpdate();
            comando.getConnection().commit();
                    
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public List<Telefone> listarTodos(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Telefones");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<Telefone> listaTelefones = new LinkedList<>();
            
            while(consulta.next()){
                Telefone tmp = new Telefone();
                tmp.setDdd(consulta.getInt("DDD"));
                tmp.setId(consulta.getInt("Id_Telefone"));
                tmp.setNumero(consulta.getInt("Numero"));
                listaTelefones.add(tmp);
            }
            return listaTelefones;
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
    
    }
    }
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Telefones WHERE Id_Pessoa= ?");
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
