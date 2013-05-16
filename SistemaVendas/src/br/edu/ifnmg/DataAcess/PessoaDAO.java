/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.Email;
import br.edu.ifnmg.SistemaVendas.entidade.Endereco;
import br.edu.ifnmg.SistemaVendas.entidade.Pessoa;
import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO {
   private BD banco;
    
    public PessoaDAO() throws SQLException{
        this.banco = new BD();
    }
    
    public int Salvar(Pessoa obj){
        PreparedStatement comando = null;
        int id = 0;
        try{
            if(obj.getIdPessoa() == 0){
               comando = banco.getConexao()
                        .prepareStatement("INSERT INTO Pessoa (Nome,RG,CPF,Data_Nascimento) VALUES (?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setInt(3, obj.getCpf());
                Date dataBd = new Date(obj.getDataNascimento().getTime());
                comando.setDate(4, dataBd);
                              
                comando.executeUpdate();
                PreparedStatement comando2 = banco.getConexao().prepareStatement("SELECT MAX(Id_Pessoa) FROM Pessoa");
                ResultSet consulta = comando2.executeQuery();
                consulta.first();
                id = consulta.getInt("MAX(id_Pessoa)");
                comando.getConnection().commit(); //verificar
                //Inserindo os enderecos
                
                if(!obj.getEnderecos().isEmpty()){
                    List<Endereco> listaEnderecos = obj.getEnderecos();
                    EnderecoDAO daoEndereco = new EnderecoDAO();


                    for(Endereco e : listaEnderecos){
                        daoEndereco.Salvar(e, id);


                    }
                }
                
                // Inserindo os telefones
                
                if(!obj.getTelefones().isEmpty()){
                    List<Telefone> listaTelefone = obj.getTelefones();
                    TelefoneDAO daoTelefone = new TelefoneDAO();
                    
                    for(Telefone t : listaTelefone){
                        daoTelefone.Salvar(t,id);
                    }
                
                
                }
                
                //Inserindo os Emails
                
                if(!obj.getEmails().isEmpty()){
                    List<Email> listaEmails = obj.getEmails();
                    EmailDAO daoEmail = new EmailDAO();
                    
                    for(Email e : listaEmails){
                        daoEmail.Salvar(e, id);
                    }
                }
                
                
                
                //comando.getConnection().commit();
                comando2.getConnection().commit();
                
            
            }else{
                comando = banco.getConexao()
                        .prepareStatement("UPDADE Pessoa SET Nome = ?, RG = ?, CPF = ?,Data_Nascimento = ? WHERE Id_Pessoa = ?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getRg());
                comando.setInt(3, obj.getCpf());
                comando.setInt(5, obj.getIdPessoa());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            
            }
            return id;
           }catch(SQLException ex){
                ex.printStackTrace();
                
                return 0;
            }
        
    }
    
    public Pessoa Abrir(int id) throws Exception{
        Pessoa pessoa = null;
        try{
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM Pessoa WHERE Id_Pessoa = ?");
            comando.setInt(1, id);
            
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            if(consulta.first()){
                pessoa = new Pessoa();
                pessoa.setCpf(consulta.getInt("CPF"));
                pessoa.setDataNascimento(consulta.getDate("Data_Nascimento"));
                pessoa.setIdPessoa(consulta.getInt("Id_Pessoa"));
                pessoa.setNome(consulta.getString("Nome"));
                pessoa.setRg(consulta.getString("RG"));
                //asd conferr a data
                
                //Preencher telefones
                PreparedStatement comando2 = banco.getConexao()
                        .prepareStatement("SELECT * from Telefones WHERE Id_Pessoa = ?");
                comando2.setInt(1, id);
                
                ResultSet consulta2 = comando2.executeQuery();
                comando2.getConnection().commit();
                
                List<Telefone> listaTelefone = new LinkedList<>();
                while(consulta2.next()){
                    Telefone temp = new Telefone();
                    temp.setId(consulta2.getInt("Id_Telefone"));
                    temp.setDdd(consulta2.getInt("DDD"));
                    temp.setNumero(consulta2.getInt("Numero"));
                    listaTelefone.add(temp);
                    
                }
                pessoa.setTelefones(listaTelefone);
                
                //Preencher Enderecos
                PreparedStatement comando3 = banco.getConexao()
                        .prepareStatement("SELECT * from Enderecos WHERE Id_Pessoa = ?");
                comando3.setInt(1, id);
                
                ResultSet consulta3 = comando3.executeQuery();
                comando3.getConnection().commit();
                
                List<Endereco> listaEnderecos = new LinkedList<>();
                while(consulta3.next()){
                    Endereco endereco = new Endereco();
                    endereco.setBairro(consulta3.getString("Bairro"));
                    endereco.setCep(consulta3.getInt("CEP"));
                    endereco.setCidade(consulta3.getString("Cidade"));
                    endereco.setEstado(consulta3.getString("Estado"));
                    endereco.setId(consulta3.getInt("Id_Endereco"));
                    endereco.setNumero(Integer.parseInt(consulta3.getString("Numero")));
                    endereco.setRua(consulta3.getString("Rua"));
                    endereco.setComplemento(consulta.getString("Complemento"));
                    listaEnderecos.add(endereco);
                    
                    
                }
                
                pessoa.setEnderecos(listaEnderecos);
                
                //Preenche emails
                PreparedStatement comando4 = banco.getConexao()
                        .prepareStatement("SELECT * FROM Emails WHERE Id_Pessoa = ?");
                comando4.setInt(1, id);
                
                ResultSet consulta4 = comando4.executeQuery();
                comando4.getConnection().commit();
                List<Email> listaEmails = new LinkedList<>();
                while(consulta4.next()){
                    Email temp = new Email();
                    temp.setEndereco(consulta4.getString("Endereco"));
                    temp.setId(consulta4.getInt("Id_Email"));
                    listaEmails.add(temp);
                    
                }
                pessoa.setEmails(listaEmails);
                
                
            }
            
            return pessoa;    
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    
    public boolean Apagar(int id){
       // boolean ok = false;
        try{
           EmailDAO emailDAO = new EmailDAO();
           TelefoneDAO telefoneDAO= new TelefoneDAO();
           EnderecoDAO enderecoDAO = new EnderecoDAO();
                      
           emailDAO.ApagarTodosQuandoExcluiPessoa(id);
           telefoneDAO.ApagarTodosQuandoExcluiPessoa(id);
           enderecoDAO.ApagarTodosQuandoExcluiPessoa(id);
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM Pessoa WHERE id_Pessoa = ?");
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    
    }
 
}
