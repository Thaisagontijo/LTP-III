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
    private FormadePagamento formadepagamento;
    private boolean ok;
    List<ItemVenda> itens;
    
            public Venda(){
                this.id = 0;
                this.valorTotal = 0;
                this.data = new Date();
                this.itens = new LinkedList<ItemVenda>();
                this.formadepagamento = new FormadePagamento();
                this.cliente = new Cliente();
                this.usuarioSistema = new UsuarioSistema();
                this.ok= true;
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

    public FormadePagamento getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(FormadePagamento formadepagamento) {
        this.formadepagamento = formadepagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "Venda{" + "valorTotal=" + valorTotal + ", data=" + data + ", usuarioSistema=" + usuarioSistema + ", cliente=" + cliente + ", formadepagamento=" + formadepagamento + '}';
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

    public Venda(int id, double valorTotal, Date data, UsuarioSistema usuarioSistema, Cliente cliente, FormadePagamento formadepagamento, List<ItemVenda> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.data = data;
        this.usuarioSistema = usuarioSistema;
        this.cliente = cliente;
        this.formadepagamento = formadepagamento;
        this.itens = itens;
    }
            
}
