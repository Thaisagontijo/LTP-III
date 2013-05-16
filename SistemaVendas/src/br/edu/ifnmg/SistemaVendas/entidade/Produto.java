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
 private int estoque;

 public Produto(){
        this.id = 0;
        this.descricao = "";
        this.nome = "";
        this.valor_unitario_compra = 0;
        this.valor_unitario_venda = 0;
        this.estoque = 0;
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

    public void setNome(String nome) throws Exception {
        if(nome.length()<3 && nome.length()> 250){
        this.nome = nome;}
        throw new Exception ("O nome tem que ser maior que 3 e menor que 250 caracteres");
        
        
    }

    public double getValor_unitario_compra() {
        return valor_unitario_compra;
    }

    public void setValor_unitario_compra(double valor_unitario_compra)throws Exception {
        if(valor_unitario_compra >=0){
         this.valor_unitario_compra = valor_unitario_compra;
}
        throw new Exception ("O valor tem que ser maior que 0");
        }

    public double getValor_unitario_venda() {
        return valor_unitario_venda;
    }

    public void setValor_unitario_venda(double valor_unitario_venda) throws Exception {
        if(valor_unitario_venda >=0){
         this.valor_unitario_venda = valor_unitario_venda;
}
        throw new Exception ("O valor tem que ser maior que 0");
        }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) throws Exception {
        if(estoque >=0){
         this.estoque = estoque;
}
        throw new Exception ("A quantidade do estoque tem ser maior que 0");
        }
         
    public Produto(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.estoque;
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
        final Produto other = (Produto) obj;
        if (this.estoque != other.estoque) {
            return false;
        }
        return true;
    }
            
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor_unitario_venda=" + valor_unitario_venda + '}';
    }

    public Produto(int id, String descricao, String nome, double valor_unitario_compra, double valor_unitario_venda, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valor_unitario_compra = valor_unitario_compra;
        this.valor_unitario_venda = valor_unitario_venda;
        this.estoque = estoque;
    }

 
    
}
