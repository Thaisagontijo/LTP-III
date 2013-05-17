/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class EnderecoDAO {
    private BD banco;
    
    public EnderecoDAO () throws SQLException{
        banco = new BD();
    }
    
    public boolean Salvar(Endereco obj,int idPessoa){
        try{
            if(obj.getId() == 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("INSERT INTO Enderecos (Rua,Cep,Bairro,Numero,Id_Pessoa,Cidade,Estado,Complemento) "
                        + "VALUES(?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getRua());
                comando.setInt(2, obj.getCep());
                comando.setString(3, obj.getBairro());
                comando.setString(4, String.valueOf(obj.getNumero()));
                comando.setInt(5, idPessoa);
                comando.setString(6, obj.getCidade());
                comando.setString(7, obj.getEstado());
                comando.setString(8, obj.getComplemento());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            }
            
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
  
    
    }
    
    public boolean Apagar(Endereco obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Enderecos WHERE id= ?");
            comando.setInt(1, obj.getId());
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public List<Endereco> listarTodos(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Enderecos");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<Endereco> listaEnderecos = new LinkedList<>();
            
            while(consulta.next()){
                Endereco tmp = new Endereco();
                
                tmp.setBairro(consulta.getString("Bairro"));
                tmp.setCep(consulta.getInt("CPF"));
                tmp.setCidade(consulta.getString("Cidade"));
                tmp.setEstado(consulta.getString("Estado"));
                tmp.setId(consulta.getInt("Id_Endereco"));
                tmp.setNumero(Integer.parseInt(consulta.getString("Numero")));
                tmp.setRua(consulta.getString("rua"));
                tmp.setComplemento(consulta.getString("Complemento"));
                listaEnderecos.add(tmp);
            
            }
            
            return listaEnderecos;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Enderecos WHERE Id_Pessoa= ?");
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

