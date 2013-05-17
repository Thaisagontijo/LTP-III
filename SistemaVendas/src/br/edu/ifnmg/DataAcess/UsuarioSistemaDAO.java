/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.DataAcess;

import br.edu.ifnmg.SistemaVendas.entidade.Email;
import br.edu.ifnmg.SistemaVendas.entidade.Endereco;
import br.edu.ifnmg.SistemaVendas.entidade.ErroValidacaoException;
import br.edu.ifnmg.SistemaVendas.entidade.Pessoa;
import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import br.edu.ifnmg.SistemaVendas.entidade.UsuarioSistema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class UsuarioSistemaDAO {
    private BD banco;
    
    public UsuarioSistemaDAO() throws SQLException{
        banco = new BD();
    }
    
    public boolean Salvar(UsuarioSistema obj) throws ErroValidacaoException, Exception{
        try{
            
            PessoaDAO dao = new PessoaDAO();
            Pessoa tempPessoa = new Pessoa();
            
            tempPessoa.setCpf(obj.getCpf());
            tempPessoa.setDataNascimento(obj.getDataNascimento());
            tempPessoa.setEmails(obj.getEmails());
            tempPessoa.setEnderecos(obj.getEnderecos());
            tempPessoa.setNome(obj.getNome());
            tempPessoa.setRg(obj.getRg());
            tempPessoa.setTelefones(obj.getTelefones());
            
            int id = dao.Salvar(tempPessoa);
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("INSERT INTO Usuarios_Sistema (Usuario,Senha, Id_Pessoa) VALUES(?,?,?)");
            comando.setString(1, obj.getUsuario());
            comando.setString(2, obj.getSenha());
            comando.setInt(3, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public UsuarioSistema Abrir(int id) throws Exception{
        UsuarioSistema usuario_sistema = null;
        try{
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("select p.id as Id_Usuarios_Sistema,p.id as"
                    +"Id_Pessoa,p.nome,p.cpf,p.rg,p.data_nascimento, u.id as Id_Usuario FROM Pessoa p INNER "
                    +"JOIN Usuarios_Sistema u on u.Id_Pessoa = p.id WHERE u.id = ?");
            

            comando.setInt(1, id);
            
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            if(consulta.first()){
                usuario_sistema = new UsuarioSistema();
                usuario_sistema.setCpf(consulta.getInt("cpf"));
                usuario_sistema.setDataNascimento(consulta.getDate("data_nascimento"));
                usuario_sistema.setId(id);
                usuario_sistema.setNome(consulta.getString("Nome"));
                usuario_sistema.setRg(consulta.getString("RG"));
                usuario_sistema.setId(consulta.getInt("Id_Usuario"));
                
                
                //Preencher telefones
                PreparedStatement comando2 = banco.getConexao()
                        .prepareStatement("SELECT * from Telefones WHERE Id_Pessoa = ?");
                comando2.setInt(1, usuario_sistema.getId());
                
                ResultSet consulta2 = comando2.executeQuery();
                comando2.getConnection().commit();
                
                List<Telefone> listaTelefone = new LinkedList<>();
                while(consulta2.next()){
                    Telefone temp = new Telefone();
                    temp.setId(consulta2.getInt("Id"));
                    temp.setDdd(consulta2.getInt("DDD"));
                    temp.setNumero(consulta2.getInt("Numero"));
                    listaTelefone.add(temp);
                    
                }
                usuario_sistema.setTelefones(listaTelefone);
                
                //Preencher Enderecos
                PreparedStatement comando3 = banco.getConexao()
                        .prepareStatement("SELECT * from Enderecos WHERE Id_Pessoa = ?");
                comando3.setInt(1, usuario_sistema.getId());
                
                ResultSet consulta3 = comando3.executeQuery();
                comando3.getConnection().commit();
                
                List<Endereco> listaEnderecos = new LinkedList<>();
                while(consulta3.next()){
                    Endereco endereco = new Endereco();
                    endereco.setBairro(consulta3.getString("Bairro"));
                    endereco.setCep(consulta3.getInt("Cep"));
                    endereco.setCidade(consulta3.getString("Cidade"));
                    endereco.setEstado(consulta3.getString("Estado"));
                    endereco.setId(consulta3.getInt("Id_Endereco"));
                    endereco.setNumero(Integer.parseInt(consulta3.getString("Numero")));
                    endereco.setRua(consulta3.getString("Rua"));
                    listaEnderecos.add(endereco);
                    
                    
                }
                
                usuario_sistema.setEnderecos(listaEnderecos);
                
                //Preenche emails
                PreparedStatement comando4 = banco.getConexao()
                        .prepareStatement("SELECT * FROM Emails WHERE Id_Pessoa = ?");
                comando4.setInt(1, usuario_sistema.getId());
                
                ResultSet consulta4 = comando4.executeQuery();
                comando4.getConnection().commit();
                List<Email> listaEmails = new LinkedList<>();
                while(consulta4.next()){
                    Email temp = new Email();
                    temp.setEndereco(consulta4.getString("Endereco"));
                    temp.setId(consulta4.getInt("Id"));
                    listaEmails.add(temp);
                    
                }
                usuario_sistema.setEmails(listaEmails);
                
                
            }
            
            return usuario_sistema;    
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    
    
    
    
    public boolean Apagar(int id){
        try{
           EmailDAO emailDAO = new EmailDAO();
           TelefoneDAO telefoneDAO= new TelefoneDAO();
           EnderecoDAO enderecoDAO = new EnderecoDAO();
           PessoaDAO pessoaDAO = new PessoaDAO();
           
           emailDAO.ApagarTodosQuandoExcluiPessoa(id);
           telefoneDAO.ApagarTodosQuandoExcluiPessoa(id);
           enderecoDAO.ApagarTodosQuandoExcluiPessoa(id);
           pessoaDAO.Apagar(id);
           
           PreparedStatement comando = banco
                   .getConexao().prepareStatement("DELETE FROM Usuarios_Sistema WHERE Id_Usuario = ?");
           comando.setInt(1, id);
           comando.execute();
           comando.getConnection().commit();
           
           return true;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    
    
    public List<UsuarioSistema> listarTodos() throws ErroValidacaoException, Exception{
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("select p.id as idpessoa,nome,cpf,rg,"
                    + "data_nascimento,u.id as idusuario, usuario from pessoas "
                    + "p inner join usuarios_sistema u on u.id_pessoa = p.id");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<UsuarioSistema> Lista = new LinkedList<>();
            
            while(consulta.next()){
                UsuarioSistema tmp = new UsuarioSistema();
                tmp.setCpf(consulta.getInt("CPF"));
                tmp.setDataNascimento(consulta.getDate("Data_Nascimento"));
                tmp.setNome(consulta.getString("Nome"));
                tmp.setId(consulta.getInt("Id_Pessoa"));
                tmp.setId(consulta.getInt("Id_Usuario"));
                tmp.setRg(consulta.getString("RG"));
                tmp.setUsuario(consulta.getString("Usuario"));
                
                Lista.add(tmp);
                
            
            }
            return Lista;
                    
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
    public List<UsuarioSistema> Buscar(UsuarioSistema filtro) throws ErroValidacaoException, Exception{
        try{
            String sql = "select p.id as Id_Pessoa,Nome,CPF,RG,"
                    + "Data_Nascimento,u.id as idusuario, Usuario from Pessoa "
                    + "p inner join Usuarios_Sistema u on u.id_pessoa = p.id";
            String where = "";
            
            if(!filtro.getNome().isEmpty()){
                where = "Nome like'%"+filtro.getNome()+"%'";
            
            }
            
            //se tiver um cpf
            if(filtro.getCpf()!=0){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " CPF = "+filtro.getCpf();
            
            }
            //se tiver RG
            if(!filtro.getRg().isEmpty()){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " RG = "+filtro.getRg();
            }
            
            //se tiver Usuário USER
            
            if(!filtro.getUsuario().isEmpty()){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " usuario = "+filtro.getUsuario();
            }
            
            // sentiver o id Usuario
            if(filtro.getId() != 0){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " Id_Usuario = "+filtro.getId();
            
            }
            
            Statement comando = banco.getConexao().createStatement();
            ResultSet consulta = comando.executeQuery(sql);
            comando.getConnection().commit();
            
            List<UsuarioSistema> lista = null;
            if(consulta.first()){
                lista = new LinkedList<>();
                while(consulta.next()){
                    UsuarioSistema tmp = new UsuarioSistema();
                    
                tmp.setCpf(consulta.getInt("CPF"));
                tmp.setDataNascimento(consulta.getDate("Data_Nascimento"));
                tmp.setNome(consulta.getString("Nome"));
                tmp.setId(consulta.getInt("Id_Pessoa"));
                tmp.setId(consulta.getInt("IdUsuario"));
                tmp.setRg(consulta.getString("RG"));
                tmp.setUsuario(consulta.getString("Usuario"));
                
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
