/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

public class ItemVenda {
    private int id;
    private Produto produto;
    private int quantidade;

    public ItemVenda(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade)throws Exception {
        if(quantidade >0){
          this.quantidade = quantidade;
}
        throw new Exception ("O valor tem que ser maior que 0");
        }
 

    @Override
    public String toString() {
        return "ItemVenda{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
    
}
