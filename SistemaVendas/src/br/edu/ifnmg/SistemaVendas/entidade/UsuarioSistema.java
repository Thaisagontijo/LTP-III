/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

public class UsuarioSistema extends Pessoa{
    
    private int id;
    private String usuario;
    private String senha;
    
    public UsuarioSistema(){
        this.id = 0;
        this.usuario = "";
        this.senha = "";
    } 

    public UsuarioSistema(int id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioSistema{" + "usuario=" + usuario + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
