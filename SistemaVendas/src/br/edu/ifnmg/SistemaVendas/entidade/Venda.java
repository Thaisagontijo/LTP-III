/*
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Venda {
    private int id;
    private double valorTotal;
    private Date data;
    private UsuarioSistema usuarioSistema;
    private Cliente cliente;
    
    List<ItemVenda> itens;
    
            public Venda(){
                id = 0;
                valorTotal = 0;
                data = new Date();
                itens = new LinkedList<ItemVenda>();
            }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UsuarioSistema getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(UsuarioSistema usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Venda{" + "valorTotal=" + valorTotal + ", data=" + data + ", usuarioSistema=" + usuarioSistema + ", cliente=" + cliente + '}';
    }

    public Venda(int id, double valorTotal, Date data, UsuarioSistema usuarioSistema, Cliente cliente, List<ItemVenda> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.data = data;
        this.usuarioSistema = usuarioSistema;
        this.cliente = cliente;
        this.itens = itens;
    }
        
     public void add(ItemVenda i){
         if(!itens.contains(i)){
             itens.add(i);
             valorTotal += i.getProduto().getValor_unitario_venda() * i.getQuantidade();
         }
     }
     public void remove(ItemVenda i){
         if(!itens.contains(i)){
             itens.add(i);
             valorTotal -= i.getProduto().getValor_unitario_venda() * i.getQuantidade();
         }
     }
            
}
