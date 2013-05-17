/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private Date dataNascimento;       
    private int cpf;
    private String rg;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
    private List<Email> emails;

    public Pessoa(int id, String nome, Date dataNascimento, int cpf, String rg, List<Endereco> enderecos, List<Telefone> telefones, List<Email> emails) {
        this.idPessoa = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.enderecos = enderecos;
        this.telefones = telefones;
        this.emails = emails;
    }
    public Pessoa(){
       this.idPessoa = 0;
        this.nome = "";
        this.dataNascimento = new Date();
        this.cpf = 0;
        this.rg = "";
        this.enderecos = new LinkedList<>();
        this.telefones = new LinkedList<>();
        this.emails = new LinkedList<>(); 
    }
           
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idPessoa;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.dataNascimento);
        hash = 11 * hash + this.cpf;
        hash = 11 * hash + Objects.hashCode(this.rg);
        hash = 11 * hash + Objects.hashCode(this.enderecos);
        hash = 11 * hash + Objects.hashCode(this.telefones);
        hash = 11 * hash + Objects.hashCode(this.emails);
        return hash;
    }
   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", rg=" + rg + '}';
    }

    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int id)throws ErroValidacaoException{
        if (idPessoa <0)
            throw new ErroValidacaoException("Id menor que 0!");
        else
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
/*        if(nome.length()<3 || nome.length()> 250){
        
        throw new Exception ("O nome tem que ser maior que 3 e menor que 250 caracteres");
        }else{
             this.nome = nome;}
  */          
         //lembrar de corrigir
        this.nome = nome;
        }
        


    public Date getDataNascimento() {
        return dataNascimento;
    }

     public void setDataNascimento(Date datanascimento) throws Exception{
        Date dataMinima = new Date("1990/01/01");
        if(!dataNascimento.before(dataMinima)) {
            this.dataNascimento = dataNascimento;
        }
        else {
            throw new Exception ("Data de Nascimento Inválida. A data deve ser superior ou igual a 01/01/1900");
        }

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    
    public void addTelefone(Telefone telefone){
        if(!this.telefones.equals(telefone)){
        this.telefones.add(telefone);
    }
    }
    public void removeTelefone(Telefone telefone){
        if(!this.telefones.equals(telefone)){
        telefones.remove(telefone);
    }
    }
    public void addEndereco(Endereco endereco){
        if(!this.enderecos.equals(endereco)){
        enderecos.add(endereco);
    }
    }
    public void removeEndereco(Endereco endereco){
        if(this.enderecos.equals(endereco)){
        enderecos.remove(endereco);
    }
    }
    public void addEmail(Email email){
        if(!this.emails.equals(email)){
        emails.add(email);
    }
    }
    public void removeEmail(Email email){
        if(this.emails.equals(email)){
        emails.remove(email);
    }
    }
      
    
}
