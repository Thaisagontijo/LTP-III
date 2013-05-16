/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import java.util.Objects;

public class ItemVenda {
    private int id;
    private Produto produto;
    private int quantidade;
    private boolean ativo;

   public ItemVenda() {
        this.id = 0;
        this.produto = new Produto();
        this.quantidade = 0;
    }
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
 

    @Override
    public String toString() {
        return "ItemVenda{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.produto);
        hash = 31 * hash + this.quantidade;
        hash = 31 * hash + (this.ativo ? 1 : 0);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return true;
    }
    
    
}
