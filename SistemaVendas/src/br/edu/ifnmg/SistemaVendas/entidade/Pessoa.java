/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import br.edu.ifnmg.SistemaVendas.entidade.Telefone;
import java.util.Date;
import java.util.List;

public class Pessoa {
    private int id;
    private String nome;
    private Date dataNascimento;       
    private int cpf;
    private String rg;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
    private List<Email> emails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    
    public void insere(){
        
    }
    
    public void alterar(){
        
    }
    
    public void remove(){
        
    }    
    
}
