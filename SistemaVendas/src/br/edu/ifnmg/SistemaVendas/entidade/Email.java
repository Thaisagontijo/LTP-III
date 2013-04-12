/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import java.util.Objects;

public class Email {
   private int id;
   private String endereco;

    public Email(int id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }
     public Email(){
         
     }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.endereco);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "endereco=" + endereco + '}';
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    public void abrir(){
        
    }
    
    public void insere(){
        
    }
    
    public void alterar(){
        
    }
    
    public void remove(){
        
    }         
    
}
