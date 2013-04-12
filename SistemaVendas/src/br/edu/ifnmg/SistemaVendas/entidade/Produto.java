/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

public class Produto {
 private int id;
 private String descricao;
 private String nome;
 private double valor_unitario_compra;
 private double valor_unitario_venda;

 public Produto(){
    
}
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor_unitario_compra() {
        return valor_unitario_compra;
    }

    public void setValor_unitario_compra(double valor_unitario_compra) {
        this.valor_unitario_compra = valor_unitario_compra;
    }

    public double getValor_unitario_venda() {
        return valor_unitario_venda;
    }

    public void setValor_unitario_venda(double valor_unitario_venda) {
        this.valor_unitario_venda = valor_unitario_venda;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor_unitario_venda=" + valor_unitario_venda + '}';
    }

    public Produto(int id, String descricao, String nome, double valor_unitario_compra, double valor_unitario_venda) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valor_unitario_compra = valor_unitario_compra;
        this.valor_unitario_venda = valor_unitario_venda;
    }
 
 
    
}
