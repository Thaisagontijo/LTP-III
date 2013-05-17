/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.Cliente;
import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
    private BD bd;


    public ClienteDAO() throws SQLException {
        this.bd = new BD();
    
   }
    
   public boolean Salvar(Cliente obj)throws ErroValidacaoException, Exception{
       try{
           if(obj.getIdCliente() == 0){
               
               PessoaDAO dao = new PessoaDAO();
               Pessoa tmp = new Pessoa();
               
               tmp.setCpf(obj.getCpf());
               tmp.setDataNascimento(obj.getDataNascimento());
               tmp.setEmails(obj.getEmails());
               tmp.setEnderecos(obj.getEnderecos());
               tmp.setNome(obj.getNome());
               tmp.setRg(obj.getRg());
               tmp.setTelefones(obj.getTelefones());
               
               int idPessoa = dao.Salvar(tmp);
               
               PreparedStatement comando = bd.getConexao()
                       .prepareStatement("INSERT INTO Clientes (Id_Pessoa) VALUES(?)");
               comando.setInt(1, idPessoa);
               
               comando.executeUpdate();
               comando.getConnection().commit();
               
           
           }
       
           return true;
           
       }catch(SQLException ex){
           
           JOptionPane.showMessageDialog(null,ex);
           
           return false;
       }
   
   
   
   }
   
   public Cliente Abrir(int id) throws ErroValidacaoException, Exception{
       try{
           PreparedStatement comando = bd
                   .getConexao().prepareStatement("SELECT c.id as Id_Cliente, p.id as "
                   + "Id_Pessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM Pessoa p INNER "
                   + "JOIN Clientes c on c.Id_Pessoa = p.id WHERE c.id = ?");
           comando.setInt(1, id);
           
           ResultSet consulta = comando.executeQuery();
           comando.getConnection().commit();
           Cliente tmp = null;
           if(consulta.first()){
               tmp = new Cliente();
               tmp.setCpf(consulta.getInt("CPF"));
                tmp.setDataNascimento(consulta.getDate("Data_Nascimento"));
                tmp.setNome(consulta.getString("Nome"));
                tmp.setIdPessoa(consulta.getInt("Id_Pessoa"));
                tmp.setRg(consulta.getString("RG"));
                tmp.setIdCliente(consulta.getInt("Id_Cliente"));
               
           }
            return tmp;
       }catch(SQLException ex){
           ex.printStackTrace();
           return null;
       }
   
   }
   
   
   public boolean Apagar(int id ){
       try{
           
           
          // PessoaDAO pessoaDAO = new PessoaDAO();
           //pessoaDAO.Apagar(id);
           
           PreparedStatement comando = bd
                   .getConexao().prepareStatement("DELETE FROM Clientes WHERE Id_Cliente = ?");
           comando.setInt(1, id);
           comando.execute();
           comando.getConnection().commit();
           
           
           
           return true;
           
           
       
       }catch(SQLException ex){
           ex.printStackTrace();
           return false;
       }
   
   }
   
   
   public List<Cliente> listarTodos()throws ErroValidacaoException, Exception{
       try{
           PreparedStatement comando = bd
                   .getConexao().prepareStatement("SELECT c.id as Id_Cliente, p.id as "
                   + "Id_Pessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM Pessoa p INNER "
                   + "JOIN Clientes c on c.Id_Pessoa = p.id");
           
           ResultSet consulta = comando.executeQuery();
           comando.getConnection().commit();
           
           List<Cliente> lista = new LinkedList<>();
           
           while(consulta.next()){
               Cliente tmp = new Cliente();
               
               tmp.setCpf(consulta.getInt("CPF"));
                tmp.setDataNascimento(consulta.getDate("Data_Nascimento"));
                tmp.setNome(consulta.getString("Nome"));
                tmp.setIdPessoa(consulta.getInt("Id_Pessoa"));
                tmp.setRg(consulta.getString("RG"));
                tmp.setIdCliente(consulta.getInt("Id_Cliente"));
                lista.add(tmp);
                
           }
           return lista;
       
       }catch(SQLException ex){
           ex.printStackTrace();
           return null;
       }
   
   }
   
   
    public List<Cliente> Buscar(Cliente filtro) throws ErroValidacaoException, Exception{
        try{
            String sql = "SELECT c.id as Id_Cliente, p.id as "
                   + "Id_Pessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM Pessoa p INNER "
                   + "JOIN Clientes c on c.iSd_pessoa = p.id";
            String where = "";
            
            if(!filtro.getNome().isEmpty()){
                where = "nome like'%"+filtro.getNome()+"%'";
            
            }
        
           
            if(filtro.getCpf()!=0){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " cpf = "+filtro.getCpf();
            
            }
            //se tiver RG
            if(!filtro.getRg().isEmpty()){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " rg = "+filtro.getRg();
            }
            
            //se tiver Usuário USER
            
                        
            // se tiver o id Usuario
            if(filtro.getIdCliente() != 0){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " Id_Cliente = "+filtro.getIdCliente();
            
            }
            
            Statement comando = bd.getConexao().createStatement();
            ResultSet consulta = comando.executeQuery(sql);
            comando.getConnection().commit();
            
            List<Cliente> lista = null;
            if(consulta.first()){
                lista = new LinkedList<>();
                while(consulta.next()){
                    Cliente tmp = new Cliente();
                    
                tmp.setCpf(consulta.getInt("CPF"));
                tmp.setDataNascimento(consulta.getDate("Data_Nascimento"));
                tmp.setNome(consulta.getString("Nome"));
                tmp.setIdPessoa(consulta.getInt("Id_Pessoa"));
                tmp.setIdCliente(consulta.getInt("Id_Cliente"));
                tmp.setRg(consulta.getString("RG"));
                
                
                lista.add(tmp);
                    
                
                }
                
            }
            return lista;
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    }
    
    
}
