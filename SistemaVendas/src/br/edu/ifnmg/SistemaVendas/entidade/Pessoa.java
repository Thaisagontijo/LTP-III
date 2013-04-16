/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;
    private Date dataNascimento;       
    private int cpf;
    private String rg;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
    private List<Email> emails;

    public Pessoa(int id, String nome, Date dataNascimento, int cpf, String rg, List<Endereco> enderecos, List<Telefone> telefones, List<Email> emails) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.enderecos = enderecos;
        this.telefones = telefones;
        this.emails = emails;
    }
    public Pessoa(){
        
    }
           
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
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
        if (this.id != other.id) {
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

    
    public int getId() {
        return id;
    }

    public void setId(int id)throws ErroValidacaoException{
        if (id <0)
            throw new ErroValidacaoException("Id menor que 0!");
        else
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome.length()>3 || nome.length()< 250){
         this.nome = nome;}
        throw new Exception ("O nome tem que ser maior que 3 e menor que 250 caracteres");
        }
        


    public Date getDataNascimento() {
        return dataNascimento;
    }

     public void setDataNascimento(Date datanascimento) throws Exception{
        SimpleDateFormat dtNascimento = new SimpleDateFormat("dd/MM/yyyy");
        Date data = dtNascimento.parse("01/01/1900"); 
        
        if (datanascimento.after(data)){
            this.dataNascimento = dataNascimento;
        } else {
            throw new Exception("Data de Nascimento Inválida. A data deve ser superior ou igual a 01/01/1900.");
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
        this.telefones.add(telefone);
    }
    
    public void removeTelefone(Telefone telefone){
        telefones.remove(telefone);
    }
    
    public void addEndereco(Endereco endereco){
        enderecos.add(endereco);
    }
    
    public void removeEndereco(Endereco endereco){
        enderecos.remove(endereco);
    }
    
    public void addEmail(Email email){
        emails.add(email);
    }
    
    public void removeEmail(Email email){
        emails.remove(email);
    }
    
      
    
}
